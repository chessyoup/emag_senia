package com.flow.emag.api.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.flow.emag.api.model.Product;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class ApiResponse<T> {
	
	@SerializedName("isError")
	private boolean isError;
	
	@SerializedName("messages")
	private String[] messages;
	
	@SerializedName("results")
	private List<T> results;
	
	private String sourceJson;
	
	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return "ApiResponse [isError=" + isError + ", messages="
				+ Arrays.toString(messages) + ", results=" + results + "]";
	}
	
	
	
	public String getSourceJson() {
		return sourceJson;
	}

	public void setSourceJson(String sourceJson) {
		this.sourceJson = sourceJson;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader r = new BufferedReader(new FileReader(new File("/home/leo/Desktop/Docs/product.json")));
		String line = null;
		StringBuffer json = new StringBuffer();
		
		while( (line = r.readLine()) != null ){
			json.append(line);
		}
		
		System.out.println(json.toString());
		
		Type fooType = new TypeToken<ApiResponse<Product>>() {}.getType();
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		ApiResponse<Product> response =  gson.fromJson(json.toString(), fooType);
		System.out.println(response.getResults().get(0).getName());		
	}
}
