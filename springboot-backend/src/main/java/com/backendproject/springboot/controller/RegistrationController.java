package com.backendproject.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendproject.springboot.model.User;
import com.backendproject.springboot.service.RegistrationService;

//@RequestMapping("/registeruser")

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class RegistrationController {

	//autowired is used to inject a dependency	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
//	@PostMapping
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempEmailId = user.getEmail();
//		System.out.println(tempEmailId);
		
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			User userObj = service.fetchUserByEmailId(tempEmailId);
			
			if(userObj !=null) {
				throw new Exception("user with "+ tempEmailId + "is already exists");
			}
		}
		User userObj=null;
		userObj = service.saveUser(user);
		return userObj;

	}
	
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		String tempPass = user.getPassword();
//     	System.out.println(tempEmailId);
//    	System.out.println(tempPass);
		User userObj = null;
		
		if(tempEmailId != null && tempPass != null)
		{
			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
}
