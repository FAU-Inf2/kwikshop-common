package de.fau.cs.mad.kwikshop.common.rest;

import de.fau.cs.mad.kwikshop.common.SynchronizationLease;
import de.fau.cs.mad.kwikshop.common.User;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("lease")
public interface LeaseResource {


    Response.Status LEASE_DENIED_STATUS_CODE = Response.Status.FORBIDDEN;

    /**
     * Requests a new synchronization
     * @param user The user requesting the lease
     * @param clientId the id identifying the client requesting the lease
     * @return Returns the synchronization lease
     */
    @PUT
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    SynchronizationLease getSynchronizationLease(@Auth User user, @HeaderParam(Constants.KWIKSHOP_CLIENT_ID) String clientId);

    /**
     * Extends the specified lease
     * @param user The user requesting the extended lease (has to be the same user that originally created the lease)
     * @param leaseId The id of the lease to extend
     * @param clientId the id identifying the client requesting the lease (has to be the same client that originally created the lease)
     * @return Returns the extended lease
     */
    @POST
    @UnitOfWork
    @Path("{leaseId}")
    @Produces(MediaType.APPLICATION_JSON)
    SynchronizationLease extendSynchronizationLease(@Auth User user, @PathParam("leaseId") int leaseId, @HeaderParam(Constants.KWIKSHOP_CLIENT_ID) String clientId);

    /**
     * Removes the specified lease so the locked resources can be used by other clients
     * @param user The user that requested the lease
     * @param leaseId The id of the lease to release
     * @param clientId the id identifying the client requesting the lease (has to be the same client that originally created the lease)
     */
    @DELETE
    @UnitOfWork
    @Path("{leaseId}")
    void removeSynchronizationLease(@Auth User user, @PathParam("leaseId") int leaseId, @HeaderParam(Constants.KWIKSHOP_CLIENT_ID) String clientId);

}
