package com.example.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Product(id, name, price, Manufacturer_Id, category_Id, Origin)



@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String name;
	private double price;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL) 
	@JoinColumn(referencedColumnName = "id")
	private Manufacturer manufacturer;
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL) 
   	@JoinColumn(referencedColumnName = "id")
    private Category category;
	
    private String origin;

}
