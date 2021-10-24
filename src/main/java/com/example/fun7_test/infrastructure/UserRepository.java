package com.example.fun7_test.infrastructure;

import com.example.fun7_test.domain.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserRepository
{

    private final static String user = "root";
    private final static String password = "aA2221xT";
    private EntityManager _entityManager = new EntityManager();

    public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User" , user, password);
        return connection;
    }

    public static void closeConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        getConnection().close();
    }

    public boolean AddUser(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        try
        {
            _entityManager.GetTransaction().begin();
            ((javax.persistence.EntityManager) _entityManager).persist(user);
            _entityManager.GetTransaction().commit();
        }
        catch (Exception e)
        {
            _entityManager.GetTransaction().rollback();
            return false;
        }
        finally
        {
            _entityManager.GetTransaction().notify();
            closeConnection();
            _entityManager.GetEntityFactory().close();
        }
        return true;
    }
}
