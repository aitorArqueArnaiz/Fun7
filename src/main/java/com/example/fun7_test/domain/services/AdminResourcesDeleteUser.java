package com.example.fun7_test.domain.services;

import org.json.simple.JSONObject;

import javax.ws.rs.*;


@Path("/admin-services/delete-user/{userId}")
public class AdminResourcesDeleteUser
{
    @PathParam("userId")
    private String userId;

    @DELETE
    @Produces("application/json")
    public String admin()
    {
        JSONObject userServices = new JSONObject();
        return userServices.toString();
    }
}
