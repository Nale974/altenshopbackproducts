package com.alten.shopbackproducts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	private Integer quantity;
	
	@Column(name="inventory_status")
	private String inventoryStatus;
	
	private String category;
	
	private String image;
	
	private Integer rating;
}
