package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static net.serenitybdd.rest.SerenityRest.given;

public class Post implements Task {

    private String resourceApi;

    public Post(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        given()
                .body
                and().post(resourceApi).then.extract().response();

    }

    public static Post createBreedWithThe(String resourceApi){
        return Tasks.instrumented(Post.class, resourceApi);

    }
}
