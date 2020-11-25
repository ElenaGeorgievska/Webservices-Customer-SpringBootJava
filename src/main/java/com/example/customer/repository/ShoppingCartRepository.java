package com.example.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.Customer;
import com.example.customer.entity.Product;
import com.example.customer.entity.ShoppingCart;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{

	
	//List<Product> deleteProductById(Integer id);
	
	
	
	@Query("SELECT s FROM ShoppingCart s JOIN s.customer c WHERE c.id=:id")
	List<ShoppingCart> findAllSCByCustomer(Integer id );

}