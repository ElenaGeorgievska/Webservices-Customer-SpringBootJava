package com.example.customer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.Category;
import com.example.customer.entity.Product;
import com.example.customer.entity.ProductResponseByCategory;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	//h. Get all product by origin
	List<Product> findByOrigin(String origin);

	
	//d. 
	List<Product> findAllById(Integer id);
	

	//b. check product by name
    Boolean existsByName(String name);
	Product findByName(String name);
	
	
	
	
	


	
	
	
}
