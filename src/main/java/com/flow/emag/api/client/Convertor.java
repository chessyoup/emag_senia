package com.flow.emag.api.client;

import java.util.ArrayList;
import java.util.List;

import com.flow.emag.api.entity.BrandEntity;
import com.flow.emag.api.entity.CategoryCharacteristicEntity;
import com.flow.emag.api.entity.CategoryEntity;
import com.flow.emag.api.entity.CustomerEntity;
import com.flow.emag.api.entity.ImageEntity;
import com.flow.emag.api.entity.InvoiceEntity;
import com.flow.emag.api.entity.OrderDetailEntity;
import com.flow.emag.api.entity.OrderEntity;
import com.flow.emag.api.entity.OrderItemEntity;
import com.flow.emag.api.entity.ProductCharacteristicValueEntity;
import com.flow.emag.api.entity.ProductEntity;
import com.flow.emag.api.entity.ProductOfferEntity;
import com.flow.emag.api.entity.ProformaEntity;
import com.flow.emag.api.entity.VoucherEntity;
import com.flow.emag.api.model.Brand;
import com.flow.emag.api.model.Category;
import com.flow.emag.api.model.CategoryCharacteristic;
import com.flow.emag.api.model.Customer;
import com.flow.emag.api.model.Image;
import com.flow.emag.api.model.Invoice;
import com.flow.emag.api.model.Order;
import com.flow.emag.api.model.OrderDetail;
import com.flow.emag.api.model.OrderItem;
import com.flow.emag.api.model.Product;
import com.flow.emag.api.model.ProductOffer;
import com.flow.emag.api.model.ProductsCharacteristic;
import com.flow.emag.api.model.Proforma;
import com.flow.emag.api.model.Voucher;

public class Convertor {

	public static BrandEntity brandModelToEntity(Brand model) {
		BrandEntity be = new BrandEntity();
		be.setEmagId(Integer.valueOf(model.getEmagId()));
		be.setId(Long.valueOf(model.getId()));
		be.setName(model.getName());
		be.setUrl(model.getUrl());
		return be;
	}

	public static Brand brandEntityToModel(BrandEntity entity) {
		Brand bm = new Brand();
		bm.setEmagId(String.valueOf(entity.getEmagId()));
		bm.setId(String.valueOf(entity.getId()));
		bm.setName(entity.getName());
		bm.setUrl(entity.getUrl());
		return bm;
	}

	public static ProductEntity productModelToEntity(Product model) {
		ProductEntity pe = new ProductEntity();
		pe.setName(model.getName());
		pe.setDescription(model.getDescription());
		pe.setEmagId(model.getEmagId());
		pe.setId(Long.valueOf(model.getId()));
		pe.setShortDescription(model.getShortDescription());
		pe.setNumber(model.getNumber());
		pe.setCategory(categoryModelToEntity(model.getCategory()));
		pe.setBrand(brandEntotyModelToEntity(model.getBrand()));

		return pe;
	}

	public static BrandEntity brandEntotyModelToEntity(Brand model) {
		BrandEntity entity = new BrandEntity();
		entity.setId(Long.valueOf(model.getId()));
		entity.setName(model.getName());
		return entity;
	}

	public static CategoryEntity categoryModelToEntity(Category model) {
		CategoryEntity entity = new CategoryEntity();
		entity.setEmagId(model.getEmagId());
		entity.setId(model.getId());
		entity.setName(model.getName());

		if (model.getCharacteristics() != null) {
			List<CategoryCharacteristicEntity> cces = new ArrayList<CategoryCharacteristicEntity>();

			for (CategoryCharacteristic cc : model.getCharacteristics()) {
				CategoryCharacteristicEntity cce = new CategoryCharacteristicEntity();
				cce.setEmagId(cc.getEmagId());
				cce.setId(cc.getId());
				cce.setName(cc.getName());
				cce.setDisplayOrder(cc.getDisplayOrder());
				cce.setCategory(entity);
				cces.add(cce);
			}

			entity.setCharacteristics(cces);
		}

		return entity;
	}

	public static Product productEntityToModel(ProductEntity entity) {
		Product p = new Product();
		p.setName(entity.getName());
		p.setDescription(entity.getDescription());
		p.setEmagId(entity.getEmagId());
		p.setId(entity.getId().toString());
		p.setShortDescription(entity.getShortDescription());
		p.setNumber(entity.getNumber());
		p.setCategory(categoryEntityToModel(entity.getCategory()));
		p.setBrand(brandEntotyToModel(entity.getBrand()));

		return p;
	}

	public static Brand brandEntotyToModel(BrandEntity entity) {
		Brand model = new Brand();
		model.setId(String.valueOf(entity.getId()));
		model.setName(entity.getName());
		return model;
	}

	public static Category categoryEntityToModel(CategoryEntity entity) {
		Category model = new Category();
		model.setEmagId(entity.getEmagId());
		model.setId(entity.getId());
		model.setName(entity.getName());

		if (entity.getCharacteristics() != null) {
			List<CategoryCharacteristic> ccs = new ArrayList<CategoryCharacteristic>();

			for (CategoryCharacteristicEntity cce : entity.getCharacteristics()) {
				CategoryCharacteristic cc = new CategoryCharacteristic();
				cc.setId(cce.getId());
				cc.setName(cce.getName());
				cc.setDisplayOrder(cce.getDisplayOrder());
				ccs.add(cc);
			}

			model.setCharacteristics(ccs);
		}

		return model;
	}

	public static ProductOffer productOfferEntityToModel(
			ProductOfferEntity entity) {
		ProductOffer model = new ProductOffer();
		model.setBrand(brandEntityToModel(entity.getProduct().getBrand()));
		model.setCategoryId(String.valueOf(entity.getProduct().getCategory()
				.getEmagId()));
		model.setAvailabilityId(String.valueOf(entity.getAvailabilityId()));
		model.setCharacteristics(convertProductCharateristics(entity
				.getProduct().getCharacteristics()));
		model.setCurrency(entity.getCurrency());
		model.setDeliveryTimeId(String.valueOf(entity.getDeliveryTimeId()));
		model.setDescription(entity.getProduct().getDescription());
		model.setImages(convertImages(entity.getProduct().getImages()));
		model.setName(entity.getProduct().getName());
		model.setNumber(entity.getProduct().getNumber());
		model.setOriginalSalePrice(entity.getOriginalSalePrice()
				.toPlainString());
		model.setPopularity(String.valueOf(entity.getPopularity()));
		model.setSalePrice(entity.getSalePrice().toPlainString());
		model.setShortDescription(entity.getProduct().getShortDescription());
		model.setStatus(String.valueOf(entity.getStatus()));
		model.setVatRate(String.valueOf(entity.getVatRate().toPlainString()));
		model.setVendorId(String.valueOf(entity.getProduct().getId()));

		return model;
	}

	private static List<Image> convertImages(List<ImageEntity> images) {
		List<Image> model = new ArrayList<Image>();

		for (ImageEntity entity : images) {
			Image img = new Image();
			img.setDisplayType(String.valueOf(entity.getDisplayType()));
			img.setStatus(img.getStatus());
			img.setUrl(entity.getUrl());
			img.setId(String.valueOf(entity.getId()));
			model.add(img);
		}

		return model;
	}

	private static List<ProductsCharacteristic> convertProductCharateristics(
			List<ProductCharacteristicValueEntity> characteristics) {

		List<ProductsCharacteristic> model = new ArrayList<ProductsCharacteristic>();

		for (ProductCharacteristicValueEntity e : characteristics) {
			ProductsCharacteristic pc = new ProductsCharacteristic();
			pc.setEmagId(String.valueOf(e.getCharacteristic().getEmagId()));
			pc.setValue(e.getValue());
			model.add(pc);
		}

		return model;
	}

	public static Object orderModelToEntity(Order order) {
		OrderEntity entity = new OrderEntity(); 
		entity.setCustomer(customerModelToEntity(order.getCustomer(),entity));
		entity.setDate(order.getDate());
		entity.setDetails(orderDetailsModesToEntity(order.getDetails()));
		entity.setEmagId(order.getEmagId());
		entity.setInvoice(invoiceModelToEntity(order.getInvoice()));
		entity.setObservation(order.getObservation());
		entity.setOrderItems(orderItemToEntity(order.getOrderItems(),entity));
		entity.setPaymentMode(order.getPaymentMode());
		entity.setPaymentModeId(order.getPaymentModeId());
		entity.setPaymentStatus(order.getPaymentStatus());
		entity.setProforms(proformsToEntity(order.getProforms(),order));
		entity.setStatus(order.getStatus());
		entity.setVouchers(vouchersToEntity(order.getVouchers(),order));
		
		return entity;
	}

	private static List<VoucherEntity> vouchersToEntity(List<Voucher> vouchers,
			Order order) {		
		
		return null;
	}

	private static List<ProformaEntity> proformsToEntity(
			List<Proforma> proforms, Order order) {
 
		return null;
	}

	private static List<OrderItemEntity> orderItemToEntity(
			List<OrderItem> orderItems , OrderEntity orderEntity) {
		
		List<OrderItemEntity> list = new ArrayList<OrderItemEntity>();
		
		for(OrderItem model : orderItems){
			OrderItemEntity entity = new OrderItemEntity();
			entity.setCreated(model.getCreated());
			entity.setOrder(orderEntity);
			entity.setProductSeniaId(model.getProductSeniaId());
			entity.setProductEmagId(model.getEmagId());
			entity.setQuantity(model.getQuantity());
			entity.setSalePrice(model.getSalePrice());
			entity.setStatus(model.getStatus());
			entity.setVatRate(model.getVatRate());
			entity.setModified(model.getModified());			
			entity.setOrder(orderEntity);
			
			list.add(entity);
		}
		
		return list;
	}

	private static InvoiceEntity invoiceModelToEntity(Invoice invoice) {
		InvoiceEntity entity = new InvoiceEntity();
		
		return null;
	}

	private static List<OrderDetailEntity> orderDetailsModesToEntity(
			List<OrderDetail> details) {
		
		List<OrderDetailEntity> list = new ArrayList<OrderDetailEntity>();
		
		return null;
	}

	private static CustomerEntity customerModelToEntity(Customer customer,OrderEntity orderEntity) {
		CustomerEntity entity = new CustomerEntity();
		entity.setBank(customer.getBank());
		entity.setBillingCity(customer.getBillingCity());
		entity.setBillingCountry(customer.getBillingCountry());
		entity.setBillingPostalCode(customer.getBillingPostalCode());
		entity.setBillingStreet(customer.getBillingStreet());
		entity.setBillingSuburb(customer.getBillingStreet());
		entity.setCode(customer.getCode());
		entity.setCompany(customer.getCompany());
		entity.setCreated(customer.getCreated());
		entity.setEmail(customer.getEmail());
		entity.setFax(customer.getFax());
		entity.setGender(customer.getGender());
		entity.setIban(customer.getIban());
		entity.setEmagId(customer.getId());
		entity.setIsJuridical(customer.isJuridical);
		entity.setIsVatPayer(customer.isVatPayer);
		entity.setMktId(customer.getMktId());
		entity.setModified(customer.getModified());
		entity.setName(customer.getName());
		entity.setPhone_1(customer.getPhone_1());
		entity.setPhone_2(customer.getPhone_2());
		entity.setPhone_3(customer.getPhone_3());
		entity.setRegistration_number(customer.getRegistration_number());
		entity.setShippingCity(customer.getShippingCity());
		entity.setShippingCountry(customer.getShippingCountry());
		entity.setShippingPostal_Code(customer.getShippingPostal_Code());
		entity.setShippingStreet(customer.getShippingStreet());
		entity.setShippingSuburb(customer.getShippingSuburb());
		entity.setOrder(orderEntity);
		
		return entity;
	}
}
