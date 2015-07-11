package de.fau.cs.mad.kwikshop.common.rest;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import de.fau.cs.mad.kwikshop.common.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
public interface ListResource<TList> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<TList> getList();

    @GET
    @Path("{listId}")
    TList getList(@PathParam("listId") int id);

    @GET
    @Path("{listId}/{itemId}")
    List<Item> getListItem(@PathParam("listId") int listId, @PathParam("itemId") int itemId);


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new Item",
            notes = "Inserts a new Item into the database. Returns the new Item object including id.",
            response = Item.class)
    Item createItem(@ApiParam(value = "Item to create", required = true)Item newItem);

    @PUT
    @Path("{listId}/{itemId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing item",
            notes = "Updates the details of an existing item. Returns the updated Item object.",
            response = Item.class)
    Item updateItem(
            @ApiParam(value ="id of the list the item belongs to", required = true) @PathParam("listId") long listId,
            @ApiParam(value = "id of the Item to update", required = true) @PathParam("itemId") long itemId,
            @ApiParam(value = "new details of the specified item", required = true) Item item);

    @DELETE
    @Path("{listId}/{itemId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Delete an Item",
            notes = "Removes a Item from the database.",
            response = Item.class)
    void deleteUser(
            @ApiParam(value ="id of the list the item belongs to", required = true) @PathParam("listId") long listId,
            @ApiParam(value = "id of the Item to update", required = true) @PathParam("itemId") long itemId);

}
