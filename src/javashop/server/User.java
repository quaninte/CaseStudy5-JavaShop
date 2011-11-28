/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class User extends javashop.entity.User {
    
    public void add() {
        try {
            String addQuery = "INSERT INTO users"
                    + "(`username`, `password`, `phone`, `address`, `admin`)"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = Db.getConnect().prepareStatement(addQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, phone);
            statement.setString(4, address);
            statement.setBoolean(5, admin);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean login(String username, String password) {
        try {
            String loginQuery = "SELECT u.id, u.username, u.password, u.phone, u.address FROM users AS u"
                    + " WHERE username = ? AND password = ?";
            
            PreparedStatement statement = Db.getConnect().prepareStatement(loginQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                
                this.setId(result.getInt("id"));
                this.setUsername(result.getString("username"));
                this.setPassword(result.getString("password"));
                this.setPhone(result.getString("phone"));
                this.setAddress(result.getString("address"));
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
