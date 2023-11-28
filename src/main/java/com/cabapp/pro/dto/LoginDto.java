package com.cabapp.pro.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDto
{
    private String username;
    private String password;
    private String role;
	private String email;
	private String token;
	private boolean isValid;
	private boolean isUsername;
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDto(String username, String password, String role, String email, String token, boolean isValid,
			boolean isUsername) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.token = token;
		this.isValid = isValid;
		this.isUsername = isUsername;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public boolean getIsUsername() {
		return isUsername;
	}
	public void setIsUsername(boolean isUsername) {
		this.isUsername = isUsername;
	}
	@Override
	public String toString() {
		return "LoginDto [username=" + username + ", password=" + password + ", role=" + role + ", email=" + email
				+ ", token=" + token + ", isValid=" + isValid + ", isUsername=" + isUsername + "]";
	}
    
	
	 
	
}
