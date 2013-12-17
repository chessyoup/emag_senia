package com.flow.emag.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "products" )
public class ProductEntity {
				
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	/**
	 * Emag internal id for this product
	 */
	@Column(name="emag_id")
	private String emagId;
	
	/**
	 * Manufacturer unique identifier of the product
	 */
	@Column(name="part_number")	
	public String number;
	
	/**
	 * Product name
	 */
	@Column
	public String name;
	
	/**
	 * Product short description
	 */
	@Column(name="short_description")
	public String shortDescription;
	
	/**
	 * Product description
	 */
	@Column
	public String description;
	
	/**
	 * Product category
	 */
	@OneToOne(cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	public CategoryEntity category;
	
	/**
	 * Product images
	 */
	@OneToMany(mappedBy="product",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)	
	public List<ImageEntity> images;
	
	/**
	 * Product brand
	 */
	@OneToOne(cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	public BrandEntity brand;
	
	/**
	 * Product charateriscs
	 */
	@OneToMany(mappedBy="product",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)	
	public List<ProductCharacteristicValueEntity> characteristics;

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

	public List<ProductCharacteristicValueEntity> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(
			List<ProductCharacteristicValueEntity> characteristics) {
		this.characteristics = characteristics;
	}

	public CategoryEntity getCategory() {
		return this.category;
	}


	public void setCategory(CategoryEntity category) {
		this.category = category;
	}


	public BrandEntity getBrand() {		
		return this.brand;
	}


	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}
	
	public List<ImageEntity> getImages() {
		return images;
	}

	public void setImages(List<ImageEntity> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", emagId=" + emagId + ", number="
				+ number + ", name=" + name + ", shortDescription="
				+ shortDescription + ", description=" + description
				+ ", category=" + category + ", images=" + images + ", brand="
				+ brand + ", characteristics=" + characteristics + "]";
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
		result = prime * result + ((images == null) ? 0 : images.hashCode());
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
		ProductEntity other = (ProductEntity) obj;
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
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
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
