package de.fau.cs.mad.kwikshop.common;


import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("shoppinglist")
@Api(value = "shoppinglist", description = "Storage and retrieval of shopping lists")
@Produces(MediaType.APPLICATION_JSON)
public interface ShoppingListResource {


    @GET
    List<ShoppingList> getShoppingList();

    @GET
    @Path("{id}")
    ShoppingList getShoppingList(@PathParam("id") int id);

}
