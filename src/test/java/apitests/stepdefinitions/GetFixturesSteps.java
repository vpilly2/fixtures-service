package apitests.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GetFixturesSteps {
    private String path;
    private Response response;

    @Given("the fixtures endpoint exists")
    public void theFixturesEndpointExists() {
        RestAssured.baseURI = "https://localhost:3000";
        path = "/???";
    }

    @When("I make get API call to fixtures service")
    public void iMakeGetAPICallToFixturesService() {
        response = given()
                .contentType(ContentType.JSON)
                .get(path)
                .then().extract().response();
    }

    @Then("I should receive http response code {int}")
    public void iShouldReceiveHttpResponseCode(int arg0) {
    }

    @And("the response should have all fixtures")
    public void theResponseShouldHaveAllFixtures(int noOfFixtures) {

//        String id = response.jsonPath().get("id");
//        int noOfFixtures = response.jsonPath(fixtureId);

       assertThat(noOfFixtures, is(3));
    }

    @Then("response code should be {int}")
    public void responseCodeShouldBe(int code) {
        assertThat(code, is(200));
    }
}
