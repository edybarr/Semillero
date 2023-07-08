package com.lulobank.questions;

import com.lulobank.models.VoteID;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class Response {

    public static Question<Integer> getStatusCode() {
        return Question.about("Status code").answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }

    public static Question<String> getMessageVote() {
        return Question.about("Get message").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("message").toString());
    }

    public static Question<List<VoteID>> getVotes() {
        return Question.about("Get votes").answeredBy(actor -> SerenityRest.lastResponse().body().jsonPath().getList("", VoteID.class));
    }

    public static Question<String> getNameBred() {
        return Question.about("Get name breed").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("data.breed_name").toString());
    }

    public static Question<String> getMessage() {
        return Question.about("Get message").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("origin").toString());
    }

    public static Question<String> getNameCategories() {
        return Question.about("Get IDcategories").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).getList("id").get(1).toString());

    }

    public static Question<Integer> deleteStatusCode() {
        return Question.about("Status code").answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }
    //public static Question<String> deleteMessage(){
    //return Question.about("Delete message"). answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).deleteList("id").toString());
    //}

}
