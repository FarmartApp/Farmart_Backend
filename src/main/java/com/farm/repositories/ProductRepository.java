
package com.farm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.farm.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {



	


}
