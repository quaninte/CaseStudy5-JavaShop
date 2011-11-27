/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class User extends Entity {
    
    protected int id;
    protected String username;
    protected String password;
    protected String phone;
    protected String address;
    protected boolean admin;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void add() {
        try {
            String addQuery = "INSERT INTO users"
                    + "(`username`, `password`, `phone`, `address`, `admin`)"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = this.connect.prepareStatement(addQuery);
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
            
            PreparedStatement statement = this.connect.prepareStatement(loginQuery);
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
