package com.backendproject.springboot.service;
import com.backendproject.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendproject.springboot.model.User;
import com.backendproject.springboot.repository.UserRepository;
import com.backendproject.springboot.model.User;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository repo;
	
	public User saveUser(User user) {
		
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmail(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email,password);
	}
}
