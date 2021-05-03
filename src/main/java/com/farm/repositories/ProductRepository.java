
package com.farm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.farm.entities.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * from  products where user_id=:id" , nativeQuery = true)
   List<Product>findProductsForUser(Integer id);





}
