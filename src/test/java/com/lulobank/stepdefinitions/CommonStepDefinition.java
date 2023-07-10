package com.lulobank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.lulobank.exceptions.ErrorsAssertion.*;
import static com.lulobank.questions.Response.*;
import static com.lulobank.tasks.DeleteVote.executeDeleteMethodWithThe;
import static com.lulobank.tasks.Get.executeGetMethodWithThe;
import static com.lulobank.tasks.GetVotes.executeGetVoteMethodWithThe;
import static com.lulobank.tasks.PostVote.applyVote;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonStepDefinition {

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
        givenThat(theActorCalled("Edy").whoCan(CallAnApi.at("/")));
    }
    @When("Execute the method GET vote with the resource api {string}")
    public void executeTheMethodGETVoteWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetVoteMethodWithThe(resourceApi, ""));
    }
    @Then("see that the is returned {int}")
    public void seeThatTheIsReturned(Integer statusCode) {
        assertThat(THE_CODES_DO_NOT_MATCH,
                theActorInTheSpotlight().asksFor(getStatusCode()), equalTo(statusCode)
        );
    }

    @When("Execute the method DELETE with the resource api {string}")
    public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
        theActorInTheSpotlight().attemptsTo(
                executeDeleteMethodWithThe(resourceApi)
        );
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

        @Then("Code returned is {int}")
        public void codeReturned (Integer statusCode) {
            assertThat(THE_VOTE_WAS_NOT_DELETE_SUCCESSFULLY,
                    theActorInTheSpotlight().asksFor(getStatusCode()), equalTo(statusCode));
    }
    @Then("Check if the vote was delete successfully")
    public void checkIfTheVoteWasDeleteSuccessfully() {
        assertThat(THE_VOTE_WAS_NOT_DELETE_SUCCESSFULLY,
                theActorInTheSpotlight().asksFor(getMessageVote()), equalTo("SUCCESS"));
    }


    @When("Execute the method GET with the resource api {string}")
    public void executeTheMethodGETWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetMethodWithThe(resourceApi));
    }


}
