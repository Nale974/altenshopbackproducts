package com.alten.shopbackproducts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="inventory_status")
	private InventoryStatusType inventoryStatus;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	private String image;
	
	private Integer rating;
}
