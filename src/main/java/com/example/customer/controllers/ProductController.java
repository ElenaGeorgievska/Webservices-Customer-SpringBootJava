package com.example.customer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.customer.entity.Category;
import com.example.customer.entity.Customer;
import com.example.customer.entity.Manufacturer;
import com.example.customer.entity.Product;

import com.example.customer.entity.ProductResponseByCategory;
import com.example.customer.entity.ProductResponseByDiscount;
import com.example.customer.repository.CategoryRepository;
import com.example.customer.repository.ManufacturerRepository;
import com.example.customer.repository.ProductRepository;
import com.example.customer.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ManufacturerRepository manufacturerRepo;
	
	@Autowired
	ProductService productService;
	
	//b.create product
	@PostMapping("/create")
	public Product create(@RequestBody Product product) {
		
      return productService.create(product);
	}
	
	
	//b. update product
	@PutMapping("/update")  
	private Product update(@RequestBody Product product)   {  
	    return productRepo.save(product);   
	} 

	
	// b. update product by id
	@PutMapping("/update/{productId}")
	public Product update(@PathVariable("productId") Integer productId, @RequestBody Product productNew) {

		Product product = productRepo.findById(productId).get();

		product.setName(productNew.getName());
		product.setOrigin(productNew.getOrigin());
		product.setPrice(productNew.getPrice());
		
		product.setCategory(productNew.getCategory());
		product.setManufacturer(productNew.getManufacturer());

	    return productRepo.save(product);

	}
	
	
	//b. delete product
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productRepo.deleteById(id);
	}
	
	
	//c. Get all products- getAllProducts()
	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	
	//h. Get all products by Origin
	@GetMapping("/getAllProductsByOrigin/{origin}")
	public List<Product> getAllProductsByOrigin(@RequestParam("origin")String origin) {
		return productRepo.findByOrigin(origin);
	}
	
	
	//g. Get All products by Category (in custom response to be only product name, price and category)- category should be in url
	@GetMapping("/getAllProductsByCategory/{category}")
	public List<ProductResponseByCategory> getAllProductsByCategory(@RequestParam("category")String category) {
        
		return productService.getAllProductsByCategory(category);
	}
	

	//i. BONUS: Get all products with macedonian origin with the new Price discounted by 18% and the old Price
	@GetMapping("/getAllProductsByDiscount/{origin}")
	public List<ProductResponseByDiscount> getAllProductsByDiscount(@RequestParam("origin")String origin){
        
		return productService.getAllProductsByDiscount(origin);
	}	
	
}
	
	
	

