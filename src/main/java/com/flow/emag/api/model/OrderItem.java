package com.flow.emag.api.model;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItem {
	
	@SerializedName("id")
	private String emagId;
			
	@SerializedName("product_id")
	@Expose
	private String productSeniaId;
	
	@SerializedName("part_number")
	@Expose
	private String partNumber;
		
	@SerializedName("quantity")
	@Expose
	private Integer quantity;
		
	@SerializedName("sale_price")
	@Expose
	private BigDecimal salePrice;
		
	@SerializedName("vat_rate")
	@Expose
	private BigDecimal vatRate;
	
	/**
	 * Ex: 2011-06-06 15:04:52
	 */	
	@SerializedName("created")
	@Expose
	private String created;
	
	/**
	 * Ex: 2011-06-06 15:04:52
	 */	
	@SerializedName("modified")
	@Expose
	private String modified;
		
	@SerializedName("currency")
	@Expose
	private String currency;
	
	@SerializedName("details")
	@Expose
	private List<String> details;
	/**
	 * Order status
	 * 1 - for OK ?
	 */	
	@SerializedName("status")
	@Expose
	private Integer status;
	public String getEmagId() {
		return emagId;
	}
	public void setEmagId(String emagId) {
		this.emagId = emagId;
	}
	public String getProductSeniaId() {
		return productSeniaId;
	}
	public void setProductSeniaId(String productSeniaId) {
		this.productSeniaId = productSeniaId;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderItem [emagId=" + emagId + ", productSeniaId="
				+ productSeniaId + ", partNumber=" + partNumber + ", quantity="
				+ quantity + ", salePrice=" + salePrice + ", vatRate="
				+ vatRate + ", created=" + created + ", modified=" + modified
				+ ", currency=" + currency + ", details=" + details
				+ ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((emagId == null) ? 0 : emagId.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result
				+ ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result
				+ ((productSeniaId == null) ? 0 : productSeniaId.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((salePrice == null) ? 0 : salePrice.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vatRate == null) ? 0 : vatRate.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (emagId == null) {
			if (other.emagId != null)
				return false;
		} else if (!emagId.equals(other.emagId))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		if (productSeniaId == null) {
			if (other.productSeniaId != null)
				return false;
		} else if (!productSeniaId.equals(other.productSeniaId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (salePrice == null) {
			if (other.salePrice != null)
				return false;
		} else if (!salePrice.equals(other.salePrice))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (vatRate == null) {
			if (other.vatRate != null)
				return false;
		} else if (!vatRate.equals(other.vatRate))
			return false;
		return true;
	}			
}	
