package com.lulobank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.lulobank.exceptions.ErrorsAssertion.THE_BREED_DOES_NOT_IS_EQUAL;
import static com.lulobank.questions.Response.getMessage;
import static com.lulobank.questions.Response.getNameBred;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BreedsStepDefinition {
    @Then("Check if the breed exists successfully")
    public void CheckIfTheBreedExistsSuccessfully() {
        assertThat(THE_BREED_DOES_NOT_IS_EQUAL,
                theActorInTheSpotlight().asksFor(getMessage()), equalTo("United Kingdom")
        );

        assertThat(THE_BREED_DOES_NOT_IS_EQUAL,
                theActorInTheSpotlight().asksFor(getNameBred()), equalTo("Devon Rex")
        );
    }
}
