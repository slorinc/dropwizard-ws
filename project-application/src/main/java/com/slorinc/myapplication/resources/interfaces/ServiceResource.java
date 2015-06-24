package com.slorinc.myapplication.resources.interfaces;

import com.slorinc.myapplication.resources.views.VisitorVO;
import io.dropwizard.jersey.params.LongParam;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * ServiceResource
 *
 */
public interface ServiceResource {
    @GET
    @Path("/list")
    Response accessListByUserID(@DefaultValue("1") @PathParam("user") LongParam userId);

    @POST
    Response logAccess(@DefaultValue("1") @PathParam("user") LongParam userId,
                       @Valid VisitorVO visitor);
}
