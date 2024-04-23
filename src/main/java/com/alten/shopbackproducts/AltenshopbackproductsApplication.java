package com.alten.shopbackproducts;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alten.shopbackproducts.model.Product;
import com.alten.shopbackproducts.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AltenshopbackproductsApplication implements CommandLineRunner {
	
	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(AltenshopbackproductsApplication.class, args);
	}

	/**
	 * Method launched each time the program is run
	 * Loads and initializes the H2 database of a product list from the "/resource/data/products.json" file
	 */
	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {};
		//String jsonData = "[{\"id\": 1000, \"code\": \"f230fh0g3\", \"name\": \"Bamboo Watch\", \"description\": \"Product Description\", \"image\": \"bamboo-watch.jpg\", \"price\": 65, \"category\": \"Accessories\", \"quantity\": 24, \"inventoryStatus\": \"INSTOCK\", \"rating\": 5}]";
		InputStream jsonData = TypeReference.class.getResourceAsStream("/data/products.json");
		try {
			List<Product> products = mapper.readValue(jsonData, typeReference);
			productService.save(products);
			System.out.println("Products Saved!");
		} catch (IOException e) {
			System.out.println("Unable to save products: " + e.getMessage());
		}
	}

}
