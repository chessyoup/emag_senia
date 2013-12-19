package com.flow.emag.api.client;

import java.util.Arrays;

import com.flow.emag.api.model.ResourceCount;
import com.google.gson.annotations.SerializedName;

public class ApiCountResponse {
	
	@SerializedName("isError")
	private String isError;
	
	@SerializedName("messages")
	private String[] messages;
	
	@SerializedName("results")
	private ResourceCount results;
	
	private String sourceJson;
	
	public String getIsError() {
		return isError;
	}

	public void setIsError(String isError) {
		this.isError = isError;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public ResourceCount getResults() {
		return results;
	}

	public void setResults(ResourceCount results) {
		this.results = results;
	}
	
	public String getSourceJson() {
		return sourceJson;
	}

	public void setSourceJson(String sourceJson) {
		this.sourceJson = sourceJson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isError == null) ? 0 : isError.hashCode());
		result = prime * result + Arrays.hashCode(messages);
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiCountResponse other = (ApiCountResponse) obj;
		if (isError == null) {
			if (other.isError != null)
				return false;
		} else if (!isError.equals(other.isError))
			return false;
		if (!Arrays.equals(messages, other.messages))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiCountResponse [isError=" + isError + ", messages="
				+ Arrays.toString(messages) + ", results=" + results + "]";
	}
		
}
