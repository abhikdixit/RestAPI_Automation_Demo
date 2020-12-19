package com.RestApi.Demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_GET_Test {
	int Emp_ID = 1;
  @Test
  public void RestAPI_Test() {
	  RestAssured.baseURI = "https://reqres.in/api/users";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("/"+Emp_ID);
	  
	  JsonPath jsonPathEvaluator = response.getBody().jsonPath();
	  System.out.println(jsonPathEvaluator);
	  //String responseBody = response.getBody();
	  // First get the JsonPath object instance from the Response interface
	  //JsonPath jsonPathEvaluator = response.jsonPath();
	  
	  // Let us print the ID variable to see what we got
	  System.out.println("ID received from Response " + jsonPathEvaluator.get("id"));
	  
	  // Print the temperature node
	  System.out.println("First Name received from Response " + jsonPathEvaluator.get("first_name"));
	  
	  // Print the humidity node
	  System.out.println("Last Name received from Response " + jsonPathEvaluator.get("last_name"));
	  
	  // Print weather description
	  String email=jsonPathEvaluator.get("email");
	  System.out.println("email description received from Response " + jsonPathEvaluator.get("email"));
	  Assert.assertEquals(email,"george.bluth@reqres.in");
	 
  }
}
