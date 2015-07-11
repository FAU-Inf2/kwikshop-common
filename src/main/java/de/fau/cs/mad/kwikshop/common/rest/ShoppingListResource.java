package de.fau.cs.mad.kwikshop.common.rest;


import com.wordnik.swagger.annotations.Api;
import de.fau.cs.mad.kwikshop.common.ShoppingList;

import javax.ws.rs.Path;



@Path("shoppinglist")
@Api(value = "shoppinglist", description = "Storage and retrieval of shopping lists")
public interface ShoppingListResource extends ListResource<ShoppingList> {





}
