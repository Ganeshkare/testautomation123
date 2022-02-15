package demopackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest {
	 @Test
	 void RegistrationSuccessful()
	 {
	  
	  RestAssured.baseURI="https://reqres.in/api/users";
	  
	  RequestSpecification httpRequest=RestAssured.given();	  
	  JSONObject requestParams=new JSONObject();	  
	  requestParams.put("name","morpheus");
	  requestParams.put("job","leader");
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requestParams.toJSONString()); 
	  Response response=httpRequest.request(Method.POST,"/create");
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);

	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 201); 
	 }
	 
}
