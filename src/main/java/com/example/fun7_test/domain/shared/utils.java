package com.example.fun7_test.domain.shared;

import com.example.fun7_test.infrastructure.UserRepository;

public class utils
{
    public boolean CheckMultiplyer(String userId, String cc) throws Exception
    {

        boolean isMultiplayerActivated;
        if(userId.isEmpty() || cc.isEmpty() || !cc.equals("US"))
        {
            return false;
        }
        try
        {
            UserRepository userRepository = new UserRepository();
            isMultiplayerActivated = userRepository.Get(userId).multiplayer;
        }
        catch (Exception error)
        {
            throw new Exception("Error during check the multiplayer feature. Error message : " +  error.getMessage());
        }
        return isMultiplayerActivated;
    }

    public boolean CheckUserSupport(String timezone) throws Exception
    {
        if(timezone.isEmpty())
        {
            return false;
        }
        try
        {
            if(timezone.equals("9:00 - 15:00 Ljubljana time"))
            {
                return true;
            }

            // Update user support field into data base
        }
        catch (Exception error)
        {
            throw new Exception("Error during check the support feature. Error message : " +  error.getMessage());
        }
        return false;
    }

    public boolean CheckADS(String cc) throws Exception
    {

        boolean isADSActivated = false;
        RestAPITools restApiClient = new RestAPITools();
        if(cc.isEmpty())
        {
            return false;
        }
        try
        {
            isADSActivated = restApiClient.SendRequest(cc);
        }
        catch (Exception error)
        {
            throw new Exception("Error during check the ads feature. Error message : " +  error.getMessage());
        }

        return isADSActivated;
    }
}
