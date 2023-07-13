package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.lulobank.utils.Constants.API_KEY;
import static com.lulobank.utils.Constants.X_API_KEY;
import static net.serenitybdd.rest.SerenityRest.given;

public class GetVotes implements Task {

    private final String resourceApi;
    private final String voteID;

    public GetVotes(String resourceApi, String voteID) {
        this.resourceApi = resourceApi;
        this.voteID = voteID;
    }

    @Step("{0} consume get method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (voteID.isBlank()) {
            given()
                    .header(X_API_KEY, API_KEY)
                    .and().when().get(resourceApi)
                    .then().extract().response();
        } else {
            given().header(X_API_KEY, API_KEY).param("vote_id", voteID)
                    .and().when().get(resourceApi)
                    .then().extract().response();
        }
    }

    public static GetVotes executeGetVoteMethodWithThe(String resourceApi, String voteID) {
        return Tasks.instrumented(GetVotes.class, resourceApi, voteID);
    }
}



