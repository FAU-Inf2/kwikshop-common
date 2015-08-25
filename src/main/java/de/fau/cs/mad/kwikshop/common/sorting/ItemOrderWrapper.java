package de.fau.cs.mad.kwikshop.common.sorting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemOrderWrapper {

    private List<BoughtItem> boughtItemList;
    private String supermarketPlaceId;
    private String supermarketName;

    public ItemOrderWrapper() {

    }

    public ItemOrderWrapper(List<BoughtItem> boughtItemList, String supermarketPlaceId, String supermarketName) {
        this.boughtItemList = boughtItemList;
        this.supermarketPlaceId = supermarketPlaceId;
        this.supermarketName = supermarketName;
    }

    @JsonProperty
    public List<BoughtItem> getBoughtItemList() {
        return boughtItemList;
    }

    public void setBoughtItemList(List<BoughtItem> boughtItemList) {
        this.boughtItemList = boughtItemList;
    }

    @JsonProperty
    public String getSupermarketPlaceId() {
        return supermarketPlaceId;
    }

    public void setSupermarketPlaceId(String supermarketPlaceId) {
        this.supermarketPlaceId = supermarketPlaceId;
    }

    @JsonProperty
    public String getSupermarketName() {
        return supermarketName;
    }

    public void setSupermarketName(String supermarketName) {
        this.supermarketName = supermarketName;
    }
}
