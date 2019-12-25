package com.example.casaone.ratings.model;

import java.util.Map;

public class ProductRatingResult {
	private Double avgRating;
	private Long productId;
	private Map<String, Integer> ratingsCount;
	/**
	 * 
	 */
	public ProductRatingResult() {
	}
	/**
	 * @param avgRating
	 * @param productId
	 * @param ratingsCount
	 */
	public ProductRatingResult(Double avgRating, Long productId, Map<String, Integer> ratingsCount) {
		this.avgRating = avgRating;
		this.productId = productId;
		this.ratingsCount = ratingsCount;
	}
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Map<String, Integer> getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount(Map<String, Integer> ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	
}
