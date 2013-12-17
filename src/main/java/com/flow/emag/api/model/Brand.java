package com.flow.emag.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@EmagResource(name="brand")
public class Brand {
	
	@Expose
	@SerializedName("id")
	private String id;	    
		
	public String emagId;
	
	@SerializedName("name")
	@Expose
	public String name;
	
	@SerializedName("url")
	@Expose
	public String url;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emagId == null) ? 0 : emagId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Brand other = (Brand) obj;
		if (emagId == null) {
			if (other.emagId != null)
				return false;
		} else if (!emagId.equals(other.emagId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", emagId=" + emagId + ", name=" + name
				+ ", url=" + url + "]";
	}

	public String getEmagId() {
		return emagId;
	}

	public void setEmagId(String emagId) {
		this.emagId = emagId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
