package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.lulobank.factory.CreateVoteDataFactory.ID_VOTE;
import static com.lulobank.utils.Constants.API_KEY;
import static com.lulobank.utils.Constants.X_API_KEY;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import static net.serenitybdd.screenplay.rest.interactions.Delete.from;

public class DeleteVote implements Task {

    private final String resourceApi;

    public DeleteVote(String resourceApi) {
        this.resourceApi = resourceApi;
    }
    @Step("{0} consume delete method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        given()
                .header(X_API_KEY,API_KEY)
                .and().when().delete(resourceApi + "/" + ID_VOTE)
                .then().extract().response();
    }
    public static DeleteVote executeDeleteMethodWithThe(String resourceApi){
        return Tasks.instrumented(DeleteVote.class, resourceApi);
    }
}
