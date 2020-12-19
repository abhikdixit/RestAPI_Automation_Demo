package com.RestApi.Demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_POST_Employee {

	@Test
	public void AddRecords(){
		// int empid = 8299;
		 
		 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "RestAPI");
		 requestParams.put("salary", 30000);
		 requestParams.put("age", 25);
	 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/create");
		 
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		 }
}
