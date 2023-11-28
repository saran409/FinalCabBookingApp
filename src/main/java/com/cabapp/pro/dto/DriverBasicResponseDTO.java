package com.cabapp.pro.dto;




public class DriverBasicResponseDTO {
	private String username;
	private String password;
	private String mobileNumber;
	private String address;
	private int driverId;
	private String email;
	private String licenseNo;
	private String status;
	private String currentLocation;
	private Double avgRating;
	public DriverBasicResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DriverBasicResponseDTO(String username, String password, String mobileNumber, String address, int driverId,
			String email, String licenseNo, String status, String currentLocation, Double avgRating) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.driverId = driverId;
		this.email = email;
		this.licenseNo = licenseNo;
		this.status = status;
		this.currentLocation = currentLocation;
		this.avgRating = avgRating;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
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
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	
	
	@Override
	public String toString() {
		return "DriverBasicResponseDTO [username=" + username + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", driverId=" + driverId + ", email=" + email + ", licenseNo="
				+ licenseNo + ", status=" + status + ", currentLocation=" + currentLocation + ", avgRating=" + avgRating
				+ "]";
	}
	
	
    
	
	
}
