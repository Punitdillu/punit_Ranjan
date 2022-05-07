package com.crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProject1BDDTest {

	@Test
	public void create() {
		
		baseURI="http://localhost:8084";
		Random r=new Random();
				int x=r.nextInt(1000);
				
				String name="samsung"+x;
		JSONObject js =new JSONObject();
		js.put("projectName", name);
		js.put("createdBy", "Punit Ranjan");
		js.put("status", "going on");
		js.put("teamSize", 8);
		
		given()
		.body(js)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		
		.assertThat().statusCode(201)
		.log().all();
	}
}
