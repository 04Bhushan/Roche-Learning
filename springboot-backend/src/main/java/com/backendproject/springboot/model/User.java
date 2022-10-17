package com.backendproject.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

//CREATING A JPA ENTITY

//Instead of using getter setter method,constructors,tostring method,equals,hashcode...etc 
//method for java class. We will use lombok notation @Data which will reduce boiler plate code

@Data
//to convert java class to JPA entity we will use @Entity annotaion,it defines class as entity
@Entity
@Table(name="users")
// user class is POJO(plain object java class) class
public class User {
	

	@Id
	//for primary key generation strategy we will use @GeneratedValue annotation
	//It provides the generation strategies for the values of primary keys.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="username")
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="email")
	private String email;
	private String password;
//	private Set<Role> roles;
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
//	public Set<Role> getRoles() {
//		return roles;
//	}

//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

	}
	
	public User(long id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	
	
}
