package com.example.fun7_test.domain.shared;

public class utils
{
    public boolean CheckMultiplyer(String userId) throws Exception
    {

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

    public boolean CheckUserSupport(String userId) throws Exception
    {

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

    public boolean CheckADS(String userId) throws Exception
    {

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
