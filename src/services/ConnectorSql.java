package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConnectorSql {
    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restauranteumc","postgres","vertigo");

        } catch (Exception e) {

            System.out.println(e);

        }

        return con;

    }
}