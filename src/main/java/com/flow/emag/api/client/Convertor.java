package com.flow.emag.api.client;

import java.util.ArrayList;
import java.util.List;

import com.flow.emag.api.entity.BrandEntity;
import com.flow.emag.api.entity.CategoryCharacteristicEntity;
import com.flow.emag.api.entity.CategoryEntity;
import com.flow.emag.api.entity.ImageEntity;
import com.flow.emag.api.entity.ProductCharacteristicValueEntity;
import com.flow.emag.api.entity.ProductEntity;
import com.flow.emag.api.entity.ProductOfferEntity;
import com.flow.emag.api.model.Brand;
import com.flow.emag.api.model.Category;
import com.flow.emag.api.model.CategoryCharacteristic;
import com.flow.emag.api.model.Image;
import com.flow.emag.api.model.Product;
import com.flow.emag.api.model.ProductOffer;
import com.flow.emag.api.model.ProductsCharacteristic;

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
}
