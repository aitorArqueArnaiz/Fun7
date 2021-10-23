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
    public String check(@PathParam("userId")String userId, @PathParam("timezone")String timezone, @PathParam("cc")String cc) throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("multiplayer", this.CheckMultiplyer(userId));
        jo.put("user-support", this.CheckUserSupport(userId));
        jo.put("ads", this.CheckADS(userId));
        return jo.toString();
    }

    private boolean CheckMultiplyer(String userId) throws Exception {

        if(userId.isEmpty())
        {
            return false;
        }
        try
        {

        }
        catch (Exception error)
        {
            throw new Exception("Error during check the multiplayer feature. Error message : " +  error.getMessage());
        }
        return false;
    }

    private boolean CheckUserSupport(String userId) throws Exception {

        if(userId.isEmpty())
        {
            return false;
        }
        try
        {

        }
        catch (Exception error)
        {
            throw new Exception("Error during check the support feature. Error message : " +  error.getMessage());
        }
        return false;
    }

    private boolean CheckADS(String userId) throws Exception {

        if(userId.isEmpty())
        {
            return false;
        }
        try
        {

        }
        catch (Exception error)
        {
            throw new Exception("Error during check the ads feature. Error message : " +  error.getMessage());
        }

        return false;
    }
}