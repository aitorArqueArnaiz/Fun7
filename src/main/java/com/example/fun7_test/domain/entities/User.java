package com.example.fun7_test.domain.entities;

public class User
{
    public User()
    {
        this.UserId = 0;
        this.Name = "";
        this.multiplayer = false;
        this.support = false;
        this.asd = false;
        this.timezone = "";
        this.cc = "";
        this.savings = 0.0;
    }

    public int getId()
    {
        return UserId;
    }

    public void setId(int id)
    {
        this.UserId = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public double getSavings()
    {
        return savings;
    }

    public void setSavings(double savings)
    {
        this.savings = savings;
    }

    public int UserId;
    public String Name;
    public boolean multiplayer;
    public boolean support;
    public boolean asd;
    public String timezone;
    public String cc;
    private double savings;
}
