package com.farm.entities.requestbodies;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ChangePassword implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Current Password cannot be empty")
	@Size(min = 8, message = "Password should have atleast 8 characters")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String currentPassword;
	
	@NotEmpty(message = "New Password cannot be empty")
	@Size(min = 8, message = "Password should have atleast 8 characters")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String newPassword;
	
	@NotEmpty(message = "Confirm Password cannot be empty")
	@Size(min = 8, message = "Password should have atleast 8 characters")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;

	public ChangePassword(
			@NotEmpty(message = "Current Password cannot be empty") @Size(min = 8, message = "Password should have atleast 8 characters") String currentPassword,
			@NotEmpty(message = "New Password cannot be empty") @Size(min = 8, message = "Password should have atleast 8 characters") String newPassword,
			@NotEmpty(message = "Confirm Password cannot be empty") @Size(min = 8, message = "Password should have atleast 8 characters") String confirmPassword) {
		super();
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}

	public ChangePassword() {
		super();
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
