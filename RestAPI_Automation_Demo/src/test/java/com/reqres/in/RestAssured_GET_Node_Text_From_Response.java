package com.reqres.in;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_GET_Node_Text_From_Response {
	int Emp_ID = 1;
  @Test
  public void RestAPI_Test() {
	  // Specify the base URL to the RESTful web service
	  RestAssured.baseURI = "https://reqres.in/api/users";
	  
	  // Get the RequestSpecification of the request that you want to sent
	  // to the server. The server is specified by the BaseURI that we have
	  // specified in the above step.
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  // Make a request to the server by specifying the method Type and the method URL.
	  // This will return the Response from the server. Store the response in a variable.
	  Response response = httpRequest.request(Method.GET, "/"+Emp_ID);
	  
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
	  Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	  
	  // First get the JsonPath object instance from the Response interface
	  Assert.assertEquals(responseBody.contains("George") /*Expected value*/, true /*Actual Value*/, "Response body contains George");
	  // convert the body into lower case and then do a comparison to ignore casing.
	  Assert.assertEquals(responseBody.toLowerCase().contains("bluth") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
  }
}
