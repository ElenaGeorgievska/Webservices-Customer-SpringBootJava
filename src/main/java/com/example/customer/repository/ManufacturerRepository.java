package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.customer.entity.Manufacturer;


@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{
	

	Boolean existsByName(String name);

	Manufacturer findByName(String name);
	
  

}