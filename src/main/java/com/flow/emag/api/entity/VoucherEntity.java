package com.flow.emag.api.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "vouchers" )
public class VoucherEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@OneToOne
	private OrderEntity order;
	
	/**
	 * Emag ID ?
	 */
	@Column(name="voucher_emag_id")
	private Integer emagVoucherId;
	
	@Column(name="sale_price_vat")
	private BigDecimal salePriceVAT;
			
	@Column(name="sale_price")
	private BigDecimal salePrice;
	
	@Column(name="vat_rate")
	private BigDecimal vatRate;
	
	/**
	 * Ex: 2011-06-06 15:04:52
	 */	
	@Column
	private String created;
	
	/**
	 * Ex: 2011-06-06 15:04:52
	 */
	@Column
	private String modified;
	
	/**
	 * 0 disabled
	 * 1 enabled ?
	 */
	@Column
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEmagVoucherId() {
		return emagVoucherId;
	}

	public void setEmagVoucherId(Integer emagVoucherId) {
		this.emagVoucherId = emagVoucherId;
	}

	public BigDecimal getSalePriceVAT() {
		return salePriceVAT;
	}

	public void setSalePriceVAT(BigDecimal salePriceVAT) {
		this.salePriceVAT = salePriceVAT;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((emagVoucherId == null) ? 0 : emagVoucherId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result
				+ ((salePrice == null) ? 0 : salePrice.hashCode());
		result = prime * result
				+ ((salePriceVAT == null) ? 0 : salePriceVAT.hashCode());
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
		VoucherEntity other = (VoucherEntity) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (emagVoucherId == null) {
			if (other.emagVoucherId != null)
				return false;
		} else if (!emagVoucherId.equals(other.emagVoucherId))
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
		if (salePrice == null) {
			if (other.salePrice != null)
				return false;
		} else if (!salePrice.equals(other.salePrice))
			return false;
		if (salePriceVAT == null) {
			if (other.salePriceVAT != null)
				return false;
		} else if (!salePriceVAT.equals(other.salePriceVAT))
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
		return "Voucher [id=" + id + ", emagVoucherId=" + emagVoucherId
				+ ", salePriceVAT=" + salePriceVAT + ", salePrice=" + salePrice
				+ ", vatRate=" + vatRate + ", created=" + created
				+ ", modified=" + modified + ", status=" + status + "]";
	}
}
