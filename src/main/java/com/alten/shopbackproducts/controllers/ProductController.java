package com.alten.shopbackproducts.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.shopbackproducts.model.Product;
import com.alten.shopbackproducts.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * Read - Get all products
	 * @return - An Iterable object of products full filled
	 */
	@GetMapping("")
	public Iterable<Product> getAll(){
		return productService.getAll();
	}
	
	/**
	 * Read - Get one product 
	 * @param id The id of the product
	 * @return A Product object full filled
	 */
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Integer id) {
		Optional<Product> product = productService.get(id);
		if(product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Create - Add a new product
	 * @param product An object product
	 * @param response 200 or 404
	 */
	@PostMapping("")
	public void createProduct(@RequestBody Product product, HttpServletResponse response) {
		if (productService.save(product) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}   
	}
	
	
	/**
	 * Update - Update an existing product
	 * @param id - The id of the product to update
	 * @param product - The product object updated
	 * @return
	 */
	@PatchMapping("/{id}")
	public Product updateProduct(@PathVariable("id") final Integer id, @RequestBody Product product) {
		Optional<Product> p = productService.get(id);
		if(p.isPresent()) {
			Product currentProduct = p.get();
			
			if(product.getCode() != null) {
	                currentProduct.setCode(product.getCode());
	            }

	            if(product.getName() != null) {
	                currentProduct.setName(product.getName());
	            }

	            if(product.getDescription() != null) {
	                currentProduct.setDescription(product.getDescription());
	            }

	            if(product.getPrice() != null) {
	                currentProduct.setPrice(product.getPrice());
	            }

	            if(product.getQuantity() != null) {
	                currentProduct.setQuantity(product.getQuantity());
	            }

	            if(product.getInventoryStatus() != null) {
	                currentProduct.setInventoryStatus(product.getInventoryStatus());
	            }

	            if(product.getCategory() != null) {
	                currentProduct.setCategory(product.getCategory());
	            }

	            if(product.getImage() != null) {
	                currentProduct.setImage(product.getImage());
	            }

	            if(product.getRating() != null) {
	                currentProduct.setRating(product.getRating());
	            }
			
			productService.save(currentProduct);
			return currentProduct;
		} else {
			return null;
		}
	}
	
	/**
	 * Delete - Delete an product
	 * @param id - The id of the product to delete
	 */
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") final Integer id) {
		productService.delete(id);
	}
}
