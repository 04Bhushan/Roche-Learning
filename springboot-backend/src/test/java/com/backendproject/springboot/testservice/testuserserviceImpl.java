package com.backendproject.springboot.testservice;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.backendproject.springboot.model.User;
import com.backendproject.springboot.repository.UserRepository;
import com.backendproject.springboot.service.impl.UserServicelmpl;

@ExtendWith(MockitoExtension.class)
class testuserserviceImpl {

	@InjectMocks
	UserServicelmpl service = new UserServicelmpl();
	
	
	@Mock
	UserRepository repo;
	

	@Test
	public void getUserListTest(){
		System.out.println("inside getuserlist test");
		List<User> list = new ArrayList<User>();
		list.add(new User());
		list.add(new User());
		when(repo.findAll()).thenReturn(list);
		List<User> check = service.getAllUsers();
		Assertions.assertEquals(list,check);
	}
	
	@Test
	public void getUserTest() {
		System.out.println("inside getuser test");
		String email = "bhushansurjuse@gmail.com";
		User test = new User();
		test.setEmail(email);
		when(repo.findByEmail(email)).thenReturn(test);
		User check = service.fetchUserByEmailId(email);
		Assertions.assertEquals(test, check);
	}

	@Test
	public void saveUserTest() {
		User test = new User(34,"manoj@gmail.com","Manoj", "Bajpayi","123");
		when(repo.save(test)).thenReturn(test);
		Assertions.assertEquals(test,service.saveUser(test));
	}

}





//package com.backendproject.springboot.servicetest;
//import static org.assertj.core.api.Assertions.assertThat;
////import static org.assertj.core.api.Assertions.assertThat;
////import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.backendproject.springboot.model.User;
//import com.backendproject.springboot.repository.UserRepository;
//import com.backendproject.springboot.service.impl.UserServicelmpl;
//
//
//
//@ExtendWith(MockitoExtension.class)
//public class testuserserviceImpl {
//	
//	@InjectMocks
//	private UserServicelmpl userServiceImpl;
//	
//	@Mock
//	private UserRepository userrepo;
//	
//	@Test
//	public void testgetallusers() throws Exception{
//		System.out.println("hi");
//		User user1 = new User();
//		user1.setEmail("bhushansurjuse@gmail.com");
//		user1.setId(18);
//		user1.setFirstName("bhushan");
//		user1.setLastName("surjuse");
//		user1.setPassword("123abc");
//		
//		User user2 = new User();
//		user2.setEmail("rahulmalhotra05@gmail.com");
//		user2.setId(1);
//		user2.setFirstName("Rahul");
//		user2.setLastName("Malhotra");
//		user2.setPassword("null");
//		
//		List<User> userList = new ArrayList<>();
//		userList.add(user1);
//		userList.add(user2);
//		
//		when(userrepo.findAll()).thenReturn(userList);
//		
//		assertThat(userServiceImpl.getAllUsers()).isEqualTo(userList);
//	}
	
//	@Test
//	public void testgetUserById() {
//		User user = new User();
//		String email = "rahulmalhotra05@gmail.com";
//		user.setEmail(email);
//		user.setId(1);
//		user.setFirstName("Rahul");
//		user.setLastName("Malhotra");
//		user.setPassword("null");
//		
//		
//		Mockito.when(userrepo.findByEmail(email)).thenReturn(user);
//		
//		assertThat(userServiceImpl.(1)).isEqualTo(user);
//		
//	}
	
//	@Test
//	public void testupdateUser() {
//		
//		User user = new User();
//		user.setEmail("rahulmalhotra04@gmail.com");
//		user.setId(1);
//		user.setFirstName("Rahul");
//		user.setLastName("Malhotra");
//		user.setPassword("null");
//		
//		
//		Mockito.when(userrepo.findOne(1)).thenReturn(user);
//		
//		user.setId(18);
//		Mockito.when(userrepo.save(user)).thenReturn(user);
//		
//		assertThat(userServiceImpl.updateUser(user,18)).isEqualTo(user);
//	}

//}

