package de.fau.cs.mad.kwikshop.common.rest;


import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import de.fau.cs.mad.kwikshop.common.DeletionInfo;
import de.fau.cs.mad.kwikshop.common.Item;
import de.fau.cs.mad.kwikshop.common.ShoppingListServer;
import de.fau.cs.mad.kwikshop.common.User;
import de.fau.cs.mad.kwikshop.common.rest.annotations.RequiresClientId;
import de.fau.cs.mad.kwikshop.common.rest.annotations.RequiresLease;
import de.fau.cs.mad.kwikshop.common.rest.responses.SharingCode;
import de.fau.cs.mad.kwikshop.common.rest.responses.SharingResponse;
import de.fau.cs.mad.kwikshop.common.sorting.ItemOrderWrapper;
import de.fau.cs.mad.kwikshop.common.sorting.SortingRequest;
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
@Path("shoppinglist")
@Api(value = "shoppinglist", description = "Storage and retrieval of shopping lists")
@RequiresClientId
public interface ShoppingListResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @RequiresLease
    List<ShoppingListServer> getList(@Auth User user);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{listId}")
    @UnitOfWork
    @RequiresLease
    ShoppingListServer getList(@Auth User user, @PathParam("listId") int listId);

    @PUT
    @UnitOfWork
    @RequiresLease
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ShoppingListServer createList(@Auth User user, ShoppingListServer list);

    @POST
    @UnitOfWork
    @Path("{listId}")
    @RequiresLease
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ShoppingListServer updateList(@Auth User user, @PathParam("listId") int listId, ShoppingListServer list);

    @DELETE
    @UnitOfWork
    @Path("{listId}")
    @RequiresLease
    void deleteList(@Auth User user, @PathParam("listId") int listId);

    @GET
    @UnitOfWork
    @Path("/deleted")
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresLease
    @ApiOperation(value = "Gets the Ids of the user's shopping lists that were deleted")
    List<DeletionInfo> getDeletedLists(@Auth User user);

    @GET
    @UnitOfWork
    @Path("{listId}/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresLease
    Item getListItem(@Auth User user, @PathParam("listId") int listId, @PathParam("itemId") int itemId);

    @GET
    @UnitOfWork
    @Path("{listId}/sharingCode")
    @Produces(MediaType.APPLICATION_JSON)
    SharingCode getSharingCode(@Auth User user, @PathParam("listId") int listId);

    @POST
    @UnitOfWork
    @Path("/share/{sharingCode}")
    @Produces(MediaType.APPLICATION_JSON)
    SharingResponse share(@Auth User user, @PathParam("sharingCode") String sharingCode);

    @GET
    @UnitOfWork
    @Path("/sharedLists")
    @RequiresLease
    @Produces(MediaType.APPLICATION_JSON)
    List<ShoppingListServer> getSharedLists(@Auth User user);

    @PUT
    @UnitOfWork
    @Path("{listId}/newItem")
    @RequiresLease
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
    @RequiresLease
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing item",
            notes = "Updates the details of an existing item. Returns the updated Item object.",
            response = Item.class)
    Item updateItem(
            @Auth User user,
            @PathParam("listId") @ApiParam(value ="id of the list the item belongs to", required = true)  int listId,
            @PathParam("itemId") @ApiParam(value = "id of the Item to update", required = true) int itemId,
            @ApiParam(value = "new details of the specified item", required = true) Item item);

    @DELETE
    @UnitOfWork
    @Path("{listId}/{itemId}")
    @RequiresLease
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Delete an Item",
            notes = "Removes a Item from the database.",
            response = Item.class)
    void deleteListItem(
            @Auth User user,
            @PathParam("listId") @ApiParam(value ="id of the list the item belongs to", required = true)  int listId,
            @PathParam("itemId") @ApiParam(value = "id of the Item to update", required = true)  int itemId);


    @GET
    @UnitOfWork
    @Path("{listId}/items")
    @RequiresLease
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    List<Item> getListItems(@Auth User user, @PathParam("listId") int listId);

    @GET
    @UnitOfWork
    @Path("{listId}/items/deleted")
    @RequiresLease
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Gets the items that were deleted from the list")
    List<DeletionInfo> getDeletedListItems(@Auth User user,
                                           @PathParam("listId") @ApiParam(value = "The id of the list to get deleted items for", required = true) int listId);

    @POST
    @UnitOfWork
    @Path("/boughtItems")
    @Consumes(MediaType.APPLICATION_JSON)
    void postBoughtItems(@Auth User user, @ApiParam(value = "ItemOrder", required = true) ItemOrderWrapper itemOrder);

    @POST
    @UnitOfWork
    @Path("{listId}/sort")
    @Produces(MediaType.APPLICATION_JSON)
    void sort(@Auth User user, @PathParam("listId") int listId,
              @ApiParam(value = "SortingRequest", required = true) SortingRequest sortingRequest);

}
