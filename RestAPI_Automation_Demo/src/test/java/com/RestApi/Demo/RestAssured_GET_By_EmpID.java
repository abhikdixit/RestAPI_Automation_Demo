package com.RestApi.Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_GET_By_EmpID extends ApplicationTestData {
  @Test(dataProvider="EmpId")
  public void RestAPI_Test(String employeeid) {
	  String empid = employeeid;
	  // Specify the base URL to the RESTful web service
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	  
// Get the RequestSpecification of the request that you want to sent to the server.
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  // Make a request to the server by specifying the method Type and the method URL.
	  // This will return the Response from the server. Store the response in a variable.
	  Response response = httpRequest.request(Method.GET, "/employee/"+empid);
	  
	  // Now let us print the body of the message to see what response
	  // we have recieved from the server
	  String responseBody = response.getBody().asString();
	  System.out.println("Response Body is =>  " + responseBody);
	  
	  // Status Code Validation
	  int statusCode = response.getStatusCode();
	  System.out.println("Status code is =>  " + statusCode);
	  Assert.assertEquals(200, statusCode);
	  
	  // Status Line Verification
	  String statusLine = response.getStatusLine();
	  System.out.println("Status Line is =>  " + statusLine);
	//  Assert.assertEquals("HTTP/1.1 200", statusLine);
  }
}
