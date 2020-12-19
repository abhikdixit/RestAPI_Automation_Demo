package com.reqres.in;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.RestApi.Demo.ApplicationTestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_POST_Employee_Using_JSON extends ApplicationTestData {
	
	  @Test(dataProvider="Employee")
	public void UpdateRecords(String name,String salary,String age){
		 
		 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", name);
		 requestParams.put("salary", salary);
		 requestParams.put("age", age);
	 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/create");
		 
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		 }
}
