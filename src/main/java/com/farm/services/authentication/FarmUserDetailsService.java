


package com.farm.services.authentication;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.farm.entities.User;
import com.farm.entities.authentication.FarmUserDetails;
import com.farm.repositories.UserRepository;


@Service
public class FarmUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new FarmUserDetails(user);
	}

	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);

		if (user != null) {



			User userAddRole = new User();
			userAddRole.setEmail(user.getEmail());
			userAddRole.setPassword(user.getPassword());


			return userAddRole;
		}

		return null;
	}

}
