package com.lulobank.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.lulobank.factory.CreateBreedDataFactory.ID_BREED;
import static net.serenitybdd.rest.SerenityRest.given;

public class Delete implements Task {

    private final String resourceApi;

    public Delete(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        given().
                and().when().delete(resourceApi+"/"+ID_BREED)
                .then().extract().response();
    }

    public static Delete deleteBreed(String resourceApi1){
        return Tasks.instrumented(Delete.class, resourceApi1);
    }
}
