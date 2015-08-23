package de.fau.cs.mad.kwikshop.common.conversion;

import javax.inject.Inject;

import de.fau.cs.mad.kwikshop.common.ShoppingList;
import de.fau.cs.mad.kwikshop.common.ShoppingListServer;

public class ShoppingListConverter implements ObjectConverter<ShoppingList, ShoppingListServer> {


    @Inject
    public ShoppingListConverter() {

    }

    @Override
    public ShoppingListServer convert(ShoppingList clientShoppingList) {

        ShoppingListServer serverShoppingList = new ShoppingListServer(
                clientShoppingList.getServerId(),
                clientShoppingList.getItems());

        serverShoppingList.setName(clientShoppingList.getName());
        serverShoppingList.setSortTypeInt(clientShoppingList.getSortTypeInt());
        serverShoppingList.setLocation(clientShoppingList.getLocation());
        serverShoppingList.setLastModifiedDate(clientShoppingList.getLastModifiedDate());
        serverShoppingList.setPredefinedId(clientShoppingList.getPredefinedId());

        return serverShoppingList;
    }


}
