package com.flow.emag.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table( name = "messages" )
@EmagResource(name="message")
public class Message {
	
	/**
	 * A value that uniquely identifies a message in the system.
	 * Optional. Integer value between 1 and 4294967295
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@SerializedName("id")
	private Long id;
	
	/**
	 * A value that uniquely identifies a message in the vendor system
	 * Optional. Integer value between 1 and 4294967295
	 */
	@Column(name="ext_id")
	@SerializedName("ext_id")	
	@Expose
	private Integer seniaId;
	
	/**
	 * An order id. If supplied, the messages are associated with the order identified by this value.
	 * Optional. Integer value between 1 and 4294967295.
	 */
	@Column(name="order_id")
	@SerializedName("order_id")
	@Expose
	private Integer orderId;
		
	/**
	 * The message body
	 * Required. String
	 */
	@Column(name="text")
	@SerializedName("text")
	@Expose
	private String text;
	
	/**
	 * The message date
	 * Required. Text in YYYY-mm-dd HH:ii:ss format
	 */
	@Column(name="created")
	@SerializedName("created")	
	@Expose
	private String dateCreated;
	
	/**
	 * The name of the user that created the message.
	 * Optional. Text
	 */
	@Column
	@SerializedName("author")
	@Expose
	private String author;
	
	/**
	 * 1 - eMAG;
	 * 2 - vendor ( Senia)
	 *  Required.
	 */
	@Column
	@SerializedName("source")
	@Expose
	private Integer source;
	
	/**
	 * 1 - active;
	 * 2 - closed. 
	 * Required. 
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

	public Integer getSeniaId() {
		return seniaId;
	}

	public void setSeniaId(Integer seniaId) {
		this.seniaId = seniaId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
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
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((seniaId == null) ? 0 : seniaId.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Message other = (Message) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (seniaId == null) {
			if (other.seniaId != null)
				return false;
		} else if (!seniaId.equals(other.seniaId))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", seniaId=" + seniaId + ", orderId="
				+ orderId + ", text=" + text + ", dateCreated=" + dateCreated
				+ ", author=" + author + ", source=" + source + ", status="
				+ status + "]";
	}
}
