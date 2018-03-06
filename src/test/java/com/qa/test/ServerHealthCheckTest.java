package com.qa.test;

import static io.restassured.RestAssured.expect;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;

public class ServerHealthCheckTest {
	
	public static ResponseSpecBuilder builder;
	public static ResponseSpecification responseSpec;
	public static ResponseBody body;
	
	@BeforeTest
	public void setup() {
		builder = new ResponseSpecBuilder();
		builder.expectHeader("Content-Type", "application/json; charset=utf-8");
		builder.expectStatusCode(200);
		responseSpec = builder.build();
		RestAssured.baseURI = "http://localhost:3030";
		RestAssured.basePath = "/healthcheck/";
	}

	@Test
	public void healthCheck() {
		
		Response respose = expect().spec(responseSpec).when().get("");
		body = respose.getBody();
		System.out.println("Server Health Check----->"+body.asString());
	}

}
