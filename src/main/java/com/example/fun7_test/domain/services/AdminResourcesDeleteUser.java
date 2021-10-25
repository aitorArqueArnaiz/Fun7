package com.example.fun7_test.domain.services;

import com.example.fun7_test.infrastructure.UserRepository;
import org.json.simple.JSONObject;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/admin-services/delete-user/{userId}")
public class AdminResourcesDeleteUser
{
    @PathParam("userId")
    private String userId;

    @DELETE
    @Produces("application/json")
    public String admin() throws Exception
    {
        try
        {
            // Create user's repository
            UserRepository userRepository = new UserRepository();
            boolean result = userRepository.Delete(userId);

            JSONObject userServices = new JSONObject();
            userServices.put("deleted", result);
            return userServices.toString();
        }
        catch (Exception error)
        {
            throw new Exception("Error occurred during delete user operation. Error message " + error.getMessage());
        }
    }
}
