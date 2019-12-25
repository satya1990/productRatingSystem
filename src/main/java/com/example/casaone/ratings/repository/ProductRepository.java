package com.example.casaone.ratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.casaone.ratings.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
