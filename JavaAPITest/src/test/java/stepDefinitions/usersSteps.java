package stepDefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import coreFramework.RestAssuredFactory;
import coreFramework.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.User;

public class usersSteps {

ResponseOptions<Response> response = null;
	
@Given("test execution start for the test case id {int}")
public void test_execution_start_for_the_test_case_id(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Test Case ID :"+ int1);
}


@When("^the GET http request is sent for the \"(.*)\" api$")
public void the_get_request_is_sent_for_users_api(String api) {
	RestAssuredFactory rsFactory = new RestAssuredFactory(api, "GET", null);
	response = rsFactory.sendhttpRequest();
}

@Then("response status code is {int}")
public void response_status_code_is(Integer int1) {
	assertThat(response.getStatusCode(), equalTo(int1));
}

@Then("the response object has valid response")
public void the_response_object_has_valid_response() {
    User userReponse = response.getBody().as(User.class);
    
    JSONObject obj = Util.fetchTemplateAsObject(); 
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    
    Gson gson = builder.create();
    User userExpected = gson.fromJson(obj.toString(), User.class);
    
    
}
}
