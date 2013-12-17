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
@Table( name = "proforma_items" )
public class ProformaVendorItem {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@SerializedName("id")
	private Long id;
	
	@OneToOne
	private Proforma proforma;
	
	@Column(name="senia_proform_id")
	@SerializedName("vendor_proform_id")
	@Expose
	private Integer proformId;
	
	@Column(name="senia_product_id")
	@SerializedName("vendor_product_id")
	@Expose
	private Integer productId;
	
	@Column(name="senia_order_product_id")
	@SerializedName("vendor_order_product_id")
	@Expose
	private Integer orderProductId;
	
	@Column(name="senia_product_name")
	@SerializedName("vendor_product_ext_name")
	@Expose
	private String productName;
	
	@Column(name="senia_order_product_quantity")
	@SerializedName("vendor_order_product_quantity")
	@Expose
	private Integer quantity;
	
	@Column(name="senia_order_product_sale_price")
	@SerializedName("vendor_order_product_sale_price")
	@Expose
	private BigDecimal salePrice;
	
	@Column(name="senia_order_product_vat_rate")
	@SerializedName("vendor_order_product_vat_rate")
	@Expose
	private BigDecimal vatRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProformId() {
		return proformId;
	}

	public void setProformId(Integer proformId) {
		this.proformId = proformId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Integer orderProductId) {
		this.orderProductId = orderProductId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	@Override
	public String toString() {
		return "ProformaVendorItem [id=" + id + ", proformId=" + proformId
				+ ", productId=" + productId + ", orderProductId="
				+ orderProductId + ", productName=" + productName
				+ ", quantity=" + quantity + ", salePrice=" + salePrice
				+ ", vatRate=" + vatRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((orderProductId == null) ? 0 : orderProductId.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((proformId == null) ? 0 : proformId.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((salePrice == null) ? 0 : salePrice.hashCode());
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
		ProformaVendorItem other = (ProformaVendorItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderProductId == null) {
			if (other.orderProductId != null)
				return false;
		} else if (!orderProductId.equals(other.orderProductId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (proformId == null) {
			if (other.proformId != null)
				return false;
		} else if (!proformId.equals(other.proformId))
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
		if (vatRate == null) {
			if (other.vatRate != null)
				return false;
		} else if (!vatRate.equals(other.vatRate))
			return false;
		return true;
	}
}
