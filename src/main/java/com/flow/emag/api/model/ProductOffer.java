package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@EmagResource(name="offer")
public class ProductOffer {
			
	/**
	 * Product eMAG id
	 * Required. Integer value between 1 and 9999999
	 */	
	@SerializedName("product_emag_id")
	@Expose
	private String productEmagId;
	
	/**
	 * Vendor internal product id (Senia product id)
	 */	
	@SerializedName("id")
	@Expose
	private String vendorId;
		
	/**
	 * Manufacturer unique identifier of the product
	 */
	@SerializedName("part_number")
	@Expose
	public String number;
	
	/**
	 * Product name
	 */	
	@SerializedName("name")
	@Expose
	public String name;
	
	/**
	 * Product short description
	 */
	@SerializedName("short_description")
	@Expose
	public String shortDescription;
	
	/**
	 * Product description
	 */
	@SerializedName("description")
	@Expose
	public String description;
	
	/**
	 * Product category
	 */
	@SerializedName("category_emag_id")
	@Expose
	public String categoryId;
	
	/**
	 * Product brand
	 */
	@SerializedName("brand")	
	@Expose
	public Brand brand;
		
	@SerializedName("characteristics")	
	@Expose
	public List<ProductsCharacteristic> characteristics;
	
	@SerializedName("images")
	@Expose
	public List<Image> images;
	
	/**
	 * Delivery time id.
	 * Required. Integer value between 0 and 65535
	 * 1 – delivery in 1 day.
	 * 2 – delivery in 2 days.
	 */	
	@SerializedName("delivery_time_id")
	@Expose
	private String deliveryTimeId;
	
	/**
	 * Vendor offer status.
	 * 1 – status active
	 * 0 – status inactive
	 * Optional. Default value 1. status=0
	 */
	@SerializedName("status")
	@Expose
	private String status;
	
	/**
	 * Vendor offer sale price without VAT
	 * Required. Decimal value between 0 and 99999999999999
	 * Ex: sale_price=51.64
	 */	
	@SerializedName("sale_price")
	@Expose
	private String salePrice;
	
	/**
	 * Vendor offer sale price before discount without VAT
	 */	
	@SerializedName("original_sale_price")
	@Expose
	private String originalSalePrice;
	
	/**
	 * Vendor offer VAT rate
	 * Optional. Default value 0.24. Decimal value between 0 and 1.
	 * Ex vat_rate=0.09
	 */	
	@SerializedName("vat_rate")	
	@Expose
	private String vatRate;
	
	/**
	 * Vendor offer currency
	 * DEFAULT_CURRENCY. String of 1 to 4 characters currency=”RON”
	 */
	@SerializedName("currency")
	@Expose
	private String currency;
	
	/**
	 * Vendor product availability id.
	 * Integer between 0 and 9
	 * 0 – available on demand
	 * 1 – limited stock reserved 
	 * 2 – limited stock 
	 * 3 – in stock 
	 * 4 – in supplier stock 
	 * 5 – not available 
	 * 9 – available in 10 days 
	 * Optional. Default value availability_id = 9
	 */	
	@SerializedName("availability_id")
	@Expose
	private String availabilityId; 
	
	@SerializedName("popularity")
	@Expose
	private String popularity;
	
	/**
	 * Value represents the warranty in months.
	 * 0 – no warranty
	 * Integer between 0 and 255
	 * Optional. Default warranty=24
	 */	
	@SerializedName("warranty")	
	@Expose
	private String warranty;

	public String getProductEmagId() {
		return productEmagId;
	}

	public void setProductEmagId(String productEmagId) {
		this.productEmagId = productEmagId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<ProductsCharacteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<ProductsCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getDeliveryTimeId() {
		return deliveryTimeId;
	}

	public void setDeliveryTimeId(String deliveryTimeId) {
		this.deliveryTimeId = deliveryTimeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getOriginalSalePrice() {
		return originalSalePrice;
	}

	public void setOriginalSalePrice(String originalSalePrice) {
		this.originalSalePrice = originalSalePrice;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(String availabilityId) {
		this.availabilityId = availabilityId;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "ProductOffer [productEmagId=" + productEmagId + ", vendorId="
				+ vendorId + ", number=" + number + ", name=" + name
				+ ", shortDescription=" + shortDescription + ", description="
				+ description + ", categoryId=" + categoryId + ", brand="
				+ brand + ", characteristics=" + characteristics + ", images="
				+ images + ", deliveryTimeId=" + deliveryTimeId + ", status="
				+ status + ", salePrice=" + salePrice + ", originalSalePrice="
				+ originalSalePrice + ", vatRate=" + vatRate + ", currency="
				+ currency + ", availabilityId=" + availabilityId
				+ ", popularity=" + popularity + ", warranty=" + warranty + "]";
	}	
}
