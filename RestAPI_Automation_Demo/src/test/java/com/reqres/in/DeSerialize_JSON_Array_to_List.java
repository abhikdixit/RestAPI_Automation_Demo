package com.reqres.in;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeSerialize_JSON_Array_to_List {
	@Test
	public void JsonPathUsage() throws MalformedURLException
	{
	 RestAssured.baseURI = "https://reqres.in/api/users?page=1";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("");
	 
	 // First get the JsonPath object instance from the Response interface
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 
	 // Read all the name as a List of String. Each item in the list
	 // represent a first_name node in the REST service Response
	 List<String> fname = jsonPathEvaluator.getList("data.first_name");
	 
	 // Iterate over the list and print individual first_name item
	 for(String name : fname)
	 {
	 System.out.println("First Name=: " + name);
	 }
	}
}
