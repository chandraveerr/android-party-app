package com.example.cv.entity;


import java.util.ArrayList;
import java.util.List;

/*import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)*/
public class InventoryDetail {
	
	private String usedCarId;
	private String carVariantId;
	private String expectedPrice;
	private String minExpectedPrice;
	private String registrationNo;
	private String modelMonth;
	private String modelYear;
	private String registrationCity;
	private String kilometers;
	private String fuel;
	private String color;
	private List<Image> image;
	private String noOfViews;
	private String noOfLeads;
	private String noOfOwner;
	private String isPremium;
	private String cardekhoUrl;
	private String uploadedDate;
	private String lastUpdatedDate;
	private String alreadyBringToTop;
	
	public InventoryDetail() {
			this.image = new ArrayList<Image>();
	}
	public String getUsedCarId() {
		return usedCarId;
	}
	public void setUsedCarId(String usedCarId) {
		this.usedCarId = usedCarId;
	}
	public String getCarVariantId() {
		return carVariantId;
	}
	public void setCarVariantId(String carVariantId) {
		this.carVariantId = carVariantId;
	}
	public String getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(String expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public String getMinExpectedPrice() {
		return minExpectedPrice;
	}
	public void setMinExpectedPrice(String minExpectedPrice) {
		this.minExpectedPrice = minExpectedPrice;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getRegistrationCity() {
		return registrationCity;
	}
	public void setRegistrationCity(String registrationCity) {
		this.registrationCity = registrationCity;
	}
	public String getKilometers() {
		return kilometers;
	}
	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public List<Image> getImage() {
		return image;
	}
	public void setImage(List<Image> image) {
		this.image = image;
	}
	public String getNoOfViews() {
		return noOfViews;
	}
	public void setNoOfViews(String noOfViews) {
		this.noOfViews = noOfViews;
	}
	public String getNoOfLeads() {
		return noOfLeads;
	}
	public void setNoOfLeads(String noOfLeads) {
		this.noOfLeads = noOfLeads;
	}
	public String getNoOfOwner() {
		return noOfOwner;
	}
	public void setNoOfOwner(String noOfOwner) {
		this.noOfOwner = noOfOwner;
	}
	public String getIsPremium() {
		return isPremium;
	}
	public void setIsPremium(String isPremium) {
		this.isPremium = isPremium;
	}
	public String getCardekhoUrl() {
		return cardekhoUrl;
	}
	public void setCardekhoUrl(String cardekhoUrl) {
		this.cardekhoUrl = cardekhoUrl;
	}
	public String getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getModelMonth() {
		return modelMonth;
	}
	public void setModelMonth(String modelMonth) {
		this.modelMonth = modelMonth;
	}
	public String getAlreadyBringToTop() {
		return alreadyBringToTop;
	}
	public void setAlreadyBringToTop(String alreadyBringToTop) {
		this.alreadyBringToTop = alreadyBringToTop;
	}
	
}
