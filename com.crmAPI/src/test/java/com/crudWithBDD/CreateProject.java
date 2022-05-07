package com.crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {

		@Test
		public void create() {
			baseURI="http://localhost:8084";
			
			JSONObject job=new JSONObject();
			job.put("projectName", "TCS1");
			job.put("createdBy", "Punit Ranjan");
			job.put("status", "on going");
			job.put("teamSize", 6);
			
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
		
		}
}
