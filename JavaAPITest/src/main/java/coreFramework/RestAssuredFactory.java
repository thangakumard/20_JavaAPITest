package coreFramework;

import java.util.Map;

import org.apache.http.client.methods.RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredFactory {

	
	
	RequestSpecBuilder builder = new RequestSpecBuilder();
	private String method;
	private String url;
	
	public RestAssuredFactory(String uri, String method, String token) {
		this.url = "http://localhost:3000" + uri;
		this.method = method;
		
		if(token != null && !token.isEmpty()) {
			builder.addHeader("Authorization", "Bearer " + token);
		}	
	}
	
	private ResponseOptions<Response> sendRequest(){
		RequestSpecification requestSpecification = builder.build();
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.contentType(ContentType.JSON);
		httpRequest.spec(requestSpecification);
		
		if(this.method.equalsIgnoreCase(Constants.ApiMethods.GET)) {
			return httpRequest.get(this.url);
		}
		else if(this.method.equalsIgnoreCase(Constants.ApiMethods.POST)) {
			return httpRequest.post(this.url);
		}
		else if(this.method.equalsIgnoreCase(Constants.ApiMethods.DELETE)) {
			return httpRequest.delete(this.url);
		}
		return null;
	}
	
	public ResponseOptions<Response> sendhttpRequest() {
		return sendRequest();
	}
	public String Authenticate(Object body) {
		builder.setBody(body);
		return sendRequest().getBody().jsonPath().get("access_token");
	}
	
	public ResponseOptions<Response> ExecuteWithQueryParams(Map<String, String> queryPath) {
        builder.addQueryParams(queryPath);
        return sendRequest();
    }
	public ResponseOptions<Response> ExecuteWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams(pathParams);
        return sendRequest();
    }
	
	public ResponseOptions<Response> ExecuteWithPathParamsAndBody(Map<String, String> pathParams, Map<String, String> body) {
        builder.setBody(body);
        builder.addPathParams(pathParams);
        return sendRequest();
    }
}
