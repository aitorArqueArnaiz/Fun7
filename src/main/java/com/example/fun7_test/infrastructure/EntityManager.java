package com.example.fun7_test.infrastructure;

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
        this.transaction = ((javax.persistence.EntityManager) entityManager).getTransaction();
    }

    public EntityManager GetEntity()
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
    
    public EntityTransaction GetTransaction()
    {
        return this.transaction;
    }
    public EntityManagerFactory GetEntityFactory()
    {
        return this.entityManagerFactory;
    }
    
}
