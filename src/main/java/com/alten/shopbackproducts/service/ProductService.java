package com.alten.shopbackproducts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.shopbackproducts.model.Product;
import com.alten.shopbackproducts.repositories.ProductRepository;

import lombok.Data;

@Data
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> get(Integer id) {
		return productRepository.findById(id);
	}
	
	public Iterable<Product> getAll() {
		return productRepository.findAll();
	}
	
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Product save(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}
	
	public Iterable<Product> save(List<Product> products) {
	        return productRepository.saveAll(products);
	   }

}
