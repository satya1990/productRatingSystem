package com.example.casaone.ratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casaone.ratings.model.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

}
