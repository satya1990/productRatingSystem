package com.example.casaone.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.casaone.ratings.exception.ResourceNotFoundException;
import com.example.casaone.ratings.model.Product;
import com.example.casaone.ratings.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product){
		return productRepo.save(product);
	}
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable Long productId){
		return productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
		Product p1 = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		productRepo.delete(p1);
		return ResponseEntity.ok().build();
	}
}
