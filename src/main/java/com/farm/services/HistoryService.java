
package com.farm.services;

import com.farm.entities.History;
import com.farm.entities.Product;
import com.farm.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.farm.repositories.HistoryRepository;
import java.util.List;


@Service
public class HistoryService {

	@Autowired
	private HistoryRepository hisstoryrepo;

	@Autowired
	private ProductRepository productRepository;
	public History saveHistory(History history) {

		return hisstoryrepo.save(history);
	}
	public List<History> filterHistory(Integer buyid, Integer sellid){

		return hisstoryrepo.findFilterhis(buyid,sellid);
	}
	public  Product getSinglePro(Integer id){
		return productRepository.findByIdd(id);
	}

//	public User getOneById(Integer id) {
//		return userRepository.findById(id).orElse(null);
//	}
//
//	public User getOneByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
//
//
//
//	public User getOneByContactPrimary(String contactPrimary) {
//		System.out.println(contactPrimary);
//		return userRepository.findByContactPrimary(contactPrimary);
//	}
	public List<Product> getAllProducts(Integer id) {
		return productRepository.findProductsForUser(id);
	}
//
//	public User updateUser(Integer id, User user) {
//		User existingUser = userRepository.findById(id).orElse(null);
//		if (existingUser == null) {
//			return null;
//		}
//		existingUser.setFirstName(user.getFirstName() != null ? user.getFirstName() : existingUser.getFirstName());
//		existingUser.setLastName(user.getLastName() != null ? user.getLastName() : existingUser.getLastName());
//
//		existingUser.setDistrict(user.getDistrict() != null ? user.getDistrict() : existingUser.getDistrict());
//		existingUser.setAddress(user.getAddress() != null ? user.getAddress() : existingUser.getAddress());
//		existingUser.setDescription(user.getDescription() != null ? user.getDescription() : existingUser.getDescription());
//		existingUser.setUsername(user.getUsername() != null ? user.getUsername() : existingUser.getUsername());
//		existingUser.setContactPrimary(user.getContactPrimary() != null ? user.getContactPrimary() : existingUser.getContactPrimary());
//		existingUser.setContactSecondary(user.getContactSecondary() != null ? user.getContactSecondary() : existingUser.getContactSecondary());
//
//		return userRepository.save(existingUser);
//	}
//
//	public User updateUserToken(Integer id, String token) {
//		User existingUser = userRepository.findById(id).orElse(null);
//		if (existingUser == null) {
//			return null;
//		}
//		existingUser.setToken(token);
//		return userRepository.save(existingUser);
//	}
//
//	public User updateUserPassword(Integer id, String password) {
//		User existingUser = userRepository.findById(id).orElse(null);
//		if (existingUser == null) {
//			return null;
//		}
//		existingUser.setPassword(passwordEncoder.encode(password));
//		return userRepository.save(existingUser);
//	}
//
//	public String deleteUser(Integer id) {
//		User existingUser = userRepository.findById(id).orElse(null);
//		if (existingUser == null) {
//			return null;
//		}
//		userRepository.deleteById(id);
//		return "User deleted successfully!!!";
//	}
//
//	public User changepassword(User user, @Valid ChangePassword passwords) {
//
//
//
//
//		return null ;
//	}
//
//	public String deleteToken(Integer id) {
//		userRepository.deleteToken(id);
//		return "user logout successfully!!!";
//	}
//
//
//
//
//	}
//
//
//
}