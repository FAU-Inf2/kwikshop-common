package de.fau.cs.mad.kwikshop.common.sorting;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortingRequest {
    private String placeId;
    private String supermarketName;

    public SortingRequest() {

    }

    public SortingRequest(String placeId, String supermarketName) {
        this.placeId = placeId;
        this.supermarketName = supermarketName;
    }

    @JsonProperty
    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @JsonProperty
    public String getSupermarketName() {
        return supermarketName;
    }

    public void setSupermarketName(String supermarketName) {
        this.supermarketName = supermarketName;
    }
}
