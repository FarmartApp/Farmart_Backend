
package com.farm.entities.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.farm.entities.User;

public class FarmUserDetails implements UserDetails {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	/**
	 * @param user
	 */
	public FarmUserDetails(User user) {
		super();
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();


			authorities.add(new SimpleGrantedAuthority(user.getEmail()));


		return authorities;
	}
	@Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

}
