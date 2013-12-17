package com.flow.emag.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@EmagResource(name="image")
public class Image {

	@SerializedName("id")
	@Expose
	private String id;
	
	@SerializedName("display_type")
	@Expose
	private String displayType;
		
	@SerializedName("status")
	@Expose
	private String status;
		
	@SerializedName("url")
	@Expose
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", displayType=" + displayType + ", status="
				+ status + ", url=" + url + "]";
	}

	
}
