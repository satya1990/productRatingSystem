package com.example.casaone.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.casaone.ratings.model.ProductReview;
import com.example.casaone.ratings.repository.ProductReviewRepository;

@RestController
public class ProductReviewController {
	@Autowired
	ProductReviewRepository prodReviewRepo;
	
	@PostMapping("/product/review")
	public ProductReview saveReview(@RequestBody ProductReview review){
		return prodReviewRepo.save(review);
	}
	
	@GetMapping("/product/review")
	public List<ProductReview> getAllReviews(){
		return prodReviewRepo.findAll();
	}

}
