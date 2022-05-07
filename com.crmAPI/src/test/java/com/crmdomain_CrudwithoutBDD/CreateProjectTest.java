package com.crmdomain_CrudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

		@Test
		public void createProject() {
			
			//Create request body
			
			JSONObject job=new JSONObject();
			job.put("projectName", "Sony213");
			job.put("createdBy", "Punit Ranjan");
			job.put("status", "on going");
			job.put("teamSize", 6);
			
			//send the request
			
			RequestSpecification req=RestAssured.given();
			req.body(job);
			req.contentType(ContentType.JSON);
			Response resp= req.post("http://localhost:8084/addProject");
			
			//validate response
			
			System.out.println(resp.asPrettyString());
		}
}
