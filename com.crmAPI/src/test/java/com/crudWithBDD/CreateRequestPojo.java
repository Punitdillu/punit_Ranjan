package com.crudWithBDD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmApiPojo.AddrequestWithPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateRequestPojo {

		@Test(dataProvider="data")
		public void sendrequest(String name, String job) {
			
			AddrequestWithPojo a=new AddrequestWithPojo(name,job);
			given()
			.body(a)
			.contentType(ContentType.JSON)
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.assertThat().statusCode(201)
			.log().all();
			
			
			
		}
		
		@DataProvider
		public Object[][] data() {
			Object[][] oj=new Object[][]{
			{"Punit","Automation Engineer"},
			{"Ramit","Developer"}
			};
			return oj;
		}
}
