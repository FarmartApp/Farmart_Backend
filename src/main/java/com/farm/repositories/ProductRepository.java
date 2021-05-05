
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


    @Query(value = "SELECT * from  products p where " +
            "p.deleted_at is null  and (:search is null or (p.name like %:search% or p.location like %:search% or p.product_type like %:search% ))" +
            "and(:date is false or (cast(created_at AS DATE) = current_date))" +
            "and(:type is null or(:type = p.product_type))" , nativeQuery = true)
    List<Product> findFilterPro(String search,Boolean date,String type);



}
