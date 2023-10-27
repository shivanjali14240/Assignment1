package com.bnt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AssighnmentFirstPrintHelloApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	@Autowired
	private MockMvc mvc;

	@Test
	public void hello_ok() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/geetapi/v1/hello").contentType(MediaType.APPLICATION_JSON).content("Hello World"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void hello_name()throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/geetapi/v1/hello").param("name", "shivanjali").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	

}
