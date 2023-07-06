package com.lulobank.stepdefinitions;

import com.lulobank.tasks.GetCategories;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.lulobank.exceptions.ErrorsAssertion.*;
import static com.lulobank.questions.Response.*;
import static com.lulobank.tasks.DeleteVote.executeDeleteMethodWithThe;
import static com.lulobank.tasks.Get.executeGetMethodWithThe;
import static com.lulobank.tasks.PostVote.applyVote;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ExecuteServicesStepDefinition {


    private static final String THE_VOTE_WAS_NOT_CREATED_SUCCESSFULLY = "The vote was not created successfully";

    private String deleteResponseMessage;

    @Before
    public static void actor() {
        OnStage.setTheStage(new Cast());
        theActorCalled("Edy");
        //ResourceBundle rb = ResourceBundle.getBundle("config", Locale.getDefault());
        //System.out.println("element1: " + rb.getString("hello"));
        //System.out.println("elemento2: " + rb.getString("world"));
    }

    @Before
    public static void setUpRest() {
        RestAssured.baseURI = "https://api.thecatapi.com/";
        RestAssured.basePath = "/v1";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .build();
    }

    @Given("I make the connection to the api")
    public void iMakeTheConnectionToTheApi() {
        // Write code here that turns the phrase above into concrete actions
        ;
        givenThat(theActorCalled("Edy").whoCan(CallAnApi.at("/")));

    }

    @When("Execute the method GET with the resource api {string}")
    public void executeTheMethodGETWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetMethodWithThe(resourceApi));
    }

    @Then("see that the is returned {int}")
    public void seeThatTheIsReturned(Integer statusCode) {
        assertThat(THE_CODES_DO_NOT_MATCH,
                theActorInTheSpotlight().asksFor(getStatusCode()), equalTo(statusCode)
        );
    }

    @Then("Check if the breed exists successfully")
    public void CheckIfTheBreedExistsSuccessfully() {
        assertThat(THE_BREED_DOES_NOT_IS_EQUAL,
                theActorInTheSpotlight().asksFor(getMessage()), equalTo("United Kingdom")
        );
    }

    @When("Execute method GET with the resource api {string}")
    public void executeMethodGETWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(GetCategories.with(resourceApi));
    }

    @Then("Check if the categories exists successfully")
    public void CheckIfTheCategoriesExistsSuccessfully() {
        assertThat(THE_CATEGORIES_DO_NOT_ARE_EQUALS,
                theActorInTheSpotlight().asksFor(getNameCategories()), equalTo("15")
        );
    }

    @When("Execute the method DELETE with the resource api {string}")
    public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
        theActorInTheSpotlight().attemptsTo(
                executeDeleteMethodWithThe(resourceApi)
        );
        deleteResponseMessage = SerenityRest.then().extract().path("message");
    }

    @Then("Check if the vote was delete successfully")
    public void checkIfTheVoteWasDeleteSuccessfully() {
        assertThat(deleteResponseMessage, equalTo("success"));
    }


    @When("Execute the method POST with the resource api {string}")
    public void executeTheMethodPOSTWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(applyVote(resourceApi));
    }

    @Then("Check if the vote was create successfully")
    public void checkIfTheVoteWasCreateSuccessfully() {
        assertThat(THE_VOTE_WAS_NOT_CREATED_SUCCESSFULLY,
                theActorInTheSpotlight().asksFor(getMessageVote()), equalTo("SUCCESS"));
    }

}
