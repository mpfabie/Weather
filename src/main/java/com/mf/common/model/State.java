package com.mf.common.model;

import javax.validation.constraints.Pattern;


public class State {
	
	private String stateName;
	
	@ZipCode(message="error: invalid zip code format")
	private String zipCode;
	private String temp;
	private String cityName;
	
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

}
