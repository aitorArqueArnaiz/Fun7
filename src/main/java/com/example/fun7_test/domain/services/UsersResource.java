package com.example.fun7_test.domain.services;

import org.json.simple.JSONObject;
import com.example.fun7_test.domain.shared.utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.TimeZone;


@Path("/check-services/{userId}/{timezone}/{cc}")
public class UsersResource
{
    private utils ut = new utils();

    @GET
    @Produces("application/json")
    public String check(@PathParam("userId")String userId, @PathParam("timezone")String timezone, @PathParam("cc")String cc) throws Exception {
        JSONObject userServices = new JSONObject();
        userServices.put("multiplayer", ut.CheckMultiplyer(userId, cc));
        userServices.put("user-support", ut.CheckUserSupport(TimeZone.getTimeZone(timezone)));
        userServices.put("ads", ut.CheckADS(cc));
        return userServices.toString();
    }
}