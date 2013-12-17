package com.flow.emag.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table( name = "order_items" )
public class OrderItem {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@SerializedName("id")
	private Long id;
	
	@OneToOne
	private Order order;
	
	/**
	 * Products emag id ?
	 */
	@Column(name="product_id")
	@SerializedName("product_emag_id")
	@Expose
	private Integer productEmagId;
	
	@Column
	@SerializedName("quantity")
	@Expose
	private Integer quantity;
	
	@Column(name="sale_price")
	@SerializedName("sale_price")
	@Expose
	private BigDecimal salePrice;
	
	@Column(name="vat_rate")
	@SerializedName("vat_rate")
	@Expose
	private BigDecimal vatRate;
	
	/**
	 * Ex: 2011-06-06 15:04:52
	 */
	@Column
	@SerializedName("created")
	@Expose
	private String created;
	
	/**
	 * Ex: 2011-06-06 15:04:52
	 */
	@Column
	@SerializedName("modified")
	@Expose
	private String modified;
			
	/**
	 * Order status
	 * 1 - for OK ?
	 */
	@Column
	@SerializedName("status")
	@Expose
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProductEmagId() {
		return productEmagId;
	}

	public void setProductEmagId(Integer productEmagId) {
		this.productEmagId = productEmagId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result
				+ ((productEmagId == null) ? 0 : productEmagId.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (productEmagId == null) {
			if (other.productEmagId != null)
				return false;
		} else if (!productEmagId.equals(other.productEmagId))
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

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productEmagId=" + productEmagId
				+ ", quantity=" + quantity + ", salePrice=" + salePrice
				+ ", vatRate=" + vatRate + ", created=" + created
				+ ", modified=" + modified + ", status=" + status + "]";
	}			
}	
