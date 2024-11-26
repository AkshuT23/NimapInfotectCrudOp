package com.nimapcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimapcrud.entities.Product;
import com.nimapcrud.services.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   ProductService productService;
   
   @GetMapping
   public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "5") int size) {
   	
       return productService.getAllProducts(page, size);
   }
    
    @PostMapping
    public Product createproduct(@RequestBody Product product)
    {
    	return productService.createProduct(product);
    }

    
   @GetMapping("/{id}")
   public Product getProductById(@PathVariable long id)
   {
	   return productService.getProductById(id);
   }
   
   
   @PutMapping("/{id}")
   public Product updateProduct(@PathVariable long id, @RequestBody Product product)
   {
	 return productService.updateProduct(id, product); 
   }
   
   @DeleteMapping("/{id}")
   public void deleteProduct(@PathVariable long id)
   {
	  productService.deleteProduct(id); 
   }
 
}

