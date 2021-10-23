package com.example.fun7_test.domain;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/check-services/{userId}/{timezone}/{cc}")
public class UsersResource {
    @GET
    @Produces("application/json")
    public String check(@PathParam("userId")String userId, @PathParam("timezone")String timezone, @PathParam("cc")String cc)
    {
        JSONObject jo = new JSONObject();
        jo.put("multiplayer", this.CheckMultiplyer(userId));
        jo.put("user-support", this.CheckUserSupport(userId));
        jo.put("ads", this.CheckADS(userId));
        return jo.toString();
    }

    private boolean CheckMultiplyer(String userId)
    {
        return false;
    }

    private boolean CheckUserSupport(String userId)
    {
        return false;
    }

    private boolean CheckADS(String userId)
    {
        return false;
    }
}