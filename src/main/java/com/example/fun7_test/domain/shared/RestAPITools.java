package com.example.fun7_test.domain.shared;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestAPITools
{
    public RestAPITools() {}

    public boolean SendRequest(String cc)
    {
        try
        {
            String url = "https://us-central1-o7tools.cloudfunctions.net/fun7-ad-partner";
            RestTemplate restTemplate = new RestTemplate();

            // set the headers
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth("fun7user", "fun7user");

            HttpEntity entity = new HttpEntity(headers);

            // send the GET request
            HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, cc);
        }
        catch (Exception e)
        {
        }
        return true;
    }
}
