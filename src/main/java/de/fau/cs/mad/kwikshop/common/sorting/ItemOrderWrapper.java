package de.fau.cs.mad.kwikshop.common.sorting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemOrderWrapper {

    private List<BoughtItem> boughtItemList;

    public ItemOrderWrapper() {

    }

    public ItemOrderWrapper(List<BoughtItem> boughtItemList) {
        this.boughtItemList = boughtItemList;
    }

    @JsonProperty
    public List<BoughtItem> getBoughtItemList() {
        return boughtItemList;
    }

    public void setBoughtItemList(List<BoughtItem> boughtItemList) {
        this.boughtItemList = boughtItemList;
    }

}
