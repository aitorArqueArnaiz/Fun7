package com.example.fun7_test.infrastructure;

import com.example.fun7_test.domain.entities.User;
import java.sql.*;

public class UserRepository
{

    private final static String user = "root";
    private final static String password = "aA2221xT";
    private EntityManager _entityManager;

    public UserRepository() throws Exception
    {
        //this._entityManager = new EntityManager("User");
    }

    public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users" , user, password);
        return connection;
    }

    public static void closeConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        getConnection().close();
    }

    public boolean Add(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        try
        {
            String insertUserQuery = this.CreateAddUserQueryString(user);
            Statement stmt = getConnection().createStatement();
            stmt.execute(insertUserQuery);
            return true;
        }
        catch (Exception e)
        {
            _entityManager.GetTransaction().rollback();
            return false;
        }
        finally
        {
            closeConnection();
        }
    }

    public boolean List() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        try
        {
            String listUsersQuery = this.ListAllUsersQueryString();
            Statement stmt = getConnection().createStatement();
            stmt.execute(listUsersQuery);
            return true;
        }
        catch (Exception e)
        {
            _entityManager.GetTransaction().rollback();
            return false;
        }
        finally
        {
            closeConnection();
        }
    }

    private String CreateAddUserQueryString(User user)
    {
        return "INSERT INTO users (Name, multiplayer, support, asd, timezone, cc, savings) VALUES(" + "'" + user.Name + "'"
                + ", " + user.multiplayer + ", " + user.support + ", " + user.asd + ", " + "'" + user.timezone + "'" + ", "
                + "'" + user.cc + "'" + ", " + user.getSavings() + ")";
    }

    private String ListAllUsersQueryString()
    {
        return "SELECT * FROM users.users";
    }
}
