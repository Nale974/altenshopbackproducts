package com.alten.shopbackproducts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum CategoryType {
	Accessories("Accessories"),
	Clothing("Clothing"),
	Electronics("Electronics"),
	Fitness("Fitness");
	
	@Getter @Setter private String category;
}
