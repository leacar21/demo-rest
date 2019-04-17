package com.example.demorest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demorest.model.Country;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestApplicationTests {

//	private static final String API_COUNTRIES = "http://localhost:8080/countries";
	
	@Test
	public void contextLoads() {
	}

//	@Test
//	public void whenCreateNewCountry_thenCreated() {
//	    Country country = new Country();
//	    country.setCode("ES");
//	    country.setName("España");
//	    country.setArea(567979);
//	    
//	    Response response = RestAssured.given()
//	      .contentType(MediaType.APPLICATION_JSON_VALUE)
//	      .body(country)
//	      .post(API_COUNTRIES);
//	     
//	    assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
//	}
	
}
