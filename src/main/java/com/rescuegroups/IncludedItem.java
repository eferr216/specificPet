package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncludedItem{

	@JsonProperty("attributes")
	private Attributes attributes;

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("links")
	private Links links;

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}
}