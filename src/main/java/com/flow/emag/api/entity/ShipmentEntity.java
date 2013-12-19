package com.flow.emag.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "shipments" )
public class ShipmentEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="awb_number")
	private String awb_number;
	
	@Column(name="create_date")
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAwb_number() {
		return awb_number;
	}

	public void setAwb_number(String awb_number) {
		this.awb_number = awb_number;
	}

	public String getDate() {
		return createDate;
	}

	public void setDate(String date) {
		this.createDate = date;
	}

	@Override
	public String toString() {
		return "Shipment [id=" + id + ", awb_number=" + awb_number + ", date="
				+ createDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((awb_number == null) ? 0 : awb_number.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ShipmentEntity other = (ShipmentEntity) obj;
		if (awb_number == null) {
			if (other.awb_number != null)
				return false;
		} else if (!awb_number.equals(other.awb_number))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
