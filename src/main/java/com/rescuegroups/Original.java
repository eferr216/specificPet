package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Original{

	@JsonProperty("resolutionY")
	private int resolutionY;

	@JsonProperty("resolutionX")
	private int resolutionX;

	@JsonProperty("filesize")
	private int filesize;

	@JsonProperty("url")
	private String url;

	public void setResolutionY(int resolutionY){
		this.resolutionY = resolutionY;
	}

	public int getResolutionY(){
		return resolutionY;
	}

	public void setResolutionX(int resolutionX){
		this.resolutionX = resolutionX;
	}

	public int getResolutionX(){
		return resolutionX;
	}

	public void setFilesize(int filesize){
		this.filesize = filesize;
	}

	public int getFilesize(){
		return filesize;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}