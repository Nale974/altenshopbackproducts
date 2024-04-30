package com.alten.shopbackproducts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum InventoryStatusType {
	INSTOCK("INSTOCK"),
	LOWSTOCK("LOWSTOCK"),
	OUTOFSTOCK("OUTOFSTOCK");
	
	@Getter @Setter private String inventoryStatus;
}
