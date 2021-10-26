package com.example.fun7_test.domain.shared;


import org.apache.http.HttpException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class RestAPITools
{
    public RestAPITools() {}

    public boolean SendRequest(String cc)
    {
        boolean adsResult = false;
        try
        {
            // request url
            String url = "https://us-central1-o7tools.cloudfunctions.net/fun7-ad-partner?countryCode=" + cc;

            // create auth credentials
            String authStr = "fun7user:fun7pass";
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);

            // create request
            HttpEntity request = new HttpEntity(headers);

            // make a request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

            // Check response status code
            if(response.getStatusCode() == HttpStatus.BAD_REQUEST)
            {
                throw new HttpException("Remote server returned a bad request");
            }
            else if (response.getStatusCode() == HttpStatus.UNAUTHORIZED)
            {
                throw new HttpException("Remote server returned an unauthorized");
            }
            else if(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
            {
                throw new HttpException("Remote server returned an internal server error");
            }

            // get JSON response
            String json = response.getBody();
            if(json.equals("{\"ads\": \"you shall not pass!\"}"))
            {
                adsResult = false;
            }
            else if(json.equals("{\"ads\": \"sure, why not!\"}"))
            {
                adsResult = true;
            }

        }
        catch (Exception e)
        {
        }
        return adsResult;
    }
}
