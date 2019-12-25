package com.example.casaone.ratings.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="PRODUCT_RATINGS")
@IdClass(ProductRatingId.class)
public class ProductRating {
	@Id
	@Column(name="USER_ID", nullable = false, insertable=false, updatable=false)
	private Long userId;
	@Id
	@Column(name="PRODUCT_ID", nullable = false, insertable=false, updatable=false)
	private Long productId;
	
	@Enumerated(EnumType.ORDINAL)
	private  RatingValue ratingValue;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID", referencedColumnName="ID")
	@Transient
	private Product product;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID", referencedColumnName="ID")
	@Transient
	private User user;
	
	/**
	 * 
	 */
	public ProductRating() {
	}

	/**
	 * @param userId
	 * @param productId
	 * @param ratingValue
	 */
	public ProductRating(Long userId, Long productId, RatingValue ratingValue) {
		this.userId = userId;
		this.productId = productId;
		this.ratingValue = ratingValue;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public RatingValue getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(RatingValue ratingValue) {
		this.ratingValue = ratingValue;
	}

	@Override
	public String toString() {
		return "ProductRating [userId=" + userId + ", productId=" + productId + ", ratingValue=" + ratingValue + "]";
	} 

	
}
