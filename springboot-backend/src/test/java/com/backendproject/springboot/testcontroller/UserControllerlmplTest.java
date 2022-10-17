package com.backendproject.springboot.testcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.backendproject.springboot.controller.RegistrationController;
import com.backendproject.springboot.model.User;
import com.backendproject.springboot.service.impl.UserServicelmpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
//@RunWith(SpringRunner.class)

public class UserControllerlmplTest {

//	@MockBean
//	UserController user_controller;
//	
//	@MockBean
//	private RegistrationController registration_controller;
//	
//	@Mock
//	UserRepository repo;
//	
	
	@Autowired
	private MockMvc mockmvc;
	
	
	@MockBean
	private UserServicelmpl userdetails;
	
	@MockBean
	private RegistrationController registrationController; 
	
	



	
//	@Test
//	public void testGetUserById() throws Exception {
//		User mockUser = new User();
//		mockUser.setId(1);
//		mockUser.setEmail("rahulmalhotra05@gmail.com");
//		mockUser.setFirstName("Rahul");
//		mockUser.setLastName("Malhotra");
//		mockUser.setPassword("null");
//		
//		Mockito.when(userdetails.getUserById(Mockito.anyInt())).thenReturn(mockUser);
//		
//		String URI="/dashboard";
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
//		
//
//		//result= list(result);
////		System.out.println(result);
////		String expectedJson = JSONValue.toJSONString(mockUser);
//
//		String expectedJson = this.mapToJson(mockUser); 
//		String outputJson = result.getResponse().getContentAsString();
//		System.out.println(expectedJson);
//		System.out.println(outputJson);
//		assertThat(outputJson).isEqualTo(expectedJson);
//		//assertEquals(outputJson,expectedJson);
//
//	}
	

	@Test
	public void testgetallusers() throws Exception{
		User user1 = new User();
		user1.setEmail("bhushansurjuse@gmail.com");
		user1.setId(18);
		user1.setFirstName("bhushan");
		user1.setLastName("surjuse");
		user1.setPassword("123abc");
		
		User user2 = new User();
		user2.setEmail("rahulmalhotra05@gmail.com");
		user2.setId(1);
		user2.setFirstName("Rahul");
		user2.setLastName("Malhotra");
		user2.setPassword("null");
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		
		Mockito.when(userdetails.getAllUsers()).thenReturn(userList);
		
		String URI="/dashboard";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(userList); 
		String outputJson = result.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(expectedJson);
	}
	
    @Test
    public void loginUserTest() throws Exception {
    	
		User user = new User();
		user.setEmail("bhushansurjuse@gmail.com");
		user.setId(18);
		user.setFirstName("bhushan");
		user.setLastName("surjuse");
		user.setPassword("123abc");
		
		String expectedJson = this.mapToJson1(user); 
		
		String URI="/login";
		Mockito.when(registrationController.loginUser(Mockito.any(User.class))).thenReturn(user);
		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(expectedJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse(); 
		
		String outputJson = response.getContentAsString();
		
		System.out.println(expectedJson);
		System.out.printf("Output json",outputJson);
		assertThat(outputJson).isEqualTo(expectedJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
    }
	
	
    @Test
    public void registerUserTest() throws Exception {
    	
		User user = new User();
		user.setEmail("bhushansurjuse@gmail.com");
		user.setId(18);
		user.setFirstName("bhushan");
		user.setLastName("surjuse");
		user.setPassword("123abc");
		
		String expectedJson = this.mapToJson1(user); 
		
		String URI="/registeruser";
		Mockito.when(registrationController.registerUser(Mockito.any(User.class))).thenReturn(user);
		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(expectedJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse(); 
		
		String outputJson = response.getContentAsString();
		
		System.out.println(expectedJson);
		System.out.printf("Output json",outputJson);
		assertThat(outputJson).isEqualTo(expectedJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
    }
	
	



	private String mapToJson1(User user) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(user);
	}

	private String mapToJson(List<User> userList) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(userList);
	}
	


	
	

}


	




