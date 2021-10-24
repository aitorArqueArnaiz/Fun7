package com.example.fun7_test.domain.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManager
{
    public EntityManager()
    {
        // user is the persistence unit configured in persistence.xml
        this.entityManagerFactory = Persistence.createEntityManagerFactory("User");
        this.entityManager = (EntityManager) entityManagerFactory.createEntityManager();
        this.transaction = entityManager.transaction;
    }

    public EntityManager GetUsersEntityManager()
    {
        return this.entityManager;
    }

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public void close()
    {
        this.entityManager.close();
    }
}
