package com.alten.shopbackproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.shopbackproducts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
