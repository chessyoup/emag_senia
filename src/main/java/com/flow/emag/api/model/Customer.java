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
@Table( name = "customers" )
@EmagResource(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@SerializedName("id")
	private Long id;	
		
	@Column(name="mkt_id")
	@SerializedName("mkt_id")
	@Expose
	public Integer mktId;
	
	@Column
	@SerializedName("name")
	@Expose
	public String name;
	
	@Column
	@SerializedName("company")
	@Expose
	public String company;
			
	@Column
	@SerializedName("gender")
	@Expose
	public String gender;
	
	@Column
	@SerializedName("phone_1")
	@Expose
	public String phone_1;
	
	@Column
	@SerializedName("phone_2")
	@Expose
	public String phone_2;
			
	@Column
	@SerializedName("phone_3")
	@Expose
	public String phone_3;
			
	@Column(name="registration_number")
	@SerializedName("registration_number")
	@Expose
	public String registration_number;
			
	@Column
	@SerializedName("code")	
	@Expose
	public String code;
	
	@Column
	@SerializedName("email")
	@Expose
	public String email;
	
	@Column(name="billing_country")
	@SerializedName("billing_country")
	@Expose
	public String billingCountry;
			
	@Column(name="billing_suburb")
	@SerializedName("billing_suburb")	
	@Expose
	public String billingSuburb;
			
	@Column(name="billing_city")
	@SerializedName("billing_city")
	@Expose
	public String billingCity;
	
	@Column(name="billing_street")
	@SerializedName("billing_street")
	@Expose
	public String billingStreet;
	
	@Column(name="billing_postal_code")
	@SerializedName("billing_postal_code")
	@Expose
	public String billingPostalCode;
	
	@Column(name="shipping_country")
	@SerializedName("shipping_country")	
	@Expose
	public String shippingCountry;
	
	@Column(name="shipping_suburb")
	@SerializedName("shipping_suburb")
	@Expose
	public String shippingSuburb;
	
	@Column(name="shipping_city")
	@SerializedName("shipping_city")
	@Expose
	public String shippingCity;
	
	@Column(name="shipping_street")
	@SerializedName("shipping_street")	
	@Expose
	public String shippingStreet;
			
	@Column(name="shipping_postal_code")
	@SerializedName("shipping_postal_code")
	@Expose
	public String shippingPostal_Code;		
	
	/**
	 * Sample 2011-06-06 15:04:52
	 */
	@Column
	@SerializedName("created")
	@Expose
	public String created;
	
	/**
	 * Sample 2011-06-06 15:04:52
	 */
	@SerializedName("created")	
	@Column
	@Expose
	public String modified;
	
	@SerializedName("bank")
	@Expose
	public String bank;
	
	@Column
	@SerializedName("iban")
	@Expose
	public String iban;
	
	/**
	 * 0 for persoana fizica
	 * 1 for tpersoana juridica
	 */
	@Column(name="is_juridical")
	@SerializedName("is_juridical")
	@Expose
	public Integer isJuridical;
	
	@Column
	@SerializedName("fax")
	@Expose
	public String fax;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMktId() {
		return mktId;
	}

	public void setMktId(Integer mktId) {
		this.mktId = mktId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone_1() {
		return phone_1;
	}

	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	public String getPhone_2() {
		return phone_2;
	}

	public void setPhone_2(String phone_2) {
		this.phone_2 = phone_2;
	}

	public String getPhone_3() {
		return phone_3;
	}

	public void setPhone_3(String phone_3) {
		this.phone_3 = phone_3;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingSuburb() {
		return billingSuburb;
	}

	public void setBillingSuburb(String billingSuburb) {
		this.billingSuburb = billingSuburb;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingPostalCode() {
		return billingPostalCode;
	}

	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingSuburb() {
		return shippingSuburb;
	}

	public void setShippingSuburb(String shippingSuburb) {
		this.shippingSuburb = shippingSuburb;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingStreet() {
		return shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}

	public String getShippingPostal_Code() {
		return shippingPostal_Code;
	}

	public void setShippingPostal_Code(String shippingPostal_Code) {
		this.shippingPostal_Code = shippingPostal_Code;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Integer getIsJuridical() {
		return isJuridical;
	}

	public void setIsJuridical(Integer isJuridical) {
		this.isJuridical = isJuridical;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", mktId=" + mktId + ", name=" + name
				+ ", company=" + company + ", gender=" + gender + ", phone_1="
				+ phone_1 + ", phone_2=" + phone_2 + ", phone_3=" + phone_3
				+ ", registration_number=" + registration_number + ", code="
				+ code + ", email=" + email + ", billingCountry="
				+ billingCountry + ", billingSuburb=" + billingSuburb
				+ ", billingCity=" + billingCity + ", billingStreet="
				+ billingStreet + ", billingPostalCode=" + billingPostalCode
				+ ", shippingCountry=" + shippingCountry + ", shippingSuburb="
				+ shippingSuburb + ", shippingCity=" + shippingCity
				+ ", shippingStreet=" + shippingStreet
				+ ", shippingPostal_Code=" + shippingPostal_Code + ", created="
				+ created + ", modified=" + modified + ", bank=" + bank
				+ ", iban=" + iban + ", isJuridical=" + isJuridical + ", fax="
				+ fax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result
				+ ((billingCity == null) ? 0 : billingCity.hashCode());
		result = prime * result
				+ ((billingCountry == null) ? 0 : billingCountry.hashCode());
		result = prime
				* result
				+ ((billingPostalCode == null) ? 0 : billingPostalCode
						.hashCode());
		result = prime * result
				+ ((billingStreet == null) ? 0 : billingStreet.hashCode());
		result = prime * result
				+ ((billingSuburb == null) ? 0 : billingSuburb.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isJuridical == null) ? 0 : isJuridical.hashCode());
		result = prime * result + ((mktId == null) ? 0 : mktId.hashCode());
		result = prime * result
				+ ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone_1 == null) ? 0 : phone_1.hashCode());
		result = prime * result + ((phone_2 == null) ? 0 : phone_2.hashCode());
		result = prime * result + ((phone_3 == null) ? 0 : phone_3.hashCode());
		result = prime
				* result
				+ ((registration_number == null) ? 0 : registration_number
						.hashCode());
		result = prime * result
				+ ((shippingCity == null) ? 0 : shippingCity.hashCode());
		result = prime * result
				+ ((shippingCountry == null) ? 0 : shippingCountry.hashCode());
		result = prime
				* result
				+ ((shippingPostal_Code == null) ? 0 : shippingPostal_Code
						.hashCode());
		result = prime * result
				+ ((shippingStreet == null) ? 0 : shippingStreet.hashCode());
		result = prime * result
				+ ((shippingSuburb == null) ? 0 : shippingSuburb.hashCode());
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
		Customer other = (Customer) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (billingCity == null) {
			if (other.billingCity != null)
				return false;
		} else if (!billingCity.equals(other.billingCity))
			return false;
		if (billingCountry == null) {
			if (other.billingCountry != null)
				return false;
		} else if (!billingCountry.equals(other.billingCountry))
			return false;
		if (billingPostalCode == null) {
			if (other.billingPostalCode != null)
				return false;
		} else if (!billingPostalCode.equals(other.billingPostalCode))
			return false;
		if (billingStreet == null) {
			if (other.billingStreet != null)
				return false;
		} else if (!billingStreet.equals(other.billingStreet))
			return false;
		if (billingSuburb == null) {
			if (other.billingSuburb != null)
				return false;
		} else if (!billingSuburb.equals(other.billingSuburb))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isJuridical == null) {
			if (other.isJuridical != null)
				return false;
		} else if (!isJuridical.equals(other.isJuridical))
			return false;
		if (mktId == null) {
			if (other.mktId != null)
				return false;
		} else if (!mktId.equals(other.mktId))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone_1 == null) {
			if (other.phone_1 != null)
				return false;
		} else if (!phone_1.equals(other.phone_1))
			return false;
		if (phone_2 == null) {
			if (other.phone_2 != null)
				return false;
		} else if (!phone_2.equals(other.phone_2))
			return false;
		if (phone_3 == null) {
			if (other.phone_3 != null)
				return false;
		} else if (!phone_3.equals(other.phone_3))
			return false;
		if (registration_number == null) {
			if (other.registration_number != null)
				return false;
		} else if (!registration_number.equals(other.registration_number))
			return false;
		if (shippingCity == null) {
			if (other.shippingCity != null)
				return false;
		} else if (!shippingCity.equals(other.shippingCity))
			return false;
		if (shippingCountry == null) {
			if (other.shippingCountry != null)
				return false;
		} else if (!shippingCountry.equals(other.shippingCountry))
			return false;
		if (shippingPostal_Code == null) {
			if (other.shippingPostal_Code != null)
				return false;
		} else if (!shippingPostal_Code.equals(other.shippingPostal_Code))
			return false;
		if (shippingStreet == null) {
			if (other.shippingStreet != null)
				return false;
		} else if (!shippingStreet.equals(other.shippingStreet))
			return false;
		if (shippingSuburb == null) {
			if (other.shippingSuburb != null)
				return false;
		} else if (!shippingSuburb.equals(other.shippingSuburb))
			return false;
		return true;
	}
	
}
