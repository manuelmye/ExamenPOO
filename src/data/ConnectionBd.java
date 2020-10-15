package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBd {
    public static Connection connectSQLite() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:itemsDB.db?foreign_keys=on;";
            conn = DriverManager.getConnection(url);
            System.out.println("Are you connected\n");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error the connection" + e);
        }
        return conn;
    }
}
