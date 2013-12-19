package com.flow.emag.api.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "invoices" )
public class InvoiceEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;		
	
	@Column	
	private String series;
	
	@Column(name="invoice_number")
	private String number;
	
	/**
	 * Ex: '2011-05-23 00:00:00
	 */
	@Column(name="create_date")
	private String createDate; 
	
	/**
	 * Ex: '2011-05-23 00:00:00
	 */
	@Column(name="due_date")
	private String dueDate;
			
	/**
	 * Ex: value 173.9900
	 */
	@Column
	private BigDecimal value;
	
	/**
	 * Ex: value 173.9900
	 */
	@Column(name="total_value")
	private BigDecimal totalValue;
	
	/**
	 *  0 - false ?
	 *  1 - true ?
	 */
	@Column(name="is_cancellation")
	private Integer isCancellation;
	
	@OneToMany(mappedBy="invoice")
	private List<InvoiceItemEntity> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return createDate;
	}

	public void setDate(String date) {
		this.createDate = date;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public Integer getIsCancellation() {
		return isCancellation;
	}

	public void setIsCancellation(Integer isCancellation) {
		this.isCancellation = isCancellation;
	}

	public List<InvoiceItemEntity> getProducts() {
		return items;
	}

	public void setProducts(List<InvoiceItemEntity> products) {
		this.items = products;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", series=" + series + ", number="
				+ number + ", date=" + createDate + ", dueDate=" + dueDate
				+ ", value=" + value + ", totalValue=" + totalValue
				+ ", isCancellation=" + isCancellation + ", products="
				+ items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isCancellation == null) ? 0 : isCancellation.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result
				+ ((totalValue == null) ? 0 : totalValue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		InvoiceEntity other = (InvoiceEntity) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCancellation == null) {
			if (other.isCancellation != null)
				return false;
		} else if (!isCancellation.equals(other.isCancellation))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
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
		return true;
	}
}
