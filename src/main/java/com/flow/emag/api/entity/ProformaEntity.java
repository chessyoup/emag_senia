package com.flow.emag.api.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "proforms" )
public class ProformaEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@OneToOne
	private OrderEntity order;
	
	@Column(name="senia_order_id")	
	private Integer vendorOrderId;
	
	@Column(name="proforma_number")	
	private Integer number;
	
	/**
	 * Ex: 2011-07-18 15:44:02
	 */
	@Column
	private String created;
	
	/**
	 * Ex: 2011-07-18 15:44:02
	 */
	@Column(name="date_expire")
	private String date_expire;
	
	@Column
	private BigDecimal value;
	
	@Column(name="total_value")
	private BigDecimal totalValue;
	
	@Column
	private Integer status;
			
	@Column(name="is_payed")
	private Integer is_payed;
	
	/**
	 * Ex: 2011-07-18 15:44:02
	 */
	@Column(name="modified")
	private String modified;
			
	@Column(name="mkt_order_id")
	private Integer mktOrderId;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	@Column(name="customer_name")
	private String customerName;
	
	@OneToMany(mappedBy="proforma")
	private List<ProformaVendorItemEntity> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVendorOrderId() {
		return vendorOrderId;
	}

	public void setVendorOrderId(Integer vendorOrderId) {
		this.vendorOrderId = vendorOrderId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDate_expire() {
		return date_expire;
	}

	public void setDate_expire(String date_expire) {
		this.date_expire = date_expire;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIs_payed() {
		return is_payed;
	}

	public void setIs_payed(Integer is_payed) {
		this.is_payed = is_payed;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public Integer getMktOrderId() {
		return mktOrderId;
	}

	public void setMktOrderId(Integer mktOrderId) {
		this.mktOrderId = mktOrderId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<ProformaVendorItemEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProformaVendorItemEntity> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Proforma [id=" + id + ", vendorOrderId=" + vendorOrderId
				+ ", number=" + number + ", created=" + created
				+ ", date_expire=" + date_expire + ", value=" + value
				+ ", totalValue=" + totalValue + ", status=" + status
				+ ", is_payed=" + is_payed + ", modified=" + modified
				+ ", mktOrderId=" + mktOrderId + ", vendorName=" + vendorName
				+ ", customerName=" + customerName + ", products=" + products
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((date_expire == null) ? 0 : date_expire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((is_payed == null) ? 0 : is_payed.hashCode());
		result = prime * result
				+ ((mktOrderId == null) ? 0 : mktOrderId.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalValue == null) ? 0 : totalValue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result
				+ ((vendorName == null) ? 0 : vendorName.hashCode());
		result = prime * result
				+ ((vendorOrderId == null) ? 0 : vendorOrderId.hashCode());
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
		ProformaEntity other = (ProformaEntity) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (date_expire == null) {
			if (other.date_expire != null)
				return false;
		} else if (!date_expire.equals(other.date_expire))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_payed == null) {
			if (other.is_payed != null)
				return false;
		} else if (!is_payed.equals(other.is_payed))
			return false;
		if (mktOrderId == null) {
			if (other.mktOrderId != null)
				return false;
		} else if (!mktOrderId.equals(other.mktOrderId))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		if (vendorOrderId == null) {
			if (other.vendorOrderId != null)
				return false;
		} else if (!vendorOrderId.equals(other.vendorOrderId))
			return false;
		return true;
	}		
}
