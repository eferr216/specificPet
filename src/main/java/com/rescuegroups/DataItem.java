package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("relationships")
	private Relationships relationships;

	@JsonProperty("attributes")
	private Attributes attributes;

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	public void setRelationships(Relationships relationships){
		this.relationships = relationships;
	}

	public Relationships getRelationships(){
		return relationships;
	}

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
}