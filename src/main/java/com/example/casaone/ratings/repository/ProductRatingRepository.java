package com.example.casaone.ratings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.casaone.ratings.model.ProductRating;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, Long> {
	
	@Query("SELECT PR.ratingValue FROM ProductRating PR INNER JOIN Product P ON PR.productId = P.id AND P.id = :pid")
	public List<Integer> findByProdcutId(@Param("pid") Long pid);
	
	@Query("SELECT PR.productId, PR.ratingValue FROM ProductRating PR INNER JOIN User U ON PR.userId = U.id AND U.id = :uid")
	public List<Object[]> findByUserId(@Param("uid") Long uid);
}
