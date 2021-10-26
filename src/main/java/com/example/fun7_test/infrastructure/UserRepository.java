package com.example.fun7_test.infrastructure;

import com.example.fun7_test.domain.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false" , user, password);
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
                GetUserInformation(user, rs);

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

    public User Get(String userId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        User result = new User();
        try
        {
            String listUsersQuery = this.GetUserByIdQueryString(userId);
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(listUsersQuery);

            while (rs.next())
            {
                GetUserInformation(result, rs);
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

    public boolean Delete(String userId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        try
        {
            String listUsersQuery = this.DeleteUserQueryString(userId);
            Statement stmt = getConnection().createStatement();
            stmt.execute(listUsersQuery);
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
        return true;
    }

    private void GetUserInformation(User result, ResultSet rs) throws SQLException
    {
        result.Name = rs.getString("Name");
        result.multiplayer = rs.getBoolean("multiplayer");
        result.support = rs.getBoolean("support");
        result.asd = rs.getBoolean ("asd");
        result.timezone = TimeZone.getTimeZone(rs.getString("timezone"));
        result.cc = rs.getString("cc");
        result.setSavings(rs.getDouble("savings"));
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

    private String GetUserByIdQueryString(String userId)
    {
        return "SELECT * FROM users.users u WHERE u.id = " + userId;
    }

    private String DeleteUserQueryString(String userId)
    {
        return "DELETE FROM users.users u WHERE u.id = " + userId;
    }
}
