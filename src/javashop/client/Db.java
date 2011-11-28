package javashop.client;


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
    
    public static Connection connect = null;

    public void connect() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            Db.connect = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.dbname + "?" + "user=" + this.dbuser + "&password=" + this.dbpass);
            System.out.println("Database connected!");
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    public static Connection getConnect() {
        
        if (connect == null) {
            // connect to db
            Db db = new Db();
            db.connect();
        }
        
        return connect;
    }
    
}
