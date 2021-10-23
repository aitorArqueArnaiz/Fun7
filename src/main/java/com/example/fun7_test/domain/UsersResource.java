package com.example.fun7_test.domain;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/check-services/{userId}/{timezone}/{cc}")
public class UsersResource {
    @PathParam("userId")
    private String userId;
    @PathParam("timezone")
    private String timezone;
    @PathParam("cc")
    private String cc;

    @GET
    @Produces("application/json")
    public JSONObject services()
    {
        JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");
        return jo;
    }
}