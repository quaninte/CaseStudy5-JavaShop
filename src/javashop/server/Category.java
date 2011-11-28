/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.server;

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
public class Category extends javashop.entity.Category {
    
    public Vector getList() {
        Vector list = new Vector();
        
        String getListQuery = "SELECT id, name FROM categories";
        try {
            PreparedStatement statement = Db.getConnect().prepareStatement(getListQuery);
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                Category category = new Category();
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
                
                list.add(category.toVector());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
