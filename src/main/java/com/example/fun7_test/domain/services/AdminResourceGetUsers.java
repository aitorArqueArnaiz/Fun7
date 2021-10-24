package com.example.fun7_test.domain.services;

import com.example.fun7_test.domain.entities.User;
import com.example.fun7_test.domain.shared.utils;
import com.example.fun7_test.infrastructure.UserRepository;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@Path("/admin-services/all-users")
public class AdminResourceGetUsers
{
    private utils ut = new utils();

    @GET
    @Produces("application/json")
    public String admin() throws Exception
    {
        try
        {
            // Create user's repository
            UserRepository userRepository = new UserRepository();
            List<User> users = userRepository.List();

            JSONObject userServices = new JSONObject();
            for (User user:users)
            {
                userServices.put("user : " + user.Name + " ", user);
            }
            return userServices.toString();
        }
        catch (Exception error)
        {
            throw new Exception("Error occurred during get users operation. Error message " + error.getMessage());
        }
    }
}

