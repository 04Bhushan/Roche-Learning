package com.backendproject.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.backendproject.springboot.model.User;

public class TestWebapp extends SpringbootBackendApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testEmployee() throws Exception {
		System.out.println("inside test employee");
		mockMvc.perform(get("/dashboard")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value("18"))
				.andExpect(jsonPath("$.firstName").value("bhushan"))
				.andExpect(jsonPath("$.lastName").value("surjuse"))
				.andExpect(jsonPath("$.email").value("bhushansurjuse@gmail.com"))
				.andExpect(jsonPath("$.password").value("123abc"));

	}
	
	@Test
	public void testgetUserById() {
		System.out.println("inside get userby Id employee");
		User user = new User();
		user.setEmail("rahulmalhotra05@gmail.com");
		user.setId(1);
		user.setFirstName("Rahul");
		user.setLastName("Malhotra");
		user.setPassword("null");
		
		
		Mockito.when(userrepo.findOne(1)).thenReturn(user);
		
		assertThat(userServiceImpl.getUserById(1)).isEqualTo(user);
		
	}

}
