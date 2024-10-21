package com.client.valid.Entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {
	@NotBlank(message="UserName must not be empty !!")
	@Size(min = 3, max = 12, message = "User name must be between 3-12 characters")
	private String userName;
	
	@Email(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="Invalid email !!!")
	private String userEmail;
	
	@AssertTrue(message = "Please accept terms and conditions")
	private boolean agreed;
	
	public boolean isAgreed() {
		return agreed;
	}


	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}


	public LoginData() {
		super();
	}


	public LoginData(String userName, String userEmail) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", userEmail=" + userEmail + ", agreed=" + agreed + "]";
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
