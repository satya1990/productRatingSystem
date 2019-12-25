package com.example.casaone.ratings.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ProductReview {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	private String comment;
	@Column(name="USER_ID", insertable=false, updatable=false, nullable=false)
	private Long userId;
	
	@Column(name="PRODUCT_ID", insertable=false, updatable=false, nullable=false)
	private Long productId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID", referencedColumnName="ID")
	@Transient
	private Product product;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID", referencedColumnName="ID")
	@Transient
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param comment
	 * @param userId
	 * @param productId
	 */
	public ProductReview(Long id, String comment, Long userId, Long productId) {
		this.id = id;
		this.comment = comment;
		this.userId = userId;
		this.productId = productId;
	}

	/**
	 * 
	 */
	public ProductReview() {
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "ProductReview [id=" + id + ", comment=" + comment + ", userId=" + userId + ", productId=" + productId
				+ ", product=" + product + ", user=" + user + "]";
	}
	
}
