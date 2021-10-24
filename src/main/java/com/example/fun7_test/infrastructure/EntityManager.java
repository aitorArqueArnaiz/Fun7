package com.example.fun7_test.infrastructure;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManager
{
    public EntityManager(String persistenceUnitName) throws Exception {
        // user is the persistence unit configured in persistence.xml
        try
        {
            this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            this.entityManager = (EntityManager) entityManagerFactory.createEntityManager();
            this.transaction = ((javax.persistence.EntityManager) entityManager).getTransaction();
        }
        catch (Exception error)
        {
            throw new Exception();
        }
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
