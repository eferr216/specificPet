package com.rescuegroups;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes{

	@JsonProperty("distance")
	private Object distance;

	@JsonProperty("small")
	private Small small;

	@JsonProperty("original")
	private Original original;

	@JsonProperty("large")
	private Large large;

	@JsonProperty("created")
	private String created;

	@JsonProperty("updated")
	private String updated;

	@JsonProperty("order")
	private int order;

	@JsonProperty("name")
	private String name;

	@JsonProperty("plural")
	private String plural;

	@JsonProperty("youngSingular")
	private String youngSingular;

	@JsonProperty("youngPlural")
	private String youngPlural;

	@JsonProperty("singular")
	private String singular;

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("about")
	private String about;

	@JsonProperty("coordinates")
	private String coordinates;

	@JsonProperty("sponsorshipUrl")
	private String sponsorshipUrl;

	@JsonProperty("lon")
	private Object lon;

	@JsonProperty("donationUrl")
	private String donationUrl;

	@JsonProperty("services")
	private String services;

	@JsonProperty("type")
	private String type;

	@JsonProperty("citystate")
	private String citystate;

	@JsonProperty("url")
	private String url;

	@JsonProperty("facebookUrl")
	private String facebookUrl;

	@JsonProperty("postalcode")
	private String postalcode;

	@JsonProperty("adoptionProcess")
	private String adoptionProcess;

	@JsonProperty("state")
	private String state;

	@JsonProperty("email")
	private String email;

	@JsonProperty("lat")
	private Object lat;

	public void setDistance(Object distance){
		this.distance = distance;
	}

	public Object getDistance(){
		return distance;
	}

	public void setSmall(Small small){
		this.small = small;
	}

	public Small getSmall(){
		return small;
	}

	public void setOriginal(Original original){
		this.original = original;
	}

	public Original getOriginal(){
		return original;
	}

	public void setLarge(Large large){
		this.large = large;
	}

	public Large getLarge(){
		return large;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setUpdated(String updated){
		this.updated = updated;
	}

	public String getUpdated(){
		return updated;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPlural(String plural){
		this.plural = plural;
	}

	public String getPlural(){
		return plural;
	}

	public void setYoungSingular(String youngSingular){
		this.youngSingular = youngSingular;
	}

	public String getYoungSingular(){
		return youngSingular;
	}

	public void setYoungPlural(String youngPlural){
		this.youngPlural = youngPlural;
	}

	public String getYoungPlural(){
		return youngPlural;
	}

	public void setSingular(String singular){
		this.singular = singular;
	}

	public String getSingular(){
		return singular;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setAbout(String about){
		this.about = about;
	}

	public String getAbout(){
		return about;
	}

	public void setCoordinates(String coordinates){
		this.coordinates = coordinates;
	}

	public String getCoordinates(){
		return coordinates;
	}

	public void setSponsorshipUrl(String sponsorshipUrl){
		this.sponsorshipUrl = sponsorshipUrl;
	}

	public String getSponsorshipUrl(){
		return sponsorshipUrl;
	}

	public void setLon(Object lon){
		this.lon = lon;
	}

	public Object getLon(){
		return lon;
	}

	public void setDonationUrl(String donationUrl){
		this.donationUrl = donationUrl;
	}

	public String getDonationUrl(){
		return donationUrl;
	}

	public void setServices(String services){
		this.services = services;
	}

	public String getServices(){
		return services;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCitystate(String citystate){
		this.citystate = citystate;
	}

	public String getCitystate(){
		return citystate;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setFacebookUrl(String facebookUrl){
		this.facebookUrl = facebookUrl;
	}

	public String getFacebookUrl(){
		return facebookUrl;
	}

	public void setPostalcode(String postalcode){
		this.postalcode = postalcode;
	}

	public String getPostalcode(){
		return postalcode;
	}

	public void setAdoptionProcess(String adoptionProcess){
		this.adoptionProcess = adoptionProcess;
	}

	public String getAdoptionProcess(){
		return adoptionProcess;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}
}