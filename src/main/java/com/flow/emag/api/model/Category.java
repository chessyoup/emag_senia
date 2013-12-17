package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@EmagResource(name="category")
public class Category {
	
	private Long id;	    
	
	@SerializedName("emag_id")
	@Expose
	private String emagId;
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("characteristics")
	@Expose
	private List<CategoryCharacteristic> characteristics;

	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmagId() {
		return emagId;
	}

	public void setEmagId(String emagId) {
		this.emagId = emagId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryCharacteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<CategoryCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((characteristics == null) ? 0 : characteristics.hashCode());
		result = prime * result + ((emagId == null) ? 0 : emagId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (characteristics == null) {
			if (other.characteristics != null)
				return false;
		} else if (!characteristics.equals(other.characteristics))
			return false;
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
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", emagId=" + emagId + ", name=" + name
				+ ", characteristics=" + characteristics + "]";
	}
}
