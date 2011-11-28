/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.entity;

import java.util.Vector;

/**
 *
 * @author quanmt
 */
public class User implements Entity {
    
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

    @Override
    public Vector toVector() {
        Vector userVector = new Vector();
        userVector.add(0, id);
        userVector.add(1, username);
        userVector.add(2, password);
        userVector.add(3, phone);
        userVector.add(4, address);
        userVector.add(5, admin);
        
        return userVector;
    }

    @Override
    public void readVector(Vector vector) {
        this.id = (Integer) vector.get(0);
        this.username = (String) vector.get(1);
        this.password = (String) vector.get(2);
        this.phone = (String) vector.get(3);
        this.address = (String) vector.get(4);
        this.admin = (Boolean) vector.get(5);
    }
    
}
