package com.reqres.in;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeSerialize_JSON_Array_to_List_of_Class {

	@Test
	public void JsonPathUsage() throws MalformedURLException
	{
	 RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("");
	 
	 // First get the JsonPath object instance from the Response interface
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 
	 // Read all the books as a List of String. Each item in the list
	 // represent a book node in the REST service Response
	 List<Name> fname = jsonPathEvaluator.getList("First Name", Name.class);
	 
	 // Iterate over the list and print individual book item
	 // Note that every book entry in the list will be complete Json object of book
	 for(Name name : fname)
	 {
	 System.out.println("Name: " + name.last_name);
	 }
	}
}
