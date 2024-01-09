package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase{

    private static String url = "jdbc:h2:tcp://localhost/~/TP6_reflexion";;
    private static String user = "user";
    private static String passwd = "1234";
    private static Connection connect;

    public static Connection getInstance() {
        try {
            if (connect == null || connect.isClosed()) {
                    connect = DriverManager.getConnection(url, user, passwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }
}