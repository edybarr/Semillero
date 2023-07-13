package com.lulobank.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.lulobank.exceptions.ErrorsAssertion.THE_BREED_DOES_NOT_IS_EQUAL;
import static com.lulobank.questions.Response.getMessage;
import static com.lulobank.tasks.GetBreed.executeGetMethodWithThe;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BreedsStepDefinition {

    @When("Ejecutar método con el recurso {string}")
    public void executeTheMethodGETWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetMethodWithThe(resourceApi, ""));
    }

    @When("Ejecutar el método con la {string} y el recurso api {string}")
    public void executeTheMethodGETWithTheResourceApi(String breed, String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetMethodWithThe(resourceApi, breed));
    }

    @Then("Confirmar la raza se obtiene correctamente")
    public void CheckIfTheBreedExistsSuccessfully() {
        assertThat(THE_BREED_DOES_NOT_IS_EQUAL,
                theActorInTheSpotlight().asksFor(getMessage()), equalTo("United States")
        );
    }
}
