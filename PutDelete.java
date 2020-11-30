package GetPostPutDelete;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PutDelete {
  @Test
  public void PutDeleteDemo()
  {
	RestAssured.baseURI="http://localhost:3000/Candidates_Profile"; 
	RestAssured.basePath="/6";
	JSONObject putobj = new JSONObject();
	putobj.put("name", "Mohan");
	putobj.put("contact_no", "98745698");
	putobj.put("address", "Jaipur");
	
	given()
	.body(putobj.toJSONString()).contentType(ContentType.JSON)
	.when()
	.put()
	.then()
	.statusCode(200).log().all();
  }
  
  @Test(priority = 1)
  public void DeleteDemo()
  {
	  RestAssured.baseURI="http://localhost:3000/Candidates_Profile";
	  RestAssured.basePath="/8";
	  given()
	  .when()
	  .delete()
	  .then()
	  .statusCode(200)
	  .statusLine("HTTP/1.1 200 OK")
	  .log().all();
  }
}
