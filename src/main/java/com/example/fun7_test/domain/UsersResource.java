package com.example.fun7_test.domain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/check-services/{userId}")
public class UsersResource {
    @PathParam("userId")
    private String userId;

    @GET
    @Produces("application/json")
    public String services()
    {
        return "OK";
    }
}