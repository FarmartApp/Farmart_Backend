
package com.farm.repositories;

import com.farm.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TransportRepository extends JpaRepository<Transport, Integer> {


}
