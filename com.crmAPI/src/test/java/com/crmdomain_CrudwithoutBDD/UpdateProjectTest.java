package com.crmdomain_CrudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

		@Test
		public void update() {
			
			int statuscode=200;
			//create neccesary data
			JSONObject job=new JSONObject();
			job.put("projectName", "Sony211");
			job.put("createdBy", "Punit Ranjan");
			job.put("status", "complete");
			job.put("teamSize", 12);
			
			//send request
			RequestSpecification req=RestAssured.given();
			req.body(job);
			req.contentType(ContentType.JSON);
			Response resp= req.put("http://localhost:8084/projects/TY_PROJ_607");
			
			int actualstatuscode = resp.getStatusCode();
			Assert.assertEquals(statuscode, actualstatuscode);
			resp.then().assertThat().statusCode(actualstatuscode);
			resp.then().log().all();
		}
}
