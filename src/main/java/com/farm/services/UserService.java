
package com.farm.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.farm.entities.User;
import com.farm.entities.requestbodies.ChangePassword;
import com.farm.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User getOneById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	public User getOneByEmail(String email) {
		return userRepository.findByEmail(email);
	}



	public User getOneByContactPrimary(String contactPrimary) {
		System.out.println(contactPrimary);
		return userRepository.findByContactPrimary(contactPrimary);
	}
	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User updateUser(Integer id, User user) {
		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser == null) {
			return null;
		}
		existingUser.setFirstName(user.getFirstName() != null ? user.getFirstName() : existingUser.getFirstName());
		existingUser.setLastName(user.getLastName() != null ? user.getLastName() : existingUser.getLastName());

		existingUser.setDistrict(user.getDistrict() != null ? user.getDistrict() : existingUser.getDistrict());
		existingUser.setAddress(user.getAddress() != null ? user.getAddress() : existingUser.getAddress());
		existingUser.setDescription(user.getDescription() != null ? user.getDescription() : existingUser.getDescription());
		existingUser.setUsername(user.getUsername() != null ? user.getUsername() : existingUser.getUsername());
		existingUser.setContactPrimary(user.getContactPrimary() != null ? user.getContactPrimary() : existingUser.getContactPrimary());
		existingUser.setContactSecondary(user.getContactSecondary() != null ? user.getContactSecondary() : existingUser.getContactSecondary());

		return userRepository.save(existingUser);
	}

	public User updateUserToken(Integer id, String token) {
		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser == null) {
			return null;
		}
		existingUser.setToken(token);
		return userRepository.save(existingUser);
	}

	public User updateUserPassword(Integer id, String password) {
		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser == null) {
			return null;
		}
		existingUser.setPassword(passwordEncoder.encode(password));
		return userRepository.save(existingUser);
	}

	public String deleteUser(Integer id) {
		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser == null) {
			return null;
		}
		userRepository.deleteById(id);
		return "User deleted successfully!!!";
	}

	public User changepassword(User user, @Valid ChangePassword passwords) {




		return null ;
	}

	public String deleteToken(Integer id) {
		userRepository.deleteToken(id);
		return "user logout successfully!!!";
	}
	public User updateUserpic(Integer id, User user) {
		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser == null) {
			return null;
		}
		existingUser.setAvatar(user.getAvatar2() !=null ? user.getAvatar2():existingUser.getAvatar2());

		return userRepository.save(existingUser);
	}





}



