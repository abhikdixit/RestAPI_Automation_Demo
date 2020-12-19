package com.RestApi.Demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_DELETE {

	@Test
	public void deleteEmpRecord() {
	 
	 int empid = 749;
	 
	 RestAssured.baseURI = "https://reqres.in/api/users";
	 RequestSpecification request = RestAssured.given(); 
	 
	 // Add a header stating the Request body is a JSON
	 request.header("Content-Type", "application/json"); 
	 
	       // Delete the request and check the response
	 Response response = request.delete("/delete/"+empid); 
	 
	 int statusCode = response.getStatusCode();
	 System.out.println(response.asString());
	 Assert.assertEquals(statusCode, 204);
	 
	  // Now let us print the body of the message to see what response
	  // we have recieved from the server
	  String responseBody = response.getBody().asString();
	  System.out.println("Response Body is =>  " +responseBody);
	 int jsonString =response.getStatusCode();
	 Assert.assertEquals(jsonString,204);
	 }
}
