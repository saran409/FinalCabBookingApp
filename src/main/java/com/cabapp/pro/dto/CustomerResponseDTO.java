package com.cabapp.pro.dto;

import java.util.Objects;

public class CustomerResponseDTO {//add userId field based on the requ.....
	
	private String username;
	private String password;
	private String address;
	private String mobileNumber;
	private String email;
	private int customerId;
	 
	public CustomerResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerResponseDTO(String username, String password, String address, String mobileNumber, String email,
			int customerId) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customerId = customerId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, customerId, email, mobileNumber, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerResponseDTO other = (CustomerResponseDTO) obj;
		return Objects.equals(address, other.address) && customerId == other.customerId
				&& Objects.equals(email, other.email) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "CustomerResponseDTO [username=" + username + ", password=" + password + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", customerId=" + customerId + "]";
	}
	

}
