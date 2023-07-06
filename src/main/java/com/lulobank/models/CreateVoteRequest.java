package com.lulobank.models;
public class CreateVoteRequest {

    private String image_id;
    private String sub_id;
    private String value;

    public String getImage_id() {
        return image_id;
    }
    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
