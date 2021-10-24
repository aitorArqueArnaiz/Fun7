package com.example.fun7_test.domain.services;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/admin-services/all-users")
public class AdminResourceGetUsers
{
    @GET
    @Produces("application/json")
    public String admin()
    {
        JSONObject userServices = new JSONObject();
        return userServices.toString();
    }
}

