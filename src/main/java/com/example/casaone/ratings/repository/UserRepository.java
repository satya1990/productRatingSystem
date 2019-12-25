package com.example.casaone.ratings.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.casaone.ratings.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
