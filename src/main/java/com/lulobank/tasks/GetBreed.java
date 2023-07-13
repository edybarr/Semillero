package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class GetBreed implements Task {

    private final String resourceApi;
    private final String breed;

    public GetBreed(String resourceApi, String breed) {
        this.resourceApi = resourceApi;
        this.breed = breed;
    }

    @Step("{0} consume get method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if ("breeds".equals(resourceApi)) {
            given().
                    and().when().get(resourceApi)
                    .then().extract().response();
        } else {
            given().
                    //and().when().get(resourceApi+"s/"+"drex")
                            and().when().get(resourceApi + "s/" + breed)
                    .then().extract().response();
        }
    }

    public static GetBreed executeGetMethodWithThe(String resourceApi, String breed) {
        return Tasks.instrumented(GetBreed.class, resourceApi, breed);
    }
}



