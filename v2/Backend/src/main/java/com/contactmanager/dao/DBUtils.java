package com.contactmanager.dao;

import java.sql.*;

/**
 * @author vaisakhvm
 */
public class DBUtils {
    private String connectionString = "jdbc:sqlite:/Users/vaisakhvm/Projects/Learning/9005.java/contact-manager/contactmanager.db";
    private PreparedStatement statement;
    private Connection connection;

    protected boolean executeNonQuery(String query, SQLParameter params[]) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(this.connectionString);
            this.statement = this.connection.prepareStatement(query);
            addParameters(this.statement, params);
            this.statement.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    protected boolean executeNonQuery(String query) {
        return executeNonQuery(query, null);
    }

    protected ResultSet executeQuery(String query, SQLParameter params[]) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(this.connectionString);
            this.statement = this.connection.prepareStatement(query);
            addParameters(this.statement, params);
            return statement.executeQuery();

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }

    protected ResultSet executeQuery(String query) {
        return executeQuery(query, null);
    }

    protected void closeConnection() throws SQLException {
        this.statement.close();
        this.connection.close();
        this.statement = null;
        this.connection = null;
    }

    private void addParameters(PreparedStatement statement, SQLParameter params[]) {
        try {
            if(params != null && statement != null) {
                for (int i = 0; i < params.length; i++) {
                    switch (params[i].type) {
                        case SQLString:
                            if(params[i].value == null) {
                                statement.setNull(i + 1, Types.VARCHAR);
                            } else {
                                statement.setString(i + 1, (String) params[i].value);
                            }
                            break;
                        case SQLInt:
                            if(params[i].value == null) {
                                statement.setNull(i + 1, Types.INTEGER);
                            } else {
                                statement.setInt(i + 1, (Integer) params[i].value);
                            }
                            break;
                        case SQLText:
                            if(params[i].value == null) {
                                statement.setNull(i + 1, Types.NVARCHAR);
                            } else {
                                statement.setString(i + 1, (String) params[i].value);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
