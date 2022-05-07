package com.crmdomain_CrudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetallProjectTest {

	@Test
	public void getProject() {
		
		// send request
		Response res = RestAssured.get("http://localhost:8084/projects");
		
		//validate
		res.then().log().all();
		
	}
}
