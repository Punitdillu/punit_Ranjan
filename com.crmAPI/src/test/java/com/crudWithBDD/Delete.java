package com.crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Delete {

		@Test
		public void deleteProject() {
			
			baseURI="http://localhost:8084";
			when()
			.delete("/projects/TY_PROJ_610")
			.then()
			.assertThat().statusCode(204)
			.log().all();
			
		}
}
