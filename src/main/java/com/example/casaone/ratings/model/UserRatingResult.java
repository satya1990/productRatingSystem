package com.example.casaone.ratings.model;

public class UserRatingResult {
	Long productId;
	String rating;
	/**
	 * 
	 */
	public UserRatingResult() {
	}
	/**
	 * @param productId
	 * @param rating
	 */
	public UserRatingResult(Long productId, String rating) {
		this.productId = productId;
		this.rating = rating;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
