
package com.farm.entities.authentication;

import java.io.Serializable;

import com.farm.entities.User;


public class FarmJwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String token;
	private User user;

	/**
	 * @param token
	 * @param user
	 */
	public FarmJwtResponse(String token, User user) {
		this.token = token;
		this.user = user;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
