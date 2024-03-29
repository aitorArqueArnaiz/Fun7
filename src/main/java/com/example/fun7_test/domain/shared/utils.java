package com.example.fun7_test.domain.shared;

import com.example.fun7_test.infrastructure.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public boolean CheckUserSupport(TimeZone timezone) throws Exception
    {
        if(timezone == null)
        {
            return false;
        }
        try
        {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone(timezone.getID()));
            Date date = df.getCalendar().getTime();
            String[] hour = date.toString().split(" ");
            if(timezone.getID().equals("Europe/Ljubljana") && (hour[3].contains("9") ||
                    hour[3].contains("10") || hour[3].contains("11")))
            {
                return true;
            }
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
