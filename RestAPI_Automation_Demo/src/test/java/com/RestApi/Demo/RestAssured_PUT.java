package com.RestApi.Demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_PUT {

	@Test
	public void UpdateRecords(){
		 int empid = 749;
		 
		 RestAssured.baseURI ="https://reqres.in/api/users";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "Sowmya");
		 requestParams.put("job", "Sr. Eng.");
		 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		 request.body(requestParams.toJSONString());
		 Response response = request.put("/update/"+empid);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		  // Now let us print the body of the message to see what response
		  // we have recieved from the server
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
		  // First get the JsonPath object instance from the Response interface
		  Assert.assertEquals(responseBody.contains("Sowmya") /*Expected value*/, true /*Actual Value*/, "Response body contains Nidhi");
		  
		 }
}
