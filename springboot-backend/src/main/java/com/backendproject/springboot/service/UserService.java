package com.backendproject.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backendproject.springboot.model.User;

@Service
public interface UserService {

	User saveUser(User user);	List<User>getAllUsers();
	User getUserById(long id);
	User updateUser(User user,long id); 
}
