
package com.farm.repositories;

import com.farm.entities.Product;
import com.farm.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TransportRepository extends JpaRepository<Transport, Integer> {
    @Query(value = "SELECT * from  transport where id=:id and deleted_at is null" , nativeQuery = true)
    Transport getSingleTransport(Integer id);


    Product findByIdd(Integer id);



}