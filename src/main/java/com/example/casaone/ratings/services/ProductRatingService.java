package com.example.casaone.ratings.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casaone.ratings.exception.ResourceNotFoundException;
import com.example.casaone.ratings.model.Product;
import com.example.casaone.ratings.model.ProductRating;
import com.example.casaone.ratings.model.ProductRatingResult;
import com.example.casaone.ratings.model.RatingValue;
import com.example.casaone.ratings.model.User;
import com.example.casaone.ratings.model.UserRatingResult;
import com.example.casaone.ratings.repository.ProductRatingRepository;
import com.example.casaone.ratings.repository.ProductRepository;
import com.example.casaone.ratings.repository.UserRepository;

@Service
public class ProductRatingService {

	@Autowired
	ProductRatingRepository prodRateRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	UserRepository userRepo;
	
	public List<ProductRating> getAllProductRatings() {
		return prodRateRepo.findAll();
	}

	public ProductRatingResult getRatingsByProductId(Long pid) {
		productRepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product", "id", pid));
		
		List<Integer> result = prodRateRepo.findByProdcutId(pid);
		ProductRatingResult apiResult = new ProductRatingResult();
		
		apiResult.setProductId(pid);
		Map<String, Integer> ratingCount = new HashMap<>();
		if(!result.isEmpty()){
			apiResult.setAvgRating(result.stream().mapToInt(Integer::intValue)
			.average().orElse(0));
			
			for(int rate : result) {
				int rateCount = ratingCount.getOrDefault(rate, 0);
				ratingCount.put(RatingValue.of(rate).name(), rateCount+1);
			}
			apiResult.setRatingsCount(ratingCount);
		}
		return apiResult;
	}
	
	public List<UserRatingResult> getRatingByUserId(Long uid){
		userRepo.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User", "id", uid));
		
		List<UserRatingResult> result = new ArrayList<>();
		List<Object[]> queryResult = prodRateRepo.findByUserId(uid);
		if(!queryResult.isEmpty()){
			for(Object[] record: queryResult){
				result.add(new UserRatingResult((Long)record[0], ((RatingValue)record[1]).name()));
			}
		}
		return result;
	}

	public ProductRating saveProductRating(ProductRating prodRating) {
		return prodRateRepo.save(prodRating);
	}

	public ProductRating updateProductRating(ProductRating prodRating, Long productId) {
		productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		return prodRateRepo.save(prodRating);
	}
	
}
