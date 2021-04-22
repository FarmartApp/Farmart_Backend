package com.farm.entities.responsebodies;



import com.farm.entities.User;

public class AddFieldResponse {

	private User user;

	
	
	public AddFieldResponse(User user) {
		super();
		this.user = user;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
}
