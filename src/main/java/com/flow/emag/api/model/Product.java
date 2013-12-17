package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@EmagResource(name="product")
public class Product {
				
	@SerializedName("id")
	private String id;
		
	@SerializedName("emag_id")	
	private String emagId;
	
	/**
	 * Manufacturer unique identifier of the product
	 */
	@SerializedName("part_number")
	public String number;
	
	/**
	 * Product name
	 */	
	@SerializedName("name")	
	public String name;
	
	/**
	 * Product short description
	 */
	@SerializedName("short_description")	
	public String shortDescription;
	
	/**
	 * Product description
	 */
	@SerializedName("description")
	public String description;
	
	/**
	 * Product category
	 */
	@SerializedName("category")
	public Category category;
	
	/**
	 * Product brand
	 */
	@SerializedName("brand")	
	public Brand brand;
		
	@SerializedName("characteristics")	
	public List<ProductsCharacteristic> characteristics;
	
	@SerializedName("images")	
	public List<Image> images;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmagId() {
		return emagId;
	}

	public void setEmagId(String emagId) {
		this.emagId = emagId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<ProductsCharacteristic> getCharacteristics() {
		return characteristics;
	}


	public void setCharacteristics(List<ProductsCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", emagId=" + emagId + ", number="
				+ number + ", name=" + name + ", shortDescription="
				+ shortDescription + ", description=" + description
				+ ", category=" + category + ", brand=" + brand
				+ ", characteristics=" + characteristics + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((characteristics == null) ? 0 : characteristics.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((emagId == null) ? 0 : emagId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime
				* result
				+ ((shortDescription == null) ? 0 : shortDescription.hashCode());
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
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (characteristics == null) {
			if (other.characteristics != null)
				return false;
		} else if (!characteristics.equals(other.characteristics))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		return true;
	}	
}
