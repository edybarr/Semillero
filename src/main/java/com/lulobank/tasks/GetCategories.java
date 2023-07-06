package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetCategories implements Task {

    private final String resourceApi;

    public GetCategories(String resourceApi) {
        this.resourceApi = resourceApi;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resourceApi)
                        .with(request -> request
                        )
        );
    }
    public static GetCategories with(String resourceApi) {
        return new GetCategories(resourceApi);
    }
}
