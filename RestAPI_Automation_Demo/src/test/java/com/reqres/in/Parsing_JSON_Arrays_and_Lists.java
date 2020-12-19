package com.reqres.in;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Parsing_JSON_Arrays_and_Lists {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
            given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get(endpoint).
                then().contentType(ContentType.JSON).extract().response();
    }

    public static void main(String[] args) {
        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
        //Below test would typically be to count the number of records in the array
        List<String> jsonResponse = response.jsonPath().getList("$");

        System.out.println(jsonResponse.size());
        //In this example, if we wanted to get the username of all entries, we could use:
        String usernames = response.jsonPath().getString("username");
        System.out.println(usernames);
        //If we then want to get the username of the first entry we could use:
        String Fusernames = response.jsonPath().getString("username[0]");
        System.out.println(Fusernames);

    }
}
