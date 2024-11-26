package com.nimapcrud.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimapcrud.entities.Category;
import com.nimapcrud.entities.Product;
import com.nimapcrud.repositories.CategoryRepo;
import com.nimapcrud.repositories.ProductRepo;
import com.nimapcrud.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	

	@Override
	public List<Product> getAllProducts(int pageNo, int pageSize) {
		Pageable p= PageRequest.of(pageNo, pageSize);
		
		Page<Product> productsPage= productRepo.findAll(p);
		
		List<Product> allProducts=productsPage.getContent();
		
		return allProducts;
	}
	
	@Override
	public Product createProduct(Product product) {
		Category category=product.getCategory();
		
		product.setCategory(category);
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		
		return productRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("product for Given ID is not found"));
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		
		Product updatingProduct=productRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("product for Given ID is not found"));
		updatingProduct.setName(product.getName());
		updatingProduct.setPrice(product.getPrice());
		Category updateCategory=categoryRepo.findById(product.getCategory().getId())
				.orElseThrow(()-> new RuntimeException("category not found"));
		updatingProduct.setCategory(updateCategory);
		
		return productRepo.save(updatingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
		
	}


}

