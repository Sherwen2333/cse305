package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    // Constants
    private static final String CONNECTION = "jdbc:mysql://localhost:3306/Rendezvous?useSSL=false";
    private static final String SQL_USERNAME = "root";
    private static final String SQL_PASSWORD = "rendezvous@305";

    // Connection
    private static Connection con;

    public static void main(String[] args) {
        try {
            setUpConnection();

            System.out.println(con == null);

        } catch (Exception e) {

        }
    }

    /**
     * Set up database connection
     */
    private static void setUpConnection() {
        if (con != null)
            return;
        try {
            setCon(DriverManager.getConnection(CONNECTION, SQL_USERNAME, SQL_PASSWORD));
        } catch (Exception e) {

        }
    }

    /**
     * Get a connection (session) with a specific database. If connection is not
     * established it will be established and returned;
     *
     * @return A connection (session) with a specific database
     *
     */
    public static Connection getCon() {
        setUpConnection();
        return con;
    }

    /**
     * Set a connection (session) with a specific database.
     *
     * @param con
     *            Connection to be set
     */
    public static void setCon(Connection con) {
        Connector.con = con;
    }

}