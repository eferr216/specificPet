package com.rescuegroups;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet{

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("included")
	private List<IncludedItem> included;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setIncluded(List<IncludedItem> included){
		this.included = included;
	}

	public List<IncludedItem> getIncluded(){
		return included;
	}
}