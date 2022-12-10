package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 

public class CRUDStepDefs {
	Map<String,Object>Mapobject;
	Response response;
	RequestSpecification request;

	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
		
	request=RestAssured.given().baseUri(URI);
	    
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
		
		response=request.get("employees");
	    
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
	    
		
		Assert.assertEquals(expResponseCode, response.getStatusCode());
	}

	
	@When("I create new employee with name {string} and salary {int}")
	public void i_create_new_employee_with_name_and_salary(String name, int salary) {
		Mapobject=new HashMap<String,Object>();
		Mapobject.put("name", name);
		Mapobject.put("salary", salary);
		
	}

	@And("I perform the post Operation")
	public void i_perform_the_post_Operation() {
		response=request
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(Mapobject).post("employees/create");
	}

}
