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
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.lulobank.exceptions.ErrorsAssertion.THE_CODES_DO_NOT_MATCH;
import static com.lulobank.questions.Response.*;
import static com.lulobank.tasks.Delete.deleteBreed;
import static com.lulobank.tasks.Get.executeGetMethodWithThe;
import static com.lulobank.utils.Constants.SUCCESS;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ExecuteServicesStepDefinition {

    @Before
    public static void actor(){
        OnStage.setTheStage(new Cast());
        theActorCalled("Edy");
        //ResourceBundle rb = ResourceBundle.getBundle("config", Locale.getDefault());
        //System.out.println("element1: " + rb.getString("hello"));
        //System.out.println("elemento2: " + rb.getString("world"));
    }
    @Before
    public static void setUpRest(){
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
        assertThat("The breed do not are equals",
                theActorInTheSpotlight().asksFor(getMessage()), equalTo("United Kingdom")
        );
    }
    //@When("Execute the method DELETE with the resource api {String}")
    //Public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
      //  when(theActorInTheSpotlight()).wasAbleTo(deleteBreed(resourceApi));


    //@Then("check if the breed was delete successfully")
    //public void checkIfTheBreedWasDeleteSuccessfully() {
      //   assertThat("the breed do not match",
        //      theActorInTheSpotlight().asksFor(getMessage()), equalTo("success")
         //);
}