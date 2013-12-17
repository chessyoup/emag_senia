package com.flow.emag.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductsCharacteristic {
	
	@SerializedName("id")
	private Long id;
		
	/**
	 * Product characteristic eMAG id,  Integer emag_id=4478
	 */	
	@SerializedName("emag_id")
	@Expose
	private String emagId;
		
	@SerializedName("characteristic_value")
	@Expose
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	@Override
	public String toString() {
		return "ProductsCharacteristic [id=" + id + ", emagId=" + emagId
				+ ", value=" + value + "]";
	}

	
}
