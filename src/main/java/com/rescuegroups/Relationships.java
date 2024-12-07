package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Relationships{

	@JsonProperty("species")
	private Species species;

	@JsonProperty("orgs")
	private Orgs orgs;

	@JsonProperty("colors")
	private Colors colors;

	@JsonProperty("pictures")
	private Pictures pictures;

	@JsonProperty("breeds")
	private Breeds breeds;

	public void setSpecies(Species species){
		this.species = species;
	}

	public Species getSpecies(){
		return species;
	}

	public void setOrgs(Orgs orgs){
		this.orgs = orgs;
	}

	public Orgs getOrgs(){
		return orgs;
	}

	public void setColors(Colors colors){
		this.colors = colors;
	}

	public Colors getColors(){
		return colors;
	}

	public void setPictures(Pictures pictures){
		this.pictures = pictures;
	}

	public Pictures getPictures(){
		return pictures;
	}

	public void setBreeds(Breeds breeds){
		this.breeds = breeds;
	}

	public Breeds getBreeds(){
		return breeds;
	}
}