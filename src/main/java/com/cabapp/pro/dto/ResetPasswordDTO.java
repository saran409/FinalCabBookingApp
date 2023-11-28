package com.cabapp.pro.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

 
public class ResetPasswordDTO {
	
	
	@NotNull(message="username cannot be null")
	private String username;
	@NotNull(message="password cannot be null")
	private String password;
	private String otp;
	public ResetPasswordDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResetPasswordDTO(String username, String password, String otp) {
		super();
		this.username = username;
		this.password = password;
		this.otp = otp;
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
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "ResetPasswordDTO [username=" + username + ", password=" + password + ", otp=" + otp + "]";
	}
	
	
	

}
