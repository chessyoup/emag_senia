package com.flow.emag.api.model;

import com.google.gson.annotations.SerializedName;

public class ResourceCount {
			
	@SerializedName("noOfItems")
	private Integer noOfItems;
	
	@SerializedName("noOfPages")
	private Integer noOfPages;
	
	@SerializedName("itemsPerPage")
	private Integer itemsPerPage;

	public Integer getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(Integer noOfItems) {
		this.noOfItems = noOfItems;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemsPerPage == null) ? 0 : itemsPerPage.hashCode());
		result = prime * result
				+ ((noOfItems == null) ? 0 : noOfItems.hashCode());
		result = prime * result
				+ ((noOfPages == null) ? 0 : noOfPages.hashCode());
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
		ResourceCount other = (ResourceCount) obj;
		if (itemsPerPage == null) {
			if (other.itemsPerPage != null)
				return false;
		} else if (!itemsPerPage.equals(other.itemsPerPage))
			return false;
		if (noOfItems == null) {
			if (other.noOfItems != null)
				return false;
		} else if (!noOfItems.equals(other.noOfItems))
			return false;
		if (noOfPages == null) {
			if (other.noOfPages != null)
				return false;
		} else if (!noOfPages.equals(other.noOfPages))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResourceCount [noOfItems=" + noOfItems + ", noOfPages="
				+ noOfPages + ", itemsPerPage=" + itemsPerPage + "]";
	}
}
