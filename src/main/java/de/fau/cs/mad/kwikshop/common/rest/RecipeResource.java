package de.fau.cs.mad.kwikshop.common.rest;


import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import de.fau.cs.mad.kwikshop.common.Item;
import de.fau.cs.mad.kwikshop.common.RecipeServer;
import de.fau.cs.mad.kwikshop.common.User;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
    NOTE:
    If adding/editing a method that takes a path parameter, make sure the @PathParam annotation
     comes before the @ApiParam annotation, otherwise Jaxrs2retrofit will create an unusable client interface
     (this affects the android client that shares sources with the sever)
 */
@Path("recipe")
@Api(value = "recipe", description = "Storage and retrieval of recipes")
public interface RecipeResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    List<RecipeServer> getList(@Auth User user);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{listId}")
    @UnitOfWork
    RecipeServer getList(@Auth User user, @PathParam("listId") int listId);

    @PUT
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    RecipeServer createList(@Auth User user, RecipeServer list);

    @POST
    @UnitOfWork
    @Path("{listId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    RecipeServer updateList(@Auth User user, @PathParam("listId") int listId, RecipeServer list, @QueryParam("updateItems") boolean updateItems);

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
            @PathParam("listId") @ApiParam(value ="id of the list the item belongs to", required = true) int listId,
            @PathParam("itemId") @ApiParam(value = "id of the Item to update", required = true)  int itemId,
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
            @PathParam("listId") @ApiParam(value ="id of the list the item belongs to", required = true)  int listId,
            @PathParam("itemId") @ApiParam(value = "id of the Item to update", required = true) int itemId);
}
