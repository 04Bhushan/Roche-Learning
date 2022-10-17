package com.backendproject.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendproject.springboot.model.User;

//Create a spring data JPA Repository

//JpaRepository/SimpleJpaRepository internally provides @Repository annotation so 
// we don't need to add @Repository annotation


public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String emailId);
	public User findByEmailAndPassword(String email,String password);
//	public Object findOne(int i);
	
}
 