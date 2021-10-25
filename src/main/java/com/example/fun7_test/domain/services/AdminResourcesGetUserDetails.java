package com.example.fun7_test.domain.services;

import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.infrastructure.UserRepository;
import com.google.gson.Gson;
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
    public String admin() throws Exception
    {
        try
        {
            // Create user's repository
            UserRepository userRepository = new UserRepository();
            User user = userRepository.Get(userId);

            JSONObject userServices = new JSONObject();
            userServices.put("user : " + user.Name + " ", new Gson().toJson(user));
            return userServices.toString();
        }
        catch (Exception error)
        {
            throw new Exception("Error occurred during get user details operation. Error message " + error.getMessage());
        }
    }
}
