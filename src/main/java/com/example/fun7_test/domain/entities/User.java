package com.example.fun7_test.domain.entities;

public class User
{
    public User()
    {
        this.UserId = 0;
        this.multiplayer = false;
        this.support = false;
        this.asd = false;
        this.timezone = "";
        this.cc = "";
    }

    public int UserId;
    public boolean multiplayer;
    public boolean support;
    public boolean asd;
    public String timezone;
    public String cc;
}
