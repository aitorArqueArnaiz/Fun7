package com.example.fun7_test.domain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/health-check")
public class HealthResource {
    @GET
    @Produces("text/plain")
    public String health() {
        return "OK";
    }
}