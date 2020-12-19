package com.reqres.in;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_POST_Request {

	@Test
	public void POST_Request()
	{ 
	 RestAssured.baseURI ="https://reqres.in/api/users";
	 RequestSpecification request = RestAssured.given();

	 String json = "{\n"+ "\"name\": \"Abhi\",\n"+"\"job\":\"Lead\"\n"+"}";
	 
	 request.header("Content-Type","application/json");
 
	 //Response response = request.request(Method.POST,json);
	Response response = request.post(json);

	 
	  // Now let us print the body of the message to see what response
	  // we have recieved from the server
	  String responseBody = response.getBody().asString();
	  System.out.println("Response Body is =>  " + responseBody);
	  // Status Code Validation
	  int statusCode = response.getStatusCode();
	  System.out.println("Status code is =>  " + statusCode);
	  Assert.assertEquals(201, statusCode);
	  
	  // Status Line Verification
	  String statusLine = response.getStatusLine();
	  System.out.println("Status Line is =>  " + statusLine);
	  Assert.assertEquals("HTTP/1.1 201 Created", statusLine);
	}
}
