package com.lulobank.tasks;

import com.google.gson.Gson;
import com.lulobank.models.CreateVoteRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.lulobank.factory.CreateVoteDataFactory.*;
import static com.lulobank.models.CreateVoteRequestBuilder.aVote;
import static com.lulobank.utils.Constants.API_KEY;
import static com.lulobank.utils.Constants.X_API_KEY;
import static net.serenitybdd.rest.SerenityRest.given;

public class PostVote implements Task {

    private final String resourceApi;
    public PostVote(String resourceApi) {
        this.resourceApi = resourceApi;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        CreateVoteRequest vote = aVote()
                .withImage_id(IMAGE_ID)
                .withSub_id(SUB_ID)
                .withValue(VALUE)
                .build();

        String voteJson = new Gson().toJson(vote);
        given()
                .header(X_API_KEY, API_KEY)
                .contentType(ContentType.JSON)
                .body(voteJson)
                .post(resourceApi)
                .then().extract().response();
    }

    public static PostVote applyVote(String resourceApi){
        return Tasks.instrumented(PostVote.class, resourceApi);
    }
}
