package com.crmdomain_CrudwithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject1Test {

		@Test
		public void create() {
			Random r=new Random();
			int x=r.nextInt(1000);
			String projectname="Samsung"+x;
			
			//creste n
			JSONObject js=new JSONObject();
			js.put("projectName", projectname);
			js.put("createdBy", "Ramit Ranjan");
			js.put("status", "completed");
			js.put("team size", 8);
			
			RequestSpecification reqsp = RestAssured.given();
			reqsp.body(js);
			reqsp.contentType(ContentType.JSON);
			Response resp = reqsp.post("http://localhost:8084/addProject");
			System.out.println(resp.asPrettyString());
			resp.then().assertThat().statusCode(201);
		}
}
