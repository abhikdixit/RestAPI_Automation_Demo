package com.RestApi.Demo;

import org.testng.annotations.DataProvider;


public class ApplicationTestData {
	
	@DataProvider(name="Employee")
	public Object[][] getDataFromEmployee(){

	    return new Object[][] {

	            {"GET_Data","2000","25"},
	            {"POST_Data","3000","20"},
	            {"PUT_Data","4000","30"}

	            };
	}
	
	@DataProvider(name="EmpId")
	public Object[][] getDataFromEmpID(){

	    return new Object[][] {

	            {"22"},
	            {"23"},
	            {"24"}

	            };
	}

}
