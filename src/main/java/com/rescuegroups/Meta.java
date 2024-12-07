package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta{

	@JsonProperty("pages")
	private int pages;

	@JsonProperty("pageReturned")
	private int pageReturned;

	@JsonProperty("count")
	private int count;

	@JsonProperty("countReturned")
	private int countReturned;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("transactionId")
	private String transactionId;

	public void setPages(int pages){
		this.pages = pages;
	}

	public int getPages(){
		return pages;
	}

	public void setPageReturned(int pageReturned){
		this.pageReturned = pageReturned;
	}

	public int getPageReturned(){
		return pageReturned;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setCountReturned(int countReturned){
		this.countReturned = countReturned;
	}

	public int getCountReturned(){
		return countReturned;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setTransactionId(String transactionId){
		this.transactionId = transactionId;
	}

	public String getTransactionId(){
		return transactionId;
	}
}