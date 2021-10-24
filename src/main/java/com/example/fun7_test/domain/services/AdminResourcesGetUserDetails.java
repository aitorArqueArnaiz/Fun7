package com.example.fun7_test.domain.services;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/admin-services/user-details/{userId}")
public class AdminResourcesGetUserDetails
{
    @PathParam("userId")
    private String userId;

    @GET
    @Produces("application/json")
    public String admin()
    {
        JSONObject userServices = new JSONObject();
        return userServices.toString();
    }
}
