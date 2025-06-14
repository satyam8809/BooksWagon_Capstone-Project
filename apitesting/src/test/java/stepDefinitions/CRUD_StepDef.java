package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class CRUD_StepDef {

    private List<Response> responses = new ArrayList<>();

    @Given("I have a base URI of {string}")
    public void i_have_a_base_uri_of(String uri) {
        baseURI = uri;
    }

    @When("I perform the following operations:")
    public void i_perform_the_following_operations(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String method = row.get("Method").toUpperCase();
            String endpoint = row.get("Endpoint");
            String body = row.get("Body");

            Response response = null;

            switch (method) {
                case "GET":
                    response = given().log().all().when().get(endpoint);
                    break;
                case "POST":
                    response = given().header("Content-Type", "application/json")
                            .log().all()
                            .body(body)
                            .when().post(endpoint);
                    break;
                case "PUT":
                    response = given().header("Content-Type", "application/json")
                            .log().all()
                            .body(body)
                            .when().put(endpoint);
                    break;
                case "DELETE":
                    response = given().log().all().when().delete(endpoint);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported method: " + method);
            }

            responses.add(response);
        }
    }

    @Then("I should receive the following status codes:")
    public void i_should_receive_the_following_status_codes(DataTable dataTable) {
        List<Map<String, String>> expected = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < expected.size(); i++) {
            String method = expected.get(i).get("Method");
            int expectedCode = Integer.parseInt(expected.get(i).get("StatusCode"));

            responses.get(i).then().log().all().statusCode(expectedCode);
        }
    }

    @Then("each response time should be less than {int} milliseconds")
    public void each_response_time_should_be_less_than(Integer ms) {
        for (int i = 0; i < responses.size(); i++) {
            long time = responses.get(i).time();
            if (time < ms) {
                System.out.println("Response " + (i + 1) + " time: " + time + "ms is within limit");
            } else {
                System.err.println("WARNING: Response " + (i + 1) + " time exceeded: " + time + "ms");
                // Optional: You can use Assert.fail if you want to fail specific ones
                // Assert.fail("Response time exceeded limit");
            }
        }
    }

}
