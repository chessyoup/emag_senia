package com.flow.emag.api.client;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.flow.emag.api.entity.ApiLogEntity;
import com.flow.emag.api.entity.ProductEntity;
import com.flow.emag.api.entity.ProductOfferEntity;
import com.flow.emag.api.model.Brand;
import com.flow.emag.api.model.Category;
import com.flow.emag.api.model.Order;
import com.flow.emag.api.model.Product;
import com.flow.emag.api.model.ProductOffer;

public class EmagClient {

	private static final Logger LOG = Logger.getLogger("EmagClient");

	private static final EmagAPIClient emagApiClient = EmagAPIClient
			.getClient();

	private static final PersistenceLayer persistenceLayer = PersistenceLayer
			.getInstance();
	
	public static void updateBrands(){
		persistenceLayer.openSession();
		ApiLogEntity apiLog = Util.createApiLog("brand",EmagAction.COUNT.toString(), "{count:brand}");
		
		try {
			ApiCountResponse countBrands = emagApiClient.countResource(Brand.class);
			apiLog.setResponseJson(countBrands.getSourceJson());
			LOG.info("countBrands :: "+countBrands.toString());
			saveLog(apiLog);
			
			for( int i = 1 ; i<=countBrands.getResults().getNoOfPages(); i++ ){
				apiLog = Util.createApiLog("brand",EmagAction.READ.toString(), "{\"page\":\""+i+"\"");
				ApiResponse<Brand> brands =  emagApiClient.readResources(Brand.class,new ResourceFilter(i, countBrands.getResults().getItemsPerPage()));
				apiLog.setResponseJson(brands.getSourceJson());
				
				if(brands.getResults() != null && brands.getResults().size() > 0 ){
					for(Brand brand :brands.getResults()){
						persistenceLayer.save(Convertor.brandModelToEntity(brand));	
					}										
				}
				
				saveLog(apiLog);
			}
			
		} catch (Exception e) {			
			LOG.log(Level.SEVERE, "Error on counting brands!");
			apiLog.setException(Util.exceptionToString(e));
		}
				
		persistenceLayer.closeSession();
	}
	
	public static void updateCategories(){
		persistenceLayer.openSession();
		ApiLogEntity apiLog = Util.createApiLog("category",EmagAction.COUNT.toString(), "{count:category}");
		
		try {
			ApiCountResponse countCategories = emagApiClient.countResource(Category.class);
			LOG.info("countCategories :: "+countCategories.toString());
			
			for( int i = 1 ; i<=countCategories.getResults().getNoOfPages(); i++ ){
				ApiResponse<Category> categories =  emagApiClient.readResources(Category.class,new ResourceFilter(i, countCategories.getResults().getItemsPerPage()));
												
				if(categories.getResults() != null && categories.getResults().size() > 0 ){										
					for(Category category :categories.getResults()){
						persistenceLayer.save(Convertor.categoryModelToEntity(category));	
					}										
				}
			}
			
		} catch (Exception e) {			
			LOG.log(Level.SEVERE, "Error on counting brands!");
			apiLog.setException(Util.exceptionToString(e));
		}
		
		saveLog(apiLog);
		persistenceLayer.closeSession();
	}
	
	public static void sendOffer(String offerId){		
		persistenceLayer.openSession();		
		
		ProductOfferEntity entity = persistenceLayer.readEntity(ProductOfferEntity.class, offerId);
		ProductOffer model = Convertor.productOfferEntityToModel(entity);		
		ApiLogEntity apiLog = Util.createApiLog("offer",EmagAction.SAVE.toString(), Util.objectToJson(model));
		
		try {
			String json =  emagApiClient.saveResource(Convertor.productOfferEntityToModel(entity));
			apiLog.setResponseJson(json);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on saving offer!");
			apiLog.setException(Util.exceptionToString(e));
		}
				
		saveLog(apiLog);
		persistenceLayer.closeSession();
	}
	
	public static void updateProducts(){
		persistenceLayer.openSession();		
		ApiLogEntity apiLog = Util.createApiLog("product",EmagAction.READ.toString(), "{read:products}");
		
		try {
			ApiLogEntity countLog = Util.createApiLog("product",EmagAction.COUNT.toString(), "{count:product}");
			ApiCountResponse countProducts = emagApiClient.countResource(Product.class);
			countLog.setResponseJson(Util.objectToJson(countProducts));
			saveLog(countLog);
			LOG.info("updateProducts :: count :"+countProducts.toString());
			
			for( int i = 1 ; i <= countProducts.getResults().getNoOfPages(); i++ ){
				ApiResponse<Product> products =  emagApiClient.readResources(Product.class,new ResourceFilter(i, countProducts.getResults().getItemsPerPage()));				
				apiLog.setResponseJson(apiLog.getResponseJson()+"\n"+Util.objectToJson(products));				
				if(products.getResults() != null && products.getResults().size() > 0 ){										
					for(Product product :products.getResults()){
						ProductEntity pEntity = null;
						
						if( product.getId() != null && product.getId().trim().length() > 0 && Long.valueOf( product.getId().trim()) != 0 ){
							pEntity = persistenceLayer.readEntity(ProductEntity.class, product.getId().trim());
						}
						else{
							if( product.getNumber() != null && product.getNumber().trim().length() > 0 ){
								pEntity = persistenceLayer.findByPartNumber(product.getNumber());
							}
							else{
								apiLog.setException(apiLog.getException() + "\n Invalid product on reponse : "+Util.objectToJson(product));
								continue;
							}
						}
						
						if( pEntity != null ){						
							pEntity.setEmagId(product.getEmagId());
							persistenceLayer.update(pEntity);
						}
						else{
							apiLog.setException("No product on senia database!This is strange!");
						}						
					}										
				}
				else{
					LOG.info("updateProducts :: no results.Aborting!");
					break;
				}				
			}
			
		} catch (Exception e) {			
			LOG.log(Level.SEVERE, "Error on updateProducts!");
			apiLog.setException(Util.exceptionToString(e));
		}
		
		saveLog(apiLog);
		persistenceLayer.closeSession();
	}
	
	public static void newOrder(String orderId){
		persistenceLayer.openSession();		
		ApiLogEntity apiLog = Util.createApiLog("order",EmagAction.READ.toString(), "{\"id\":"+orderId+"\"}");
		
		try {
			ApiResponse<Order> order = emagApiClient.readResourceByEmagId(Order.class, orderId);
							
			if( order != null){
				apiLog.setResponseJson(order.getSourceJson());
				
				if( order.getResults().size() > 0 ){
					persistenceLayer.save(Convertor.orderModelToEntity(order.getResults().get(0)));
				}
				else{
					apiLog.setException("Emtpy order list!");
				}
			}
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on reading order : "+orderId);
			apiLog.setException(Util.exceptionToString(e));
		}
		
		saveLog(apiLog);
		persistenceLayer.closeSession();
	}
	
	private static void saveLog(ApiLogEntity apiLog) {
		apiLog.setEndTime(new Date());
		persistenceLayer.save(apiLog);
	}

	public static void main(String[] args) {
//		 System.out.println(EmagClient.readProduct("425770"));
//		EmagClient.updateProduct("3");
//		EmagClient.updateBrands();
//		EmagClient.updateCategories();
//		EmagClient.sendOffer("3");
//		EmagClient.updateProducts();
		EmagClient.newOrder("2254891");
		EmagClient.newOrder("2254891");
	}
}
