package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIEnumResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {
    ResponseSpecification respec;
    RequestSpecification response;
    Response res;
   static String place;
    TestDataBuild data=new TestDataBuild();
       @Given("Add place payload {string} {string} {string}")
    public void add_place_payload(String name, String lang, String add) throws IOException {
   	   response= given().spec(requestSpecification()).body(data.addplacePayload(name,lang,add));
	}
       @When("user calls {string} with {string} http request")
       public void user_calls_with_http_request(String resource, String method) {
    
	 	APIEnumResources suburl=APIEnumResources.valueOf(resource);
		//url.getResource();
		respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		  
		if(method.equalsIgnoreCase("POST"))
		res= response.when().post(suburl.getResource());
		if(method.equalsIgnoreCase("GET")) {
			res= response.when().get(suburl.getResource());
		}
		           // then().spec(respec).extract().response();
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(res.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		
	   assertEquals(getJsonpath(res, keyValue),Expectedvalue);
	}
		@Then("verify place_ID matche to {string} using {string}")
	public void verify_place_id_matche_to_using(String Expectedname, String resource) throws IOException {
			place=getJsonpath(res, "place_id");
			response= given().spec(requestSpecification()).queryParam("place_id", place);
			user_calls_with_http_request(resource,"GET");
			String actualname=getJsonpath(res, "name");
			assertEquals(actualname,Expectedname);
		}
		@Given("DeletePlace Payload")
		public void delete_place_payload() throws IOException {
		  response= given().spec(requestSpecification()).body(data.deletePlacePayload(place));
		}





}
