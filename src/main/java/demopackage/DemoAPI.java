package demopackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoAPI {
  
	  @Test
	  void getweatherDetails()
	  {
	   RestAssured.baseURI="https://reqres.in/api/users";
	   
	   //Request object
	   RequestSpecification httpRequest=RestAssured.given();
	   Response response=httpRequest.request(Method.GET,"/2");	   
	   String responseBody=response.getBody().asString();
	   System.out.println("Response Body is:" +responseBody);
	   
	   //status code validation
	   int statusCode=response.getStatusCode();
	   System.out.println("Status code is: "+statusCode);
	   Assert.assertEquals(statusCode, 200);
	   
	   //status line verification
	   String statusLine=response.getStatusLine();
	   System.out.println("Status line is:"+statusLine);
	   Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	   
	  }
}
