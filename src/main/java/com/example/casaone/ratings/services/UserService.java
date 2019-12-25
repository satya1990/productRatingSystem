package com.example.casaone.ratings.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casaone.ratings.model.User;
import com.example.casaone.ratings.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public List<User> getAllUsers() {
		List<User> result = new ArrayList<User>();
		return null;
	}

	public User saveUser(User user) {
		
		return null;
	}
	
	
}
