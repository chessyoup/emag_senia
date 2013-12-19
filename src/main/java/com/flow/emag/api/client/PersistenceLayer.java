package com.flow.emag.api.client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.flow.emag.api.config.Environment;
import com.flow.emag.api.entity.ApiLogEntity;
import com.flow.emag.api.entity.BrandEntity;
import com.flow.emag.api.entity.CategoryCharacteristicEntity;
import com.flow.emag.api.entity.CategoryEntity;
import com.flow.emag.api.entity.CustomerEntity;
import com.flow.emag.api.entity.ImageEntity;
import com.flow.emag.api.entity.InvoiceEntity;
import com.flow.emag.api.entity.InvoiceItemEntity;
import com.flow.emag.api.entity.MessageEntity;
import com.flow.emag.api.entity.OrderDetailEntity;
import com.flow.emag.api.entity.OrderEntity;
import com.flow.emag.api.entity.OrderItemEntity;
import com.flow.emag.api.entity.ProductCharacteristicValueEntity;
import com.flow.emag.api.entity.ProductEntity;
import com.flow.emag.api.entity.ProductOfferEntity;
import com.flow.emag.api.entity.ProformaEntity;
import com.flow.emag.api.entity.ProformaVendorItemEntity;
import com.flow.emag.api.entity.ShipmentEntity;
import com.flow.emag.api.entity.VoucherEntity;

public class PersistenceLayer {

	private static final PersistenceLayer instance = new PersistenceLayer();

	private SessionFactory sessionFactory;

	private Session session;

	private static final Logger LOG = Logger.getLogger("PersistenceLayer");

	private PersistenceLayer() {
		Configuration config;
		config = new Configuration()
				.addAnnotatedClass(BrandEntity.class)
				.addAnnotatedClass(CustomerEntity.class)
				.addAnnotatedClass(CategoryCharacteristicEntity.class)
				.addAnnotatedClass(CategoryEntity.class)
				.addAnnotatedClass(InvoiceItemEntity.class)
				.addAnnotatedClass(InvoiceEntity.class)
				.addAnnotatedClass(MessageEntity.class)
				.addAnnotatedClass(OrderDetailEntity.class)
				.addAnnotatedClass(OrderEntity.class)
				.addAnnotatedClass(OrderItemEntity.class)
				.addAnnotatedClass(ProductEntity.class)
				.addAnnotatedClass(ProductOfferEntity.class)
				.addAnnotatedClass(ProformaEntity.class)
				.addAnnotatedClass(ProformaVendorItemEntity.class)
				.addAnnotatedClass(ShipmentEntity.class)
				.addAnnotatedClass(VoucherEntity.class)
				.addAnnotatedClass(ApiLogEntity.class)
				.addAnnotatedClass(ProductCharacteristicValueEntity.class)
				.addAnnotatedClass(ImageEntity.class)
				.setProperty("hibernate.show_sql",Environment.getProperty("hibernate.show_sql"))
				.setProperty("hibernate.dialect",
						Environment.getProperty("hibernate.dialect"))
				.setProperty("hibernate.connection.driver_class",
						Environment.getProperty("hibernate.connection.driver_class"))
				.setProperty("hibernate.connection.username", Environment.getProperty("hibernate.connection.username"))
				.setProperty("hibernate.connection.password", Environment.getProperty("hibernate.connection.password"))
				.setProperty("hibernate.connection.url",
						Environment.getProperty("hibernate.connection.url"))
				.setProperty("hibernate.connection.pool_size", Environment.getProperty("hibernate.connection.pool_size"));
//		 .setProperty("hibernate.hbm2ddl.auto", Environment.getProperty("hibernate.hbm2ddl.auto"));

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		this.sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static PersistenceLayer getInstance() {
		return PersistenceLayer.instance;
	}

	public void openSession() {

		try {
			this.session = sessionFactory.openSession();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on opening the session :", e);
		}
	}

	public void closeSession() {
		try {
			if (this.session != null) {
				this.session.disconnect();
				this.session.close();				
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on closing the session :", e);
		}
	}

	public <T> T readEntity(Class<T> entityClass, String id) {

		try {
			return (T) this.session.get(entityClass, Long.valueOf(id));
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on reading :" + id, e);
			return null;
		}
	}

	public ProductEntity findByPartNumber(String partNumber) {
		try {
			Query sql = this.session
					.createSQLQuery(
							"select * from products where part_number = ?")
					.addEntity(ProductEntity.class).setString(0, partNumber);
			return (ProductEntity) sql.list().get(0);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on product! Part number  :"
					+ partNumber, e);
			return null;
		}
	}

	public String save(Object entity) {
		LOG.info("save :: " + entity.toString());

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Serializable id = session.save(entity);
			LOG.info("entity id  " + id.toString());			
			session.flush();			
			tx.commit();
			return id.toString();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on saving :" + entity.toString(), e);
			return null;
		}		
	}

	public void update(Object entity) {
		LOG.info("save :: " + entity.toString());

		try {
			Transaction tx = session.beginTransaction();
			session.update(entity);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on saving :" + entity.toString(), e);
		}
	}

	private void createOffer() {
		CategoryEntity cEntity = PersistenceLayer.getInstance().readEntity(
				CategoryEntity.class, "926");
		BrandEntity bEntity = PersistenceLayer.getInstance().readEntity(
				BrandEntity.class, "5663");
		ImageEntity iEntity = new ImageEntity();

		iEntity.setDisplayType(0);
		iEntity.setStatus(0);
		iEntity.setUrl("http://www.senia.ro/styles/senia/img/header/logo-senia-rollover.jpg");

		ProductEntity product = new ProductEntity();
		product.setCategory(cEntity);
		product.setBrand(bEntity);
		product.setName("Senia product TEST");
		product.setShortDescription("short description");
		product.setDescription("long description");
		List<ImageEntity> images = new ArrayList<ImageEntity>();
		images.add(iEntity);
		product.setImages(images);
		product.setNumber("senia part number");

		String id = save(product);
		ProductEntity readProduct = PersistenceLayer.getInstance().readEntity(
				ProductEntity.class, id);

		ProductCharacteristicValueEntity pcvEntity = new ProductCharacteristicValueEntity();
		pcvEntity.setProduct(readProduct);
		pcvEntity.setValue("test value");
		pcvEntity.setProduct(product);
		pcvEntity.setCharacteristic(cEntity.getCharacteristics().get(0));
		List<ProductCharacteristicValueEntity> pCharEntities = new ArrayList<ProductCharacteristicValueEntity>();
		pCharEntities.add(pcvEntity);

		readProduct.setCharacteristics(pCharEntities);
		update(readProduct);

		ProductOfferEntity poEntity = new ProductOfferEntity();
		poEntity.setProduct(readProduct);
		poEntity.setDeliveryTimeId(2);
		poEntity.setStatus(1);
		poEntity.setAvailabilityId(0);
		poEntity.setPopularity(101);
		poEntity.setDeliveryTimeId(2);
		poEntity.setSalePrice(new BigDecimal("300"));
		poEntity.setVatRate(new BigDecimal("0.09"));
		poEntity.setOriginalSalePrice(new BigDecimal("500"));
		save(poEntity);
	}

	public static void main(String[] args) {
		PersistenceLayer.getInstance().openSession();
		ProductOfferEntity e = PersistenceLayer.getInstance().readEntity(
				ProductOfferEntity.class, "3");
		System.out.println(e);
		PersistenceLayer.getInstance().closeSession();
	}
}
