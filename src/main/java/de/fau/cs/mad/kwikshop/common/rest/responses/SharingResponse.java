package de.fau.cs.mad.kwikshop.common.rest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SharingResponse {

    private String shoppingListName;

    @JsonProperty
    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }
}
