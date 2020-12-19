package com.reqres.in;

import java.awt.print.Book;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deserialize_JSON_Array_to_an_Array_using_JSONPath {
	
	@Test
	public void JsonArrayToArray()
	{
	 
	 RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	 RequestSpecification request = RestAssured.given();
	 
	 Response response = request.get();
	 System.out.println("Response Body -> " + response.body().asString());
	 
	 // We can convert the Json Response directly into a Java Array by using
	 // JsonPath.getObject method. Here we have to specify that we want to
	 // deserialize the Json into an Array of Book. This can be done by specifying
	 // Book[].class as the second argument to the getObject method.
	 Name[] data = response.jsonPath().getObject("data",Name[].class );
	 
	 for(Name name : data)
	 {
	 System.out.println("First Name " + name.last_name);
	 }
	}
}
