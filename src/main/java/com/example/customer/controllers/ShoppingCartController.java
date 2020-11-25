package com.example.customer.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Product;
import com.example.customer.entity.ShoppingCart;
import com.example.customer.repository.ProductRepository;
import com.example.customer.repository.ShoppingCartRepository;
import com.example.customer.services.ShoppingCartService;




@RestController
@RequestMapping("/shoopingCart")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	@Autowired
	ShoppingCartService shoppingCartService; 
	
	@Autowired
	ProductRepository productRepo;
	
	
	// Create Shopping Cart
    // d. Add product to shopping cart- addProductToSC(product)	
	@PostMapping(value="/createShoppingCart/{personId}")
	public ShoppingCart createShoppingCart(@RequestParam("personId")Integer personId,@RequestBody List<Integer> productId) {
		return shoppingCartService.createShoppingCart(personId, productId);
	}
	
	
	// e. Remove Product from Shopping Cart- removeProductFromSC
	@DeleteMapping(value="/removeProductFromSC/{cartId}")
	@Transactional
	public ShoppingCart removeProductFromSC(@RequestParam("cartId")Integer cartId, Integer productId ) {
		return shoppingCartService.removeProductFromSC(cartId,productId);
	
	}
	
	//e-1. Remove all products from shopping cart
	@DeleteMapping(value="/removeAllProductsFromSC/{cartId}")
	@Transactional
	public ShoppingCart removeAllProductsFromSC(@RequestParam("cartId")Integer cartId) {
		return shoppingCartService.removeAllProductsFromSC(cartId);
		
	}
	
	//e-2.Remove shopping cart
	@DeleteMapping(value="/removeSC/{cartId}")
	@Transactional
	public void removeSC(@RequestParam("cartId")Integer cartId) {
		
		shoppingCartRepo.deleteById(cartId);
		
	}
	
	
	//f. get shopping cart by id
	@GetMapping("/getShoppingCartById/{id}")
	public ShoppingCart getShoppingCartById(@RequestParam("id")Integer id) {

	return shoppingCartRepo.findById(id).get();
	}
	
	
	//f-1. get all shopping carts
	@GetMapping("/getAllShoppingCarts")
	public List<ShoppingCart> getAllShoppingCarts() {

		return shoppingCartRepo.findAll();
	}
	
	
	//f-2. get all shopping carts by Customer
	@GetMapping("/getShoppingCartByCustomerId/{customerId}")
	public List<ShoppingCart> getShoppingCartByCustomerId(@RequestParam("customerId")Integer customerId) {

	return  shoppingCartRepo.findAllSCByCustomer(customerId);
	}
		
		
	
	

	
}

