package com.qa.test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallProductTest {

	public static RequestSpecBuilder builder;
	public static RequestSpecification requestSpec;
	public static HashMap<Object, Object> map = new HashMap<Object, Object>();

	@BeforeClass
	public static void setupRequestSpecBuilder() {

		builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", "application/json");
		requestSpec = builder.build();

	}

	// Request Specification extended with additional parameter body(map)
	@Test
	public void postCallProduct() {

		map.put("name", "HP Laptop-5599");
		map.put("type", "HardGood");
		map.put("price", 5.99);
		map.put("upc", "0398012313200");
		map.put("shipping", 10);
		map.put("description", "HP Laptop");
		map.put("manufacturer", "HP");
		map.put("model", "Pavallion");
		map.put("url", "http://www.hp.com");

		Response respose = given().spec(requestSpec).body(map).when().post("http://localhost:3030/products");

		System.out.println("Response Code is --->" + respose.statusCode());
		System.out.println("Response Body is --->" + respose.getBody().asString());
	}

}
