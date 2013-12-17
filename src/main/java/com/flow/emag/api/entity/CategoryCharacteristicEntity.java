package com.flow.emag.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "category_characteristics" )
public class CategoryCharacteristicEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;	    
	
	@OneToOne
	private CategoryEntity category;
	
	/**
	 * Characteristic eMAG id, Integer emag_id=4478
	 */
	@Column(name="emag_id")	
	private Integer emagId;

	/**
	 * Characteristic name , String name=”Tip produs”
	 */
	@Column	
	private String name;

	/**
	 * Characteristic display order
	 */	
	@Column(name="display_order")	
	private Integer displayOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEmagId() {
		return emagId;
	}

	public void setEmagId(Integer emagId) {
		this.emagId = emagId;
	}

	public String getName() {
		return name;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public String toString() {
		return "CategoryCharacteristic [id=" + id + ", emagId=" + emagId
				+ ", name=" + name + ", displayOrder=" + displayOrder + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayOrder == null) ? 0 : displayOrder.hashCode());
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
		CategoryCharacteristicEntity other = (CategoryCharacteristicEntity) obj;
		if (displayOrder == null) {
			if (other.displayOrder != null)
				return false;
		} else if (!displayOrder.equals(other.displayOrder))
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
}
