package com.example.fun7_test.domain.entities;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User
{
    public User()
    {
        this.Name = "test";
        this.multiplayer = false;
        this.support = false;
        this.asd = false;
        this.timezone = "pacific";
        this.cc = "EN";
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
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
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
