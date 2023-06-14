package com.lulobank.models;

public class CreateBreedRequestBuilder {

    private CreateBreedRequest breedRequest;

    private CreateBreedRequestBuilder(){
        breedRequest = new CreateBreedRequest();
    }

    public static CreateBreedRequestBuilder aBreed() { return new CreateBreedRequestBuilder();}

    public CreateBreedRequestBuilder withName(String name){
        this.breedRequest.setName(name);
        return this;
    }

    public CreateBreedRequestBuilder with
        this.breedRequest.setName();
    return this;
}
