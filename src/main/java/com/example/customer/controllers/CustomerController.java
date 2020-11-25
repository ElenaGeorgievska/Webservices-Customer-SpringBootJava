package com.example.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Customer;
import com.example.customer.entity.Product;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.ProductRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;

	// a. create customer
	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}

	// a. update customer
	@PutMapping("/update") private Customer update(@RequestBody Customer customer) { 
		return customerRepo.save(customer); 
	}
	 

	// a. update customer by id
	@PutMapping("/update/{customerId}")
	public Customer update(@PathVariable("customerId") Integer customerId, @RequestBody Customer customerNew) {

		Customer customer = customerRepo.findById(customerId).get();

		customer.setFirstName(customerNew.getFirstName());
		customer.setLastName(customerNew.getLastName());
		customer.setAddress(customerNew.getAddress());
		customer.setAge(customerNew.getAge());

        return customerRepo.save(customer);

	}

	// a. delete customer
	@DeleteMapping("/product/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		customerRepo.deleteById(id);
	}

}
