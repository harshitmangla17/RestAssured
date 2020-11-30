package GetPostPutDelete;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class GetPost {

	@Test
	public void get_demo()
	{
		given().
		
		when().
		get("http://localhost:3000/Candidates_Profile/9")
		.then()
		.statusCode(200)
		.assertThat().body("name", equalTo("Hemant"))
		.log().all();
	}
	
	@Test(priority = 1)
	public void post_demo()
	{
		RestAssured.baseURI="http://localhost:3000/Candidates_Profile";
		
		JSONObject postobj = new JSONObject();
		postobj.put("name", "Kartik");
		postobj.put("contact_no", "98589785");
		postobj.put("address", "New Delhi");
		given()
		.body(postobj.toJSONString()).contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(201)
		.log().all();
		
	}
}
