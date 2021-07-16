package dao;

import java.sql.*;

public class DBUtils {
    private String connectionString = "jdbc:sqlite:/Users/dimplemonkey/contact_manager";
    private Statement statement;
    private Connection connection;

    public ResultSet executeQuery(String query) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:/Users/dimplemonkey/contact_manager");
            this.statement = this.connection.createStatement();
            return this.statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public void closeConnection() throws SQLException {
        this.statement.close();
        this.connection.close();
        this.statement = null;
        this.connection = null;
    }
}
