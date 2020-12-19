package com.RestApi.Demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Read_JSON_Response {
	@Test
	public void DisplayAllNodesInWeatherAPI()
	{
		RestAssured.baseURI = "https://restcountries.eu/rest/v2/name";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/Nepal");
		 
		 // First get the JsonPath object instance from the Response interface
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 String Capital = jsonPathEvaluator.get("capital").toString();
		 
		 // Let us print the Capital variable to see what we got
		 System.out.println("Capital received from Response " +Capital );
		 //Validate the response
		 String ExpCapital="[Kathmandu]";
		 Assert.assertEquals(Capital, ExpCapital,"Correct Capital name recieved in response");
		 // Print the temperature node
		 System.out.println("Region received from Response " + jsonPathEvaluator.get("region").toString());
		 
		 // Print the humidity node
		 System.out.println("population received from Response " + jsonPathEvaluator.get("population").toString());	}
}
