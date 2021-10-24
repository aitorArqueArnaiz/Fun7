package com.example.fun7_test.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User
{
    public User()
    {
        this.Name = "";
        this.multiplayer = false;
        this.support = false;
        this.asd = false;
        this.timezone = "";
        this.cc = "";
        this.savings = 0.0;
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

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false)
    public String Name;

    @Column(name = "multiplayer", nullable = false)
    public boolean multiplayer;

    @Column(name = "support", nullable = false)
    public boolean support;

    @Column(name = "asd", nullable = false)
    public boolean asd;

    @Column(name = "timezone", nullable = false)
    public String timezone;

    @Column(name = "cc", nullable = false)
    public String cc;

    @Column(name = "savings", nullable = false)
    private double savings;

}
