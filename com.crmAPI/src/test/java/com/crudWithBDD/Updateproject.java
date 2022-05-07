package com.crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Updateproject {

		@Test
		public void update() {
			baseURI="http://localhost:8084";
			
			JSONObject job=new JSONObject();
			job.put("projectName", "TCS1");
			job.put("createdBy", "Punit Ranjan");
			job.put("status", "on going");
			job.put("teamSize", 20);
			given()
			.body(job)
			.contentType(ContentType.JSON)
			
			.when()
			.put("/projects/TY_PROJ_612")
			.then()
			.assertThat().statusCode(200)
			.log().all();
		
		}
}
