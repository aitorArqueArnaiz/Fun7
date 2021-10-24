package com.example.fun7_test.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserRepository
{

    private final static String user = "root";
    private final static String password = "";

    public static Connection getConexion() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homebanking" , user, password);
        return connection;
    }

    public static void closeConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        getConexion().close();
    }
}
