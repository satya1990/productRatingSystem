package com.example.casaone.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.casaone.ratings.model.ProductRating;
import com.example.casaone.ratings.model.ProductRatingResult;
import com.example.casaone.ratings.model.UserRatingResult;
import com.example.casaone.ratings.services.ProductRatingService;

@RestController
public class RatingsController {
	
	@Autowired
	ProductRatingService prodRateService;
	
	@GetMapping("/ratings")
	public List<ProductRating> getAllProductRatings(){
		return prodRateService.getAllProductRatings();
	}
	
	@GetMapping("/ratings/user/{userId}")
	public List<UserRatingResult>  getRatingByUserId(@PathVariable("userId") Long userId){
		return prodRateService.getRatingByUserId(userId);
	}
	
	@GetMapping("/ratings/product/{productId}")
	public  ProductRatingResult getRatingsByProductId(@PathVariable("productId") Long productId){
		return prodRateService.getRatingsByProductId(productId);
	}
	
	@PostMapping("/ratings")
	public ProductRating saveProductRating(@RequestBody ProductRating prodRating){
		return prodRateService.saveProductRating(prodRating);
	}
	
	@PutMapping("/ratings/{productId}")
	public ProductRating updateProductRating(@RequestBody ProductRating prodRating, @PathVariable("productId") Long productId){
		return prodRateService.updateProductRating(prodRating, productId);
	}

	
}
