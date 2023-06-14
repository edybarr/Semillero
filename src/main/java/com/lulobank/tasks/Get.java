package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.lulobank.factory.CreateBreedDataFactory.ID_BREED;
import static net.serenitybdd.rest.SerenityRest.given;

public class Get implements Task {

    private String resourceApi;

    public Get(String resourceApi) {
        this.resourceApi = resourceApi;
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
                    and().when().get(resourceApi+"s/"+"drex")
                    .then().extract().response();
        }
    }

        public static Get executeGetMethodWithThe (String resourceApi){
            return Tasks.instrumented(Get.class, resourceApi);
        }
    }



