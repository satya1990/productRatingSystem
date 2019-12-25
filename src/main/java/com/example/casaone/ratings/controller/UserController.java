package com.example.casaone.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casaone.ratings.exception.ResourceNotFoundException;
import com.example.casaone.ratings.model.User;
import com.example.casaone.ratings.repository.UserRepository;
import com.example.casaone.ratings.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/healthcheck")
	public ResponseEntity<?> health(){
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable Long userId){
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user){
		return userRepo.save(user);
	}
	
	@PutMapping("/users/{userId}")
	public User updateUser(@RequestBody User userDetails, @PathVariable Long userId){
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDetails.getName());
		User updatedUser = userRepo.save(user);
		return updatedUser;
	}
	
	@DeleteMapping("users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId){
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		userRepo.delete(user);
		return ResponseEntity.ok().build();
	}
}
