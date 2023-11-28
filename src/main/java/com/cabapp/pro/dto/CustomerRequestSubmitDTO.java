package com.cabapp.pro.dto;

import org.springframework.stereotype.Component;

import java.util.Objects;

import javax.validation.constraints.NotNull;

@Component
public class CustomerRequestSubmitDTO {
	@NotNull(message = "username cannot be null")

	private String username;
	@NotNull(message = "password cannot be null")

	private String password;
	private String address;
	private String mobileNumber;
	private String email;
	 
	public CustomerRequestSubmitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRequestSubmitDTO(String username, String password, String address, String mobileNumber, String email) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		 
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
	@Override
	public int hashCode() {
		return Objects.hash(address, email, mobileNumber, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRequestSubmitDTO other = (CustomerRequestSubmitDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "CustomerRequestSubmitDTO [username=" + username + ", password=" + password + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	 
	 
	
	
	
	

}
