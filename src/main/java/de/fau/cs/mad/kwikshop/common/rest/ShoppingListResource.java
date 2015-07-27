package de.fau.cs.mad.kwikshop.common.rest;


import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import de.fau.cs.mad.kwikshop.common.Item;
import de.fau.cs.mad.kwikshop.common.ShoppingListServer;
import de.fau.cs.mad.kwikshop.common.User;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("shoppinglist")
@Api(value = "shoppinglist", description = "Storage and retrieval of shopping lists")
public interface ShoppingListResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    List<ShoppingListServer> getList(@Auth User user);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{listId}")
    @UnitOfWork
    ShoppingListServer getList(@Auth User user, @PathParam("listId") String listId);

    @PUT
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ShoppingListServer createList(@Auth User user, ShoppingListServer list);

    @POST
    @UnitOfWork
    @Path("{listId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ShoppingListServer updateList(@Auth User user, @PathParam("listId") int listId, ShoppingListServer list, @QueryParam("updateItems") boolean updateItems);

    @DELETE
    @UnitOfWork
    @Path("{listId}")
    void deleteList(@Auth User user, @PathParam("listId") int listId);

    @GET
    @UnitOfWork
    @Path("{listId}/{itemId}")
    Item getListItem(@Auth User user, @PathParam("listId") int listId, @PathParam("itemId") int itemId);


    @PUT
    @UnitOfWork
    @Path("{listId}/newItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new Item",
            notes = "Inserts a new Item into the database. Returns the new Item object including id.",
            response = Item.class)
    Item createItem(@Auth User user,
                    @PathParam("listId") int listId,
                    @ApiParam(value = "Item to create", required = true)Item newItem);

    @POST
    @UnitOfWork
    @Path("{listId}/{itemId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing item",
            notes = "Updates the details of an existing item. Returns the updated Item object.",
            response = Item.class)
    Item updateItem(
            @Auth User user,
            @ApiParam(value ="id of the list the item belongs to", required = true) @PathParam("listId") int listId,
            @ApiParam(value = "id of the Item to update", required = true) @PathParam("itemId") int itemId,
            @ApiParam(value = "new details of the specified item", required = true) Item item);

    @DELETE
    @UnitOfWork
    @Path("{listId}/{itemId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Delete an Item",
            notes = "Removes a Item from the database.",
            response = Item.class)
    void deleteListItem(
            @Auth User user,
            @ApiParam(value ="id of the list the item belongs to", required = true) @PathParam("listId") int listId,
            @ApiParam(value = "id of the Item to update", required = true) @PathParam("itemId") int itemId);

}