package stepDefinitions;

import coreFramework.RestAssuredFactory;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class usersSteps {


	ResponseOptions<Response> response = null;
	
@Given("test execution start for the test case id {int}")
public void test_execution_start_for_the_test_case_id(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Test Case ID :"+ int1);
}


@When("the GET request is sent for \\/users\\/ api")
public void the_get_request_is_sent_for_users_api() {
	RestAssuredFactory rsFactory = new RestAssuredFactory("/users/", "GET", null);
	response = rsFactory.sendhttpRequest();
}

@Then("response status code is {int}")
public void response_status_code_is(Integer int1) {
	assertThat(response.getStatusCode(), equalTo(int1));
}


}
