package com.example.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.customer.entity.Category;
import com.example.customer.entity.ProductResponseByCategory;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Boolean existsByproductCategory(String productCategory);
	
	Category findByproductCategory(String productCategory);

	
}
