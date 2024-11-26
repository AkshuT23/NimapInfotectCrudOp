package com.nimapcrud.services;

import java.util.List;

import com.nimapcrud.entities.Product;

public interface ProductService {
	List<Product> getAllProducts(int pageNo, int pageSize);

    Product createProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

}
