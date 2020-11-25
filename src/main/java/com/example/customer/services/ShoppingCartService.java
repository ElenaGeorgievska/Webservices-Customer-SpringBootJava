package com.example.customer.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entity.Customer;
import com.example.customer.entity.Product;
import com.example.customer.entity.ShoppingCart;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.ProductRepository;
import com.example.customer.repository.ShoppingCartRepository;

@Service 
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	
	// Create Shopping Cart
    // d. Add product to shopping cart- addProductToSC(product)	
	public ShoppingCart createShoppingCart(Integer personId,List<Integer> productId) {
		
		ShoppingCart  shoppingCart = new ShoppingCart();
		
		Date date = new Date(System.currentTimeMillis());
		
		Customer customer = customerRepo.findById(personId).get();
		
		
		List<Product> products = productRepo.findAllById(productId);
		
		shoppingCart.setCreatedOn(date);
		shoppingCart.setCustomer(customer);
		shoppingCart.setProducts(products);
		
		return shoppingCartRepo.save(shoppingCart);
		
	
	}
	
	
	// e. Remove Product from Shopping Cart- removeProductFromSC
	public ShoppingCart removeProductFromSC(Integer cartId, Integer productId) {
        
		Date createdOn = new Date(System.currentTimeMillis());
		
		ShoppingCart cart = shoppingCartRepo.findById(cartId).get();
		
		Product product = productRepo.findById(productId).get();
		
		List<Product> products = cart.getProducts();
		
		for (Product cartProduct : products) {
			if(cartProduct.getId() == product.getId()) {
				products.remove(cartProduct);
				break;
			}
		}
			
		cart.setCreatedOn(createdOn);
		return shoppingCartRepo.save(cart);
		
	}
	
	
	//e-1. Remove all products from shopping cart
	public ShoppingCart removeAllProductsFromSC(Integer cartId) {
		
		Date createdOn = new Date(System.currentTimeMillis());
		//ShoppingCart cart = GetCartByID(cartID);
		
		ShoppingCart cart = shoppingCartRepo.findById(cartId).get();
		
		List<Product> products = cart.getProducts();
		products.removeAll(cart.getProducts());
		
		cart.setCreatedOn(createdOn);
		return shoppingCartRepo.save(cart);
	}


	public ShoppingCart createSC(Integer personId, List<Integer> productId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
