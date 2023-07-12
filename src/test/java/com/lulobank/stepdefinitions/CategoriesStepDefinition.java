package com.lulobank.stepdefinitions;

import com.lulobank.tasks.GetCategories;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.lulobank.exceptions.ErrorsAssertion.THE_CATEGORIES_DO_NOT_ARE_EQUALS;
import static com.lulobank.questions.Response.getNameCategory;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoriesStepDefinition {
    @When("Execute method GET categories with the resource api {string}")
    public void executeMethodGETCategoriesWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(GetCategories.with(resourceApi));
    }
    @Then("Check if the categories exists successfully")
    public void CheckIfTheCategoriesExistsSuccessfully() {
    assertThat(THE_CATEGORIES_DO_NOT_ARE_EQUALS,
    theActorInTheSpotlight().asksFor(getNameCategory()), equalTo("15"));
    }
}
