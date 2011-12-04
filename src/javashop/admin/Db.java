package javashop.admin;


import java.sql.*;
import java.util.logging.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PAC
 */
public class Db {

    private String host = "localhost";
    private String dbname = "java_shop";
    private String dbuser = "root";
    private String dbpass = "root";
    
    public Connection connect = null;
    public Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public void connect() {
     try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connect = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.dbname + "?" + "user=" + this.dbuser + "&password=" + this.dbpass);
            } catch (SQLException ex) {
            }
        } catch (ClassNotFoundException ex) {
        }
    }
    public void disconnect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
