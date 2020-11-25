package com.example.customer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entity.Category;
import com.example.customer.entity.Manufacturer;
import com.example.customer.entity.Product;
import com.example.customer.entity.ProductResponseByCategory;
import com.example.customer.entity.ProductResponseByDiscount;
import com.example.customer.repository.CategoryRepository;
import com.example.customer.repository.ManufacturerRepository;
import com.example.customer.repository.ProductRepository;


@Service 
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ManufacturerRepository manufacturerRepo;
	
	
	
	//b.create product
	public Product create(Product product) {
		 if(manufacturerRepo.existsByName(product.getManufacturer().getName())) {
				
				Manufacturer existingManufacturer = manufacturerRepo.findByName(product.getManufacturer().getName());
						
				product.setManufacturer(existingManufacturer);
				
			}
	       
			
	       if(categoryRepo.existsByproductCategory(product.getCategory().getProductCategory())) {
				
				Category existingCategory = categoryRepo.findByproductCategory(product.getCategory().getProductCategory());
				
				product.setCategory(existingCategory);
			}
	       
			
			return productRepo.save(product);	
	}
	
	
	//g. Get All products by Category (in custom response to be only product name, price and category)- category should be in url
	public List<ProductResponseByCategory> getAllProductsByCategory(String category){
		List<ProductResponseByCategory> result = new ArrayList<>();
	    
	    List<Product> products =  productRepo.findAll();
	    		 
	    for (Product product : products) {
       
	       if (product.getCategory().getProductCategory().equals(category)) {
	    
		      ProductResponseByCategory response = new ProductResponseByCategory();
		      response.setName(product.getName());
		      response.setPrice(product.getPrice());
		      response.setCategory(product.getCategory().getProductCategory());
		
		      result.add(response);

	       }
	     }
	    
	    return result;
	    		
	}

	
	//i. BONUS: Get all products with macedonian origin with the new Price discounted by 18% and the old Price
	public List<ProductResponseByDiscount> getAllProductsByDiscount(String origin){
        List<ProductResponseByDiscount> result = new ArrayList<>();
		
        List<Product> products =  productRepo.findAll();
        for (Product product : products) {
            
 	       if (product.getOrigin().equals(origin)) {
 	    
 	    	  ProductResponseByDiscount response = new ProductResponseByDiscount();
 	    	  
 	    	  response.setName(product.getName());
			  response.setPrice(product.getPrice());
			  response.setNewPrice(product.getPrice()-(product.getPrice()*0.18));
 		
 		      result.add(response);

 	       }
 	     }
 	    
 	    return result;
 	    		
 	}
	
	
}
