package com.mf.testcommon.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.Matchers.any;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mf.common.model.State;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/mvc-dispatcher-servlet.xml")
public class WeatherControllerTest {

	 @Autowired
	 private WebApplicationContext wac;
	 
	 private MockMvc mockMvc;
	 
//	 @Mock
//	 JSONURLParser jsonURLParser;
	 
	  @Before
	  public void setup() {
		  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		    viewResolver.setPrefix("/WEB-INF/weatherpages");
		    viewResolver.setSuffix(".jsp");
		  this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		  
	  }
	  
	  @Test
	  /**
	   * Test getting to url localhost:8080/weather/usweather
	   * @throws Exception
	   */
	  public void askZipCode() throws Exception {
		  
		    this.mockMvc.perform(get("/usweather"))
	        .andExpect(status().isOk());
	  }
	  
	  @Test
	  /**
	   * Test submitting a proper zip code.
	   * @throws Exception
	   */
	  public void getTemperature1() throws Exception {
		  String zip = "10606";
		  
		  this.mockMvc.perform(post("/usweather")
				  .param("zipCode", zip))
	        .andExpect(status().isOk())
	        .andExpect(view().name("usweather"))
	        .andExpect(model().attributeExists("state"))
	        .andExpect(model().attributeHasNoErrors("state"));
	  }
	  
	  @Test
	  /**
	   * Test invalid zip code
	   * @throws Exception
	   */
	  public void getTemperature2() throws Exception {
		  String zip = "106";
		  
		  this.mockMvc.perform(post("/usweather")
				  .param("zipCode", zip))
	        .andExpect(status().isOk())
	        .andExpect(view().name("usweather"))
	        .andExpect(model().attributeExists("state"))
	        .andExpect(model().attributeHasErrors("state"));
	  }
	  
	  @Test
	  public void getTemperature3() throws Exception {
		  String zip = "00204";
		  
		  this.mockMvc.perform(post("/usweather")
				  .param("zipCode", zip))
	        .andExpect(status().isOk())
	        .andExpect(view().name("usweather"))
	        .andExpect(model().attributeExists("message"));
	  }
	  
	  @Test
	  /**
	   * Test invalid zip code
	   * with 5 digits but not numeric
	   * @throws Exception
	   */
	  public void getTemperature4() throws Exception {
		  String zip = "wedfa";
		  
		  this.mockMvc.perform(post("/usweather")
				  .param("zipCode", zip))
	        .andExpect(status().isOk())
	        .andExpect(view().name("usweather"))
	        .andExpect(model().attributeExists("state"))
	        .andExpect(model().attributeHasErrors("state"));
	  }
}
