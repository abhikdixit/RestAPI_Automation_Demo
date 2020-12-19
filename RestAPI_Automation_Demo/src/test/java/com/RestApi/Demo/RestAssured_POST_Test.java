package com.RestApi.Demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_POST_Test {

	@Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams=new JSONObject();
	 requestParams.put("FirstName", "Abhi22223345");
	 requestParams.put("LastName", "Singh22223345");
	 requestParams.put("UserName", "sdimpleuser2dd201122223345");
	 requestParams.put("Password", "password122223345");
	 requestParams.put("Email",  "sample2ee26d922223345@gmail.com");
	 
	 request.header("Content-Type","application/json");
	  
	 request.body(requestParams.toJSONString());
	 
	 Response response = request.request(Method.POST,"/register");
	// Response response = request.post("/register");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println(statusCode);
	 Assert.assertEquals(statusCode, 201);
	 String successCode = response.jsonPath().get("SuccessCode");
	 System.out.println(successCode);
	 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}
