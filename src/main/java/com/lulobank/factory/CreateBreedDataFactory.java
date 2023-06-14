package com.lulobank.factory;

import com.github.javafaker.Faker;
import com.lulobank.models.CreateBreedRequest;
import org.apache.commons.lang3.StringUtils;

import static com.lulobank.models.CreateBreedRequestBuilder.aBreed;

public class CreateBreedDataFactory {

    private static final Faker FAKER = new Faker();

    public static final String ID_BREED = String.valueOf(FAKER.random().nextInt(1,50));

    public static final String NAME_BREED = String.valueOf(FAKER.name().fullName());

}
