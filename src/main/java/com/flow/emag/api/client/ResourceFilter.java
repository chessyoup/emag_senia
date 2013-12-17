package com.flow.emag.api.client;

public class ResourceFilter {
	
	private int currentPage;
	
	private int itemsPerPage;
	
	public ResourceFilter(int currentPage,int itemsPerPage){
		this.currentPage = currentPage;
		this.itemsPerPage = itemsPerPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}			
}
