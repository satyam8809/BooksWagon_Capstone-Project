package stepDefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CRUD_StepDef {

    private Response response;

    @Given("I have a base URI of {string}")
    public void i_have_a_base_uri_of(String uri) {
        baseURI = uri;
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given().log().all().when().get(endpoint);
    }

    @When("I send a POST request to {string} with body as {string}")
    public void i_send_a_post_request_to_with_body_as(String endpoint, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .log().all()
                .body(body)
                .when()
                .post(endpoint);
    }

    @When("I send a PUT request to {string} with body as {string}")
    public void i_send_a_put_request_to_with_body_as(String endpoint, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .log().all()
                .body(body)
                .when()
                .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given().log().all().when().delete(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().log().all().statusCode(statusCode);
    }

    @Then("the response time less than {long}")
    public void the_response_time_less_than(Long milliseconds) {
        response.then().time(lessThan(milliseconds));
    }
}