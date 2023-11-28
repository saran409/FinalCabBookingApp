package com.cabapp.pro.dto;

import java.util.Objects;

public class CabCurrentBookingResponseDTO {
	private int cabId;
	private String carType;
	private float perKmRate;
	private String status;
	private String currentLocation;
	private String cabRegistrationNumber;
	private String driverName;
	private String driverLicenseNo;
	private String driverStatus;
	public CabCurrentBookingResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CabCurrentBookingResponseDTO(int cabId, String carType, float perKmRate, String status,
			String currentLocation, String cabRegistrationNumber, String driverName, String driverLicenseNo,
			String driverStatus) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.status = status;
		this.currentLocation = currentLocation;
		this.cabRegistrationNumber = cabRegistrationNumber;
		this.driverName = driverName;
		this.driverLicenseNo = driverLicenseNo;
		this.driverStatus = driverStatus;
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
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}
	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
	}
	public String getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cabId, cabRegistrationNumber, carType, currentLocation, driverLicenseNo, driverName,
				driverStatus, perKmRate, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CabCurrentBookingResponseDTO other = (CabCurrentBookingResponseDTO) obj;
		return cabId == other.cabId && Objects.equals(cabRegistrationNumber, other.cabRegistrationNumber)
				&& Objects.equals(carType, other.carType) && Objects.equals(currentLocation, other.currentLocation)
				&& Objects.equals(driverLicenseNo, other.driverLicenseNo)
				&& Objects.equals(driverName, other.driverName) && Objects.equals(driverStatus, other.driverStatus)
				&& Float.floatToIntBits(perKmRate) == Float.floatToIntBits(other.perKmRate)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "CabCurrentBookingResponseDTO [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate
				+ ", status=" + status + ", currentLocation=" + currentLocation + ", cabRegistrationNumber="
				+ cabRegistrationNumber + ", driverName=" + driverName + ", driverLicenseNo=" + driverLicenseNo
				+ ", driverStatus=" + driverStatus + "]";
	}
	
	
}