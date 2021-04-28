
package com.farm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.farm.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

	/**
	 * @param email
	 * @return
	 */
	User findByContactPrimary(String contactPrimary);



	User getOneByIdAndDeletedAtNull(Integer id);

	@Query(value = "UPDATE users SET  token=null  WHERE id=:id" , nativeQuery = true)
	@Modifying
    @Transactional
	void deleteToken(Integer id);



	


}
