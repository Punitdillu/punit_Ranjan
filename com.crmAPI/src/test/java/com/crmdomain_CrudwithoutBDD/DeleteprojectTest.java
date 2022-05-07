package com.crmdomain_CrudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteprojectTest {

		@Test
		public void deleteproject() {
			//create neccesary data
			
			//
			RequestSpecification req=RestAssured.given();
			req.contentType(ContentType.JSON);
			Response resp= req.delete("http://localhost:8084/projects/TY_PROJ_608");
		}
}
