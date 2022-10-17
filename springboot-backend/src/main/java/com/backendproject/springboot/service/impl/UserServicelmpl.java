package com.backendproject.springboot.service.impl;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendproject.springboot.repository.UserRepository;
import com.backendproject.springboot.exception.ResourceNotFoundExpection;
import com.backendproject.springboot.model.User;
import com.backendproject.springboot.service.UserService;

//Service class/layer
@Service
//implements corresponds to spring bean

public class UserServicelmpl implements UserService { 
	
	//injected a dependancy
	@Autowired
	private UserRepository userRepository;
	
	//we don't need to add @Autowired annotation for this constructor here
	// coz we have spring bean and it has only one constructor then we don't wanna use that annotation

//	public UserServicelmpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		// optional has content of user
//		Optional<User> user=userRepository.findById(id);
//		if(user.isPresent()) {
//			return user.get();
//		}
//		else {
//			throw new ResourceNotFoundExpection("User","Id",id);
//		}
		
		//using lambda expression
		return userRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundExpection("User","Id",id));

	}

	@Override
	public User updateUser(User user, long id) {
		//we need to check  whether the user with given id is present in DB or not
		
		User existingUser = userRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundExpection("User", "Id",id));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		//save existing user to DB
		
		userRepository.save(existingUser);
		return existingUser;
	}



	public User fetchUserByEmailId(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

}
