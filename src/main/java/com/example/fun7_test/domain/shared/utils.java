package com.example.fun7_test.domain.shared;

import com.example.fun7_test.infrastructure.UserRepository;

public class utils
{
    public boolean CheckMultiplyer(String userId) throws Exception
    {

        boolean isMultiplayerActivated;
        if(userId.isEmpty())
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

    public boolean CheckUserSupport(String userId) throws Exception
    {

        boolean isSupportActivated;
        if(userId.isEmpty())
        {
            return false;
        }
        try
        {
            UserRepository userRepository = new UserRepository();
            isSupportActivated = userRepository.Get(userId).support;
        }
        catch (Exception error)
        {
            throw new Exception("Error during check the support feature. Error message : " +  error.getMessage());
        }
        return isSupportActivated;
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
