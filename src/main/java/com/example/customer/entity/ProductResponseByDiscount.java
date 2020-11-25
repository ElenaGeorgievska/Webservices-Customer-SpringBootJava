package com.example.customer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseByDiscount {
    
	private String name;
	
	private Double price;
	
	private Double newPrice;
	
}
