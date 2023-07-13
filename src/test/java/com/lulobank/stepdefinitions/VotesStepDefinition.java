package com.lulobank.stepdefinitions;

import com.github.javafaker.Faker;
import com.lulobank.models.VoteID;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.lulobank.questions.Response.edyGetVoteID;
import static com.lulobank.questions.Response.getVotes;
import static com.lulobank.tasks.DeleteVote.executeDeleteMethodWithThe;
import static com.lulobank.tasks.GetVotes.executeGetVoteMethodWithThe;
import static com.lulobank.tasks.PostVote.applyVote;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class VotesStepDefinition {

    @When("Se ejecuta el método para obtener los votos en la APICAT con el recurso {string}")
    public void executeTheMethodGETVoteWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetVoteMethodWithThe(resourceApi, ""));
    }

    @When("Se ejecuta el método para obtener un voto específico en la APICAT con el recurso {string} y ID {string}")
    public void executeTheMethodGETVoteWithVoteIDTheResourceApi(String resourceApi, String voteID) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetVoteMethodWithThe(resourceApi, voteID));
    }

    @When("Se ejecuta el method para crear un voto con el recurso {string}")
    public void executeTheMethodPOSTWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(applyVote(resourceApi));
    }

    @When("Guarda un voto aleatorio")
    public void saveARandomVote() {
        List<VoteID> listVoteID = theActorInTheSpotlight().asksFor(getVotes());
        Faker FAKER = new Faker();
        VoteID idVote = listVoteID.get(FAKER.random().nextInt(0, listVoteID.size() - 1));
        theActorInTheSpotlight().remember("ID_VOTE", idVote.getID());
    }

    @When("Ejecuta el método con el recurso {string}")
    public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
        theActorInTheSpotlight().attemptsTo(
                executeDeleteMethodWithThe(resourceApi)
        );
    }

    @Then("Guarda el ID del voto que se creó exitosamente")
    public void saveTheVoteIDWasCreateSuccessfully() {
        theActorInTheSpotlight().remember("ID_VOTE", theActorInTheSpotlight().asksFor(edyGetVoteID()));
    }
}
