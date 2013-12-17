package com.flow.emag.api.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import com.flow.emag.api.entity.ApiLogEntity;
import com.flow.emag.api.model.ApiLog;
import com.flow.emag.api.model.EmagResource;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Util {

	private static MessageDigest md = null;

	private static Gson GSON = new GsonBuilder().setFieldNamingPolicy(
			FieldNamingPolicy.UPPER_CAMEL_CASE).excludeFieldsWithoutExposeAnnotation().create();

	private static Gson GSON_FULL = new GsonBuilder().setFieldNamingPolicy(
			FieldNamingPolicy.UPPER_CAMEL_CASE).create();

	
	private static Type MAP_TYPE = new TypeToken<Map<String, Object>>() {
	}.getType();

	static {
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String sha1(String input) {
		return byteArrayToHexString(md.digest(input.getBytes()));
	}

	public static String byteArrayToHexString(byte[] b) {

		String result = "";

		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}

		return result;
	}

	public static String mapToJson(Map<String, Object> map) {
		return GSON.toJson(map);
	}

	public static Map<String, Object> jsonToMap(String json) {
		return GSON.fromJson(json, MAP_TYPE);
	}

	public static String objectToJson(Object obj) {
		return GSON.toJson(obj);
	}

	public static ApiLogEntity createApiLog(String resource, String action,
			String inputJSON) {
		ApiLogEntity apiLog = new ApiLogEntity();
		apiLog.setEmagResource(resource);
		apiLog.setAction(action);
		apiLog.setStartTime(new Date());
		apiLog.setInputJson(inputJSON);
		apiLog.setException("");
		apiLog.setResponseJson("");		
		return apiLog;
	}

	public static String exceptionToString(Exception e) {
		StringBuffer sb = new StringBuffer(e.getClass().getName());
		sb.append(" -> ").append(e.getMessage()).append("\n");

		StackTraceElement[] stack = e.getStackTrace();

		for (StackTraceElement trace : stack) {
			sb.append(trace.toString()).append("\n");
		}

		return sb.toString();
	}

	public static String serializePostData(Object input,
			Map<String, Object> extraParams) {

		if (input != null) {

			if (input instanceof List) {
				List list = (List) input;
				List<Map<String, Object>> aux = new ArrayList<Map<String, Object>>();

				for (Object obj : list) {
					String json = GSON.toJson(obj);
					Map<String, Object> resourceMap = GSON.fromJson(json,
							MAP_TYPE);
					aux.add(resourceMap);
				}

				List<String> baseParam = new ArrayList<String>();

				return buildUrlFromCollection(baseParam, aux, "UTF-8");
			} else {
				String json = GSON_FULL.toJson(input);
				Map<String, Object> resourceMap = GSON_FULL.fromJson(json, MAP_TYPE);
				resourceMap.putAll(extraParams);
				return httpBuildQuery(resourceMap, "UTF-8");
			}

		} else {
			return httpBuildQuery(extraParams, "UTF-8");
		}

	}

	public static String serialize(Map<String, Object> postParams,
			Map<String, Object> extraDataParams) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.putAll(postParams);

		if (extraDataParams != null) {
			dataMap.put("data", extraDataParams);
		}

		return httpBuildQuery(dataMap, "UTF-8");
	}

	public static String getEmagResourceName(Class resourceClass) {
		EmagResource emag = (EmagResource) resourceClass
				.getAnnotation(EmagResource.class);
		return emag.name();
	}

	public static String serialize(Object inputObject,
			Map<String, Object> postParams, Map<String, Object> extraDataParams) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.putAll(postParams);

		if (inputObject instanceof List) {
			List<Object> list = new ArrayList<Object>();
			List inputList = (List) inputObject;

			for (Object obj : inputList) {
				String json = GSON.toJson(obj);
				Map<String, Object> resourceMap = GSON.fromJson(json, MAP_TYPE);
				list.add(resourceMap);
			}

			System.out.println(list);
			dataMap.put("data", list);
		} else {
			String json = GSON.toJson(inputObject);
			Map<String, Object> resourceMap = GSON.fromJson(json, MAP_TYPE);
			dataMap.put("data", resourceMap);
		}

		StringBuilder sb = new StringBuilder(httpBuildQuery(dataMap, "UTF-8"));

		if (extraDataParams != null) {
			Map<String, Object> extraDataMap = new HashMap<String, Object>();
			extraDataMap.put("data", extraDataParams);
			
			if(!sb.toString().endsWith("&")){
				sb.append('&');
			}
			
			sb.append(httpBuildQuery(extraDataMap, "UTF-8"));
		}

		return sb.toString();
	}

	public static String httpBuildQuery(Map<String, Object> params,
			String encoding) {
		if (isEmpty(encoding)) {
			encoding = "UTF-8";
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (sb.length() > 0) {
				
				if(!sb.toString().endsWith("&")){
					sb.append('&');
				}				
			}

			String name = entry.getKey();
			Object value = entry.getValue();

			if (value instanceof Map) {
				List<String> baseParam = new ArrayList<String>();
				baseParam.add(name);
				String str = buildUrlFromMap(baseParam, (Map) value, encoding);
				sb.append(str);

			} else if (value instanceof Collection) {
				List<String> baseParam = new ArrayList<String>();
				baseParam.add(name);
				String str = buildUrlFromCollection(baseParam,
						(Collection) value, encoding);
				sb.append(str);

			} else {
				sb.append(encodeParam(name));
				sb.append("=");
				sb.append(encodeParam(value));
			}
		}

		return sb.toString();
	}

	private static String buildUrlFromMap(List<String> baseParam,
			Map<Object, Object> map, String encoding) {
		StringBuilder sb = new StringBuilder();
		String token;

		for (Map.Entry<Object, Object> entry : map.entrySet()) {

			if (sb.length() > 0) {
				if(!sb.toString().endsWith("&")){
					sb.append('&');
				}				
			}

			String name = String.valueOf(entry.getKey());
			Object value = entry.getValue();
			if (value instanceof Map) {
				List<String> baseParam2 = new ArrayList<String>(baseParam);
				baseParam2.add(name);
				String str = buildUrlFromMap(baseParam2, (Map) value, encoding);
				sb.append(str);

			} else if (value instanceof List) {
				List<String> baseParam2 = new ArrayList<String>(baseParam);
				baseParam2.add(name);
				String str = buildUrlFromCollection(baseParam2, (List) value,
						encoding);
				sb.append(str);
			} else {
				token = getBaseParamString(baseParam) + encodeParam("[") + name
						+ encodeParam("]") + "=" + encodeParam(value);
				sb.append(token);
			}
		}

		return sb.toString();
	}

	private static String buildUrlFromCollection(List<String> baseParam,
			Collection coll, String encoding) {
		StringBuilder sb = new StringBuilder();
		String token;
		if (!(coll instanceof List)) {
			coll = new ArrayList(coll);
		}
		List arrColl = (List) coll;

		// Build string of first level - related with params of provided Map
		for (int i = 0; i < arrColl.size(); i++) {

			if (sb.length() > 0) {
				if(!sb.toString().endsWith("&")){
					sb.append('&');
				}
			}

			Object value = (Object) arrColl.get(i);
			if (value instanceof Map) {
				List<String> baseParam2 = new ArrayList<String>(baseParam);
				baseParam2.add(String.valueOf(i));
				String str = buildUrlFromMap(baseParam2, (Map) value, encoding);
				sb.append(str);

			} else if (value instanceof List) {
				List<String> baseParam2 = new ArrayList<String>(baseParam);
				baseParam2.add(String.valueOf(i));
				String str = buildUrlFromCollection(baseParam2, (List) value,
						encoding);
				sb.append(str);
			} else {
				token = getBaseParamString(baseParam) + encodeParam("[") + i
						+ encodeParam("]") + "=" + encodeParam(value);
				sb.append(token);
			}
		}
				
		
		return sb.toString();
	}

	private static String getBaseParamString(List<String> baseParam) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < baseParam.size(); i++) {
			String s = baseParam.get(i);
			if (i == 0) {
				sb.append(s);
			} else {
				sb.append(encodeParam("[") + s + encodeParam("]"));
			}
		}
		return sb.toString();
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	private static String encodeParam(Object param) {
		try {
			return URLEncoder.encode(String.valueOf(param), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return URLEncoder.encode(String.valueOf(param));
		}
	}
	
	public static String getJsonFromReponse(HttpResponse response) throws IllegalStateException, IOException{

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuffer json = new StringBuffer();
		
		while ((line = rd.readLine()) != null) {			
			json.append(line);			
		}
		
		return json.toString();
	}
}
