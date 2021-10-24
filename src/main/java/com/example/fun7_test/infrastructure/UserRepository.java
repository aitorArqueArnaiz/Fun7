package com.example.fun7_test.infrastructure;

import com.example.fun7_test.domain.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> List() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        ArrayList result = new ArrayList(){};
        try
        {
            String listUsersQuery = this.ListAllUsersQueryString();
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(listUsersQuery);

            while (rs.next())
            {
                User user = new User();
                user.Name = rs.getString("Name");
                user.multiplayer = rs.getBoolean("multiplayer");
                user.support = rs.getBoolean("support");
                user.asd = rs.getBoolean ("asd");
                user.timezone = rs.getString("timezone");
                user.cc = rs.getString("cc");
                user.setSavings(rs.getDouble("savings"));

                result.add(user);
            }
        }
        catch (Exception e)
        {
            _entityManager.GetTransaction().rollback();
        }
        finally
        {
            closeConnection();
        }
        return result;
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
