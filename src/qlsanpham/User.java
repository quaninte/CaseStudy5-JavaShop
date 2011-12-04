/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qlsanpham;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PAC
 */
class User  extends Db{

    String username;
    String password;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  boolean login(String username, String password) {
          this.connect();

        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("SELECT * FROM users WHERE `username` = ? AND `password` = ? AND `admin` =1 ");

            // Parameters start with 1

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
           // preparedStatement.executeUpdate();
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                this.setId(resultSet.getInt("id"));
                this.setUsername(resultSet.getString("username"));
                return true;
            }
            
         } catch (SQLException ex) {
            System.out.println("Khong dung");
        }

          this.disconnect();
          return false;


    }


}
