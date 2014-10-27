package com.example.cv.entity;

import java.util.ArrayList;
import java.util.List;

public class InventoryWrapper {

	private List<InventoryDetail> usedCarDataList;
	private List<ExpireUsedCarDetail> expireUsedCarList;
	private List<String> premiumUsedCarIdList;
	private List<String> removePremiumUsedCarIdList;
	

	public InventoryWrapper() {
		this.usedCarDataList = new ArrayList<InventoryDetail>();
		this.expireUsedCarList = new ArrayList<ExpireUsedCarDetail>();
		this.premiumUsedCarIdList = new ArrayList<String>();
		this.removePremiumUsedCarIdList = new ArrayList<String>();
	}

	public List<InventoryDetail> getUsedCarDataList() {
		return usedCarDataList;
	}

	public void setUsedCarDataList(List<InventoryDetail> usedCarDataList) {
		this.usedCarDataList = usedCarDataList;
	}

	public List<ExpireUsedCarDetail> getExpireUsedCarList() {
		return expireUsedCarList;
	}

	public void setExpireUsedCarList(List<ExpireUsedCarDetail> expireUsedCarList) {
		this.expireUsedCarList = expireUsedCarList;
	}

	public List<String> getPremiumUsedCarIdList() {
		return premiumUsedCarIdList;
	}

	public void setPremiumUsedCarIdList(List<String> premiumUsedCarIdList) {
		this.premiumUsedCarIdList = premiumUsedCarIdList;
	}

	public List<String> getRemovePremiumUsedCarIdList() {
		return removePremiumUsedCarIdList;
	}

	public void setRemovePremiumUsedCarIdList(
			List<String> removePremiumUsedCarIdList) {
		this.removePremiumUsedCarIdList = removePremiumUsedCarIdList;
	}
	
	
}
