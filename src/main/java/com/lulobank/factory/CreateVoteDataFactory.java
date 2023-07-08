package com.lulobank.factory;

import com.github.javafaker.Faker;
import com.lulobank.models.CreateVoteRequest;
import static com.lulobank.models.CreateVoteRequestBuilder.aVote;

public class CreateVoteDataFactory {

    private static final Faker FAKER = new Faker();

    public static final String ID_VOTE = "1071899";
    //public static final String ID_VOTE = String.valueOf(FAKER.random().nextInt(1,7));

    public static final String  IMAGE_ID = "9ccXTANkb";

    public static final String  SUB_ID = "my-user-1234";

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

