package com.qa.test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.PropHandler;

import static org.hamcrest.Matchers.*;

public class PutCallProductTest extends PropHandler {
	public static HashMap<Object, Object> map = new HashMap<Object, Object>();
	
	public PutCallProductTest(){
		super();
	}
	
	@BeforeTest
	
	public void putdata(){
		map.put("name", "HP Laptop-5599");
		map.put("type", "SoftGood");
		map.put("price", 5.99);
		map.put("upc", "0398012313200");
		map.put("shipping", 10);
		map.put("description", "HP Laptop");
		map.put("manufacturer", "HP");
		map.put("model", "Pavallion");
		map.put("url", "http://www.hp.com");	
		RestAssured.baseURI = "http://localhost:3030";
		RestAssured.basePath = "/products/";
	}

	@Test
	public void putCallProduct(){
		Response response = 
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put(prop.getProperty("PUTID"))//---------> Specify which resource we need to update 
		.then()
			.statusCode(200)
			.extract().response();
		
		System.out.println("PUT Method Response---->"+response.asString());
	}
}