package com.lulobank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class VoteID {

    private int id;

    public int getID() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}

