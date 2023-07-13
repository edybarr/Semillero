package com.lulobank.models;

public class CreateVoteRequestBuilder {

    private final CreateVoteRequest voteRequest;

    private CreateVoteRequestBuilder() {
        voteRequest = new CreateVoteRequest();
    }

    public static CreateVoteRequestBuilder aVote() {
        return new CreateVoteRequestBuilder();
    }

    public CreateVoteRequestBuilder withImage_id(String image_id) {
        this.voteRequest.setImage_id(image_id);
        return this;
    }

    public CreateVoteRequestBuilder withSub_id(String sub_id) {
        this.voteRequest.setSub_id(sub_id);
        return this;
    }

    public CreateVoteRequestBuilder withValue(String value) {
        this.voteRequest.setValue(value);
        return this;
    }

    public CreateVoteRequest build() {
        return voteRequest;
    }
}

