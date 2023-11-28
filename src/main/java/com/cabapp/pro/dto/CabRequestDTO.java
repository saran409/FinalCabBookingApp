package com.cabapp.pro.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class CabRequestDTO {
	
	private int cabId;
	 @NotBlank(message = "Car type cannot be blank")
	    private String carType;

	    @NotNull(message = "Per km rate cannot be null")
	    private Float perKmRate;
	    
	    private String currentLocation;
	    private String cabRegistrationNumber;

	 
	public CabRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CabRequestDTO(int cabId, @NotBlank(message = "Car type cannot be blank") String carType,
			@NotNull(message = "Per km rate cannot be null") Float perKmRate, String currentLocation,
			String cabRegistrationNumber) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.currentLocation = currentLocation;
		this.cabRegistrationNumber = cabRegistrationNumber;
	}


	public int getCabId() {
		return cabId;
	}


	public void setCabId(int cabId) {
		this.cabId = cabId;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public Float getPerKmRate() {
		return perKmRate;
	}


	public void setPerKmRate(Float perKmRate) {
		this.perKmRate = perKmRate;
	}


	public String getCurrentLocation() {
		return currentLocation;
	}


	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}


	public String getCabRegistrationNumber() {
		return cabRegistrationNumber;
	}


	public void setCabRegistrationNumber(String cabRegistrationNumber) {
		this.cabRegistrationNumber = cabRegistrationNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cabId, cabRegistrationNumber, carType, currentLocation, perKmRate);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CabRequestDTO other = (CabRequestDTO) obj;
		return cabId == other.cabId && Objects.equals(cabRegistrationNumber, other.cabRegistrationNumber)
				&& Objects.equals(carType, other.carType) && Objects.equals(currentLocation, other.currentLocation)
				&& Objects.equals(perKmRate, other.perKmRate);
	}


	@Override
	public String toString() {
		return "CabRequestDTO [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate
				+ ", currentLocation=" + currentLocation + ", cabRegistrationNumber=" + cabRegistrationNumber + "]";
	}


}