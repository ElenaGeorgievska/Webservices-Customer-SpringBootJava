package com.example.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseByCategory {
	
	
	public String name;
	public double price;
	
	public String category;
}
