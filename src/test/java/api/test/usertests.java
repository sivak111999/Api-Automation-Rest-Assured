package api.test;

import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.user;
import api.endpoints.userendpoints;
import io.restassured.response.Response;

public class usertests {
	
	Faker faker;
	user USER ;
	
	@BeforeClass
	public void setupdata() {
		
		faker = new Faker();
	 USER= new user();
		
		 USER.setId(faker.idNumber().hashCode());
		 USER.setUsername(faker.name().username());
		 USER.setFirstName(faker.name().firstName());
		 USER.setLastName(faker.name().lastName());
		 USER.setEmail(faker.internet().safeEmailAddress());
		 USER.setPassword(faker.internet().password(2, 5));
		 USER.setPhone(faker.phoneNumber().cellPhone());
		 USER.setUserStatus(1);
		
		/* USER.setUsername("testuser123");
		    USER.setFirstName("Siva");
		    USER.setLastName("Reddy");
		    USER.setEmail("siva@gmail.com");
		    USER.setPassword("Test@123");
		    USER.setPhone("9876543210");
		    USER.setUserStatus(1);*/

		
		
		
	}
	
	@Test(priority=1)
	public void testpostuser() {
	    
		Response response = userendpoints.createuser(USER);
		 response.then().log().all();
	    System.out.println("Status Code: " + response.getStatusCode());
	    System.out.println("Response: " + response.asPrettyString());
	    

	    Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testgetuserbyname() {
		Response response = userendpoints.getuser(this.USER.getUsername());
		response.then().log().all();
		  Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void testupdateuserbynmae() {
		
		
		 USER.setFirstName(faker.name().firstName());
		 USER.setLastName(faker.name().lastName());
		 USER.setEmail(faker.internet().safeEmailAddress());
		//
		Response response = userendpoints.updateuser(this.USER.getUsername(),USER);
		response.then().log().all();
		  Assert.assertEquals(response.getStatusCode(), 200);
		  Response responseafterupdate = userendpoints.getuser(this.USER.getUsername());
			response.then().log().all();
			  Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testdeleteuserrbynmae() {
		Response response = userendpoints.deleteuser(this.USER.getUsername());
		
		  Assert.assertEquals(response.getStatusCode(), 200);
	}
	}
		
	
		
	
		
	
		
		
	


