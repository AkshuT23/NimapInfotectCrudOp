package com.nimapcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimapcrud.entities.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {
}


