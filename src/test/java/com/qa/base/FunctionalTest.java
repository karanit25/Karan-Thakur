package com.qa.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;

public class FunctionalTest {

	public static ResponseSpecBuilder builder;
	public static ResponseSpecification responseSpec;
	public static ResponseBody body;

	@BeforeMethod
	public static void setupResponseSpecBuilder() {
		builder = new ResponseSpecBuilder();
		builder.expectHeader("Content-Type", "application/json; charset=utf-8");
		builder.expectStatusCode(200);
		responseSpec = builder.build();
	}

	@BeforeClass
	public static void setup() {
		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(3030);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String basePath = System.getProperty("server.base");
		if (basePath == null) {
			basePath = "/products/";
		}
		RestAssured.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://localhost";
		}
		RestAssured.baseURI = baseHost;

	}

}