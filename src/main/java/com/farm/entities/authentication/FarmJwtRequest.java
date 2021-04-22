
package com.farm.entities.authentication;

import java.io.Serializable;

public class FarmJwtRequest implements Serializable {


	private static final long serialVersionUID = 1L;
	private String email;
	private String password;

	/**
	 * 
	 */
	public FarmJwtRequest() {
	}

	/**
	 * @param email
	 * @param password
	 */
	public FarmJwtRequest(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
