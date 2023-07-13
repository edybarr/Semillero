package com.lulobank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.lulobank.exceptions.ErrorsAssertion.*;
import static com.lulobank.questions.Response.getMessageVote;
import static com.lulobank.questions.Response.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonStepDefinition {

    @Before
    public static void actor() {
        OnStage.setTheStage(new Cast());
        theActorCalled("Edy");
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

    @Given("Que se especifica un entorno de prueba")
    public void MakeTheConnectionToTheApi() {
        givenThat(theActorCalled("Edy").whoCan(CallAnApi.at("/")));
    }

    @Then("Valida que retorna el código {int}")
    public void seeThatTheIsReturned(Integer statusCode) {
        assertThat(THE_CODES_DO_NOT_MATCH,
                theActorInTheSpotlight().asksFor(getStatusCode()), equalTo(statusCode)
        );
    }

    @Then("Valida que retorna código {int}")
    public void codeReturned(Integer statusCode) {
        assertThat(THE_VOTE_WAS_NOT_DELETE_SUCCESSFULLY,
                theActorInTheSpotlight().asksFor(getStatusCode()), equalTo(statusCode));
    }

    @Then("Verifica si el voto se creó correctamente")
    public void checkIfTheVoteWasCreateSuccessfully() {
        assertThat(THE_VOTE_WAS_NOT_CREATED_SUCCESSFULLY,
                theActorInTheSpotlight().asksFor(getMessageVote()), equalTo("SUCCESS"));
    }

    @Then("Verifica si el voto fue borrado correctamente")
    public void checkIfTheVoteWasDeleteSuccessfully() {
        assertThat(THE_VOTE_WAS_NOT_DELETE_SUCCESSFULLY,
                theActorInTheSpotlight().asksFor(getMessageVote()), equalTo("SUCCESS"));
    }
}
