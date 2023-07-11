package com.lulobank.stepdefinitions;

import io.cucumber.java.en.Then;

import static com.lulobank.exceptions.ErrorsAssertion.THE_BREED_DOES_NOT_IS_EQUAL;
import static com.lulobank.questions.Response.getMessage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BreedsStepDefinition {
    @Then("Check if the breed exists successfully")
    public void CheckIfTheBreedExistsSuccessfully() {
        assertThat(THE_BREED_DOES_NOT_IS_EQUAL,
                theActorInTheSpotlight().asksFor(getMessage()), equalTo("United States")
        );
    }
}
