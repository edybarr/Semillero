package com.lulobank.factory;

import com.lulobank.models.CreateVoteRequest;

import static com.lulobank.models.CreateVoteRequestBuilder.aVote;

public class CreateVoteDataFactory {

    public static final String IMAGE_ID = "9ccXTANkb";

    public static final String SUB_ID = "my-user-1234";

    public static final String VALUE = "1";

    //Este es un tipo de voto valido
    public static CreateVoteRequest validVote() {
        //Se crea un objeto con diferentes formas, en este caso es un objeto con info vacía
        return aVote()
                .withImage_id(IMAGE_ID)
                .withSub_id(SUB_ID)
                .withValue(VALUE)
                .build();
    }
}

