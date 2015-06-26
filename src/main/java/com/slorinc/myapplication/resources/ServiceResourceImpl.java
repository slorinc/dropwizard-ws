package com.slorinc.myapplication.resources;

import com.slorinc.myapplication.dao.UserDAO;
import com.slorinc.myapplication.exceptions.UserNotFoundException;
import com.slorinc.myapplication.resources.interfaces.ServiceResource;
import com.slorinc.myapplication.resources.views.AccessInfoVO;
import com.slorinc.myapplication.resources.views.ErrorVO;
import com.slorinc.myapplication.resources.views.VisitorVO;
import io.dropwizard.jersey.params.LongParam;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * ServiceResource
 */
@Path("/{user}")
public class ServiceResourceImpl implements ServiceResource {

    private final UserDAO userDAO;

    final static Logger LOG = LoggerFactory.getLogger(ServiceResourceImpl.class);

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response accessListByUserID(@DefaultValue("1") @PathParam("user") LongParam userId) {
        try {
            checkIfUserExists(userId);
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorVO(404, String.format("User does not exists. (ID: %d)", userId.get()))).build();
        }
        List<AccessInfoVO> entity = userDAO.accessListByUserID(userId.get());
        LOG.info(String.format("Access list successfully retrieved for userId %d with %d elements.", userId.get(), entity.size()));
        return Response.ok(entity).build();
    }


    /**
     * Endpoint to store the views of user profiles
     *
     * @param userId  visited user's userId
     * @param visitor visitor's userId
     * @return returns with response status 200
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response logAccess(@DefaultValue("1") @PathParam("user") LongParam userId, @Valid VisitorVO visitor) {
        try {
            checkIfUserExists(userId);
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorVO(404, String.format("User does not exists. (ID: %d)", userId.get()))).build();
        }
        try {
            userDAO.logAccess(userId.get(), visitor.getId(), new DateTime(DateTimeZone.UTC));
        } catch (Throwable e) {
            LOG.error(String.format("Access violation! Visitor does not exits (ID: %d)", visitor.getId()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorVO(500, String.format("Visitor does not exits (ID: %d)", visitor.getId()))).build();
        }

        LOG.info(String.format("Visitor for userId %d logged with ID %d.", userId.get(), visitor.getId()));
        return Response.status(Response.Status.OK).entity(String.format("Visitor for userId %d logged with ID %d.", userId.get(), visitor.getId())).build();
    }

    private void checkIfUserExists(LongParam userId) throws UserNotFoundException {
        if (!userDAO.checkUser(userId.get())) {
            LOG.warn(String.format("Trying to access a non-existing userId (ID: %d)", userId.get()));
            throw new UserNotFoundException();
        }
    }
}
