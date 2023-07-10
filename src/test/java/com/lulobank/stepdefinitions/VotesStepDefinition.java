package com.lulobank.stepdefinitions;

import com.github.javafaker.Faker;
import com.lulobank.models.VoteID;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import java.util.List;

import static com.lulobank.exceptions.ErrorsAssertion.*;
import static com.lulobank.questions.Response.*;
import static com.lulobank.tasks.GetVotes.executeGetVoteMethodWithThe;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VotesStepDefinition {

    @When("Execute the method GET vote with a voteID the resource api {string} and ID {string}")
    public void executeTheMethodGETVoteWithVoteIDTheResourceApi(String resourceApi, String voteID) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetVoteMethodWithThe(resourceApi, voteID));
    }
    @When("Save a random vote")
    public void saveARandomVote()  {
        List<VoteID> listVoteID = theActorInTheSpotlight().asksFor(getVotes());
        Faker FAKER = new Faker();
        VoteID idVote = listVoteID.get(FAKER.random().nextInt(0, listVoteID.size()-1));
        theActorInTheSpotlight().remember("ID_VOTE", idVote.getID());
    }
    @Then("Save the vote ID was create successfully")
    public void saveTheVoteIDWasCreateSuccessfully() {
       theActorInTheSpotlight().remember("ID_VOTE", theActorInTheSpotlight().asksFor(edyGetVoteID()));
    }
}
