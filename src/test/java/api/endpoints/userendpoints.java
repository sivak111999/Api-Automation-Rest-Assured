package api.endpoints;

import io.restassured.http.ContentType;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.user;




public class userendpoints {

	 public static     Response createuser(user Payload ){
		
		 System.out.println("Payload: " + Payload);

		 Response response=given()
			
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload) 

		.when()
		.post(Routes.create_user);
		 return response;
		
			
		
		
		
	 }
	 public static   Response getuser(String username){
			
		 Response response=given()
			
		
		.pathParam("username", username)
		.when()
		.get(Routes.get_user);
		return response;
			
		
		
		
	 }
	 public static   Response updateuser(String username,user Playload){
			
		 Response response=given()
			
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body( Playload)
		.pathParam("username", username)
		.when()
		.put(Routes.update_user);
		return response;
			
		
		
		
	 }
	 public static  Response deleteuser(String username){
			
		 Response response=given()
			
		
		.pathParam("username", username)
		.when()
		.delete(Routes.delete_user);
		return response;
			
		
		
		
	 }
}
