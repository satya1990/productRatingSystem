package com.example.casaone.ratings.model;

import java.io.Serializable;
import java.util.Objects;

public class ProductRatingId implements Serializable {
	private Long productId;
	private Long userId;
	/**
	 * @param productId
	 * @param userId
	 */
	public ProductRatingId(Long productId, Long userId) {
		this.productId = productId;
		this.userId = userId;
	}
	
	/**
	 * 
	 */
	public ProductRatingId() {
	}


	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof ProductRatingId)) {
            return false;
        }
        ProductRatingId id = ((ProductRatingId)obj);
       
        return Objects.equals(productId, id.getProductId()) &&
        		Objects.equals(userId,id.getUserId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, userId);
	}
}
