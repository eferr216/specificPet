package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links{

	@JsonProperty("self")
	private String self;

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}
}