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
public class Product extends javashop.entity.Product {
    
    /**
     * Get product list by category
     * @param category
     * @return Vector
     */
    public Vector getListByCategory(Category category) {
        Vector list = new Vector();
        
        String getListQuery = "SELECT id, image, name, price, description FROM products";
        if (category != null && category.getId() > 0) {
            getListQuery += " WHERE category_id = " + String.valueOf(category.getId());
        }
        
        PreparedStatement statement;
        try {
            statement = Db.getConnect().prepareStatement(getListQuery);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setImage(result.getString("image"));
                product.setName(result.getString("name"));
                product.setPrice(Integer.valueOf(result.getString("price")));
                product.setDescription(result.getString("description"));
                
                list.add(product.toVector());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    /**
     * Find product by id
     * @param productId
     * @return 
     */
    public boolean findByid(int productId) {
        String findByIdSql = "SELECT id, image, name, price, description FROM products WHERE id = ?";
        
        try {
            PreparedStatement statement = Db.getConnect().prepareStatement(findByIdSql);
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                this.setId(result.getInt("id"));
                this.setImage(result.getString("image"));
                this.setName(result.getString("name"));
                this.setPrice(Integer.valueOf(result.getString("price")));
                this.setDescription(result.getString("description"));
                
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
