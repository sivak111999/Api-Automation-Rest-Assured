package api.endpoints;

import io.restassured.http.ContentType;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.Payload.user;




public class userendpoints2 {
	
	
	static ResourceBundle geturl() {
		 ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
		
	}

	 public static     Response createuser(user Payload ){
	String create_user=	geturl().getString("create_user");
		 System.out.println("Payload: " + Payload);

		 Response response=given()
			
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload) 

		.when()
		.post(create_user);
		 return response;
		
			
		
		
		
	 }
	 public static   Response getuser(String username){
		 String get_user=	geturl().getString("get_user");
		 Response response=given()
			
		
		.pathParam("username", username)
		.when()
		.get(get_user);
		return response;
			
		
		
		
	 }
	 public static   Response updateuser(String username,user Playload){
		 String update_user=	geturl().getString("update_user");
		 Response response=given()
			
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body( Playload)
		.pathParam("username", username)
		.when()
		.put(update_user);
		return response;
			
		
		
		
	 }
	 public static  Response deleteuser(String username){
		 String delete_user=	geturl().getString("delete_user");
		 Response response=given()
			
		
		.pathParam("username", username)
		.when()
		.delete(delete_user);
		return response;
			
		
		
		
	 }
}
