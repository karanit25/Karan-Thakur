package com.qa.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.PropHandler;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCallProduct extends PropHandler {
	
	public DeleteCallProduct(){
		super();
	}
	
	@BeforeTest
	public void setup() {

		RestAssured.baseURI = "http://localhost:3030";
		RestAssured.basePath = "/products/";
	}

	@Test
	public void testDelete() {
		Response response = given().when().delete(prop.getProperty("DELETEID")) // --->the resource identifier which need to be deleted
				.then().header("Expires", equalTo(null)).extract().response();

		System.out.println("DELETE Call Response ---->" + response.toString());

	}
}
