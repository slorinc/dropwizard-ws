package com.slorinc.myapplication.resources;

import com.slorinc.myapplication.dao.UserDAO;
import com.slorinc.myapplication.resources.interfaces.ServiceResource;
import com.slorinc.myapplication.resources.views.VisitorVO;
import io.dropwizard.jersey.params.LongParam;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * ServiceResource
 *
 */
@Path("/{user}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceResourceImpl implements ServiceResource {

    private final UserDAO userDAO;

    public ServiceResourceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Endpoint to view the users who viewed this user’s profile in the past
     *
     * @param userId userId
     * @return JSON containing the list of visitors and timestamps
     */
    @GET
    @Path("/list")
    public Response accessListByUserID(@DefaultValue("1") @PathParam("user") LongParam userId) {
        return Response.ok(userDAO.accessListByUserID(userId.get())).build();
    }

    /**
     * Endpoint to store the views of user profiles
     *
     * @param userId visited user's userId
     * @param visitor visitor's userId
     * @return returns with response status 200
     */
    @POST
    public Response logAccess(@DefaultValue("1") @PathParam("user") LongParam userId,
                              @Valid VisitorVO visitor) {
        userDAO.logAccess(userId.get(), visitor.getId(), new DateTime(DateTimeZone.UTC));

        return Response.status(Response.Status.OK).build();
    }

}
