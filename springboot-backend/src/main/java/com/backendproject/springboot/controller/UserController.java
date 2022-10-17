package com.backendproject.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendproject.springboot.model.User;
import com.backendproject.springboot.service.UserService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {
	
	//injected a dependancy
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService; //this is body which is user object
//		String ah=toString();
//		System.out.println(ah);
	}
	
//	public void saveUserData(UserService userService) {
//		System.out.println(userService.toString());
//	} 

	//build create user REST API
	
	//here below API will handing post HTTP request using that annnotation
	//@PostMapping("/users")
	@PostMapping
	//@RequestBody annotation allows us to retrieve the request's body and automatically convert it to Java Object.
	public ResponseEntity<User> saveUser( @RequestBody User user){
	
		//ResponseEntity(Body,Status)
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	//Get All Users REST API
	
	//to make below method as REST API annotate it with @GetMapping annotation
	//it will handle GET HTTP request
	@GetMapping
	public List<User>getAllUsers()
	{
		//return object.method()
		return userService.getAllUsers();
	}
	
	//Get Users by ID REST API
	
	//id in curly braces(URL template variable) is dynamic(variable)
	//http://localhost:8080/api/users/1
	@GetMapping("{id}")
	//to get the path of id we will use @PathVariable annotation
	//getUserById returns <User> with status code OK(200)
	
	public ResponseEntity<User> getUserById(@PathVariable("id") long userid){
		return new ResponseEntity<User>(userService.getUserById(userid), HttpStatus.OK);
		
	}
	
	//Build Update User REST API
	//http://localhost:8080/api/users/1
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
	}
	
}




