package com.example.fun7_test.domain.services;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/admin-services/{userId}/{timezone}/{cc}")
public class AdminResource
{
    @GET
    @Produces("application/json")
    public String admin(@PathParam("userId") String userId, @PathParam("timezone") String timezone, @PathParam("cc") String cc) throws Exception {
        JSONObject userServices = new JSONObject();
        return userServices.toString();
    }
}

