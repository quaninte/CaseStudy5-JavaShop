/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class Category extends Entity {
    
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Vector<Category> getList() {
        Vector<Category> list = new Vector<Category>();
        
        String getListQuery = "SELECT id, name FROM categories";
        try {
            PreparedStatement statement = this.connect.prepareStatement(getListQuery);
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                Category category = new Category();
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
                
                list.add(category);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public String toString() {
        return name;
    }
    
}
