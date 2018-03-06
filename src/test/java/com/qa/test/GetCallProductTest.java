package com.qa.test;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.qa.base.FunctionalTest;

import io.restassured.response.Response;

public class GetCallProductTest extends FunctionalTest {

	@Test(priority = 1)
	public void testGetProductById() {
		builder.expectBody("categories[1].id", equalTo("pcmcat248700050021"));
		builder.expectBody("categories[1].name", equalTo("Housewares"));
		builder.expectBody("categories[1].createdAt", equalTo("2016-11-17T17:57:05.399Z"));
		builder.expectBody("categories[1].updatedAt", equalTo("2016-11-17T17:57:05.399Z"));
		Response respose = expect().spec(responseSpec).when().get("/48530");
		body = respose.getBody();
		System.out.println("GET Response for product filter By Id ----->" + body.asString());
	}

	@Test(priority = 2)
	public void testGetAllProduct() {

		Response respose = expect().spec(responseSpec).when().get("");
		body = respose.getBody();
		System.out.println("GET Response for All products----->" + body.asString());
	}

	@Test(priority = 3)
	public void testGetAllProductWithLimit() {

		Response respose = expect().spec(responseSpec).when().get("?$limit=1");
		body = respose.getBody();
		System.out.println("GET Response for All products With Limit=1 ----->" + body.asString());
	}

	@Test(priority = 4)
	public void testGetAllProductSkipByThResult() {
		Response respose = expect().spec(responseSpec).when().get("?$skip=51955");
		body = respose.getBody();
		System.out.println("GET Response for All product Skip by 51955  ----->" + body.asString());
	}

	@Test(priority = 5)
	public void testGetAllProductSortDesc() {
		Response respose = expect().spec(responseSpec).when().get("?$sort[price]=-1");
		body = respose.getBody();
		System.out
				.println("GET Response for All product sorted by highest price (descending)  ----->" + body.asString());
	}

	@Test(priority = 6)
	public void testGetAllProductSortAsec() {
		Response respose = expect().spec(responseSpec).when().get("?$sort[price]=1");
		body = respose.getBody();
		System.out.println("GET Response for All product sorted by lowest price (ascending)  ----->" + body.asString());
	}

	@Test(priority = 7)
	public void testGetAllProductButOnlyNameAndPrice() {
		Response respose = expect().spec(responseSpec).when().get("?$select[]=name&$select[]=price");
		body = respose.getBody();
		System.out.println(
				"GET Response for All product but only show the name and price in the  ----->" + body.asString());
	}

	@Test(priority = 8)
	public void testGetAllProductSelectByType() {
		Response respose = expect().spec(responseSpec).when().get("?type=HardGood");
		body = respose.getBody();
		System.out.println("GET Response for All product of type HardGood in the result ----->" + body.asString());
	}

	@Test(priority = 9)
	public void testGetAllProductPricelte1() {
		Response respose = expect().spec(responseSpec).when().get("?price[$lte]=1");
		body = respose.getBody();
		System.out
				.println("GET Response for All product of price less than or equal to $1.00  ----->" + body.asString());
	}

	@Test(priority = 10)
	public void testGetAllProductNameHavingStarWarsAndPriceLT30() {
		Response respose = expect().spec(responseSpec).when().get("?name[$like]=*star+wars*&price[$lt]=30");
		body = respose.getBody();
		System.out.println("GET Response for All product of price less than 30 and 'star wars' in the name  ----->"
				+ body.asString());
	}

	@Test(priority = 11)
	public void testGetAllProductWithPriceEitherOR() {
		Response respose = expect().spec(responseSpec).when().get("?price[$in]=0.99&price[$in]=1.99");
		body = respose.getBody();
		System.out.println("GET Response for All product of price either $0.99 or $1.99  ----->" + body.asString());
	}

	@Test(priority = 12)
	public void testGetAllProductWithPriceGT10() {
		Response respose = expect().spec(responseSpec).when().get("?shipping[$gt]=10");
		body = respose.getBody();
		System.out.println("GET Response for All product of price of more than $10  ----->" + body.asString());
	}

	@Test(priority = 13)
	public void testGetAllProductTypeNeitherNor() {
		Response respose = expect().spec(responseSpec).when().get("?type[$nin][]=HardGood&type[$nin][]=Software");
		body = respose.getBody();
		System.out
				.println("GET Response for All product of type are not HardGood or Software  ----->" + body.asString());
	}

	@Test(priority = 14)
	public void testGetAllProductCategoryNameCoffeePods() {
		Response respose = expect().spec(responseSpec).when().get("?category.name=Coffee Pods");
		body = respose.getBody();
		System.out.println(
				"GET Response for All product that are in category name Coffee Pods  ----->" + body.asString());
	}

	@Test(priority = 15)
	public void testGetAllProductByLimitAndSkip() {
		Response respose = expect().spec(responseSpec).when().get("?$limit=1&$skip=1");
		body = respose.getBody();
		System.out.println("GET Response for All product with limit=1 and skip=1  ----->" + body.asString());
	}

	@Test(priority = 16)
	public void testGetAllProductByCategoryID() {
		Response respose = expect().spec(responseSpec).when().get("?category.id=abcat0106004");
		body = respose.getBody();
		System.out.println("GET Response for All product that are in category ID abcat0106004 (TV Mounts)  ----->"
				+ body.asString());
	}

}
