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
public class Product extends Entity {
    
    protected int id;
    protected Category category;
    protected String name;
    protected String image;
    protected int price;
    protected String description;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    /**
     * Get product list by category
     * @param category
     * @return Vector<Product>
     */
    public Vector<Product> getListByCategory(Category category) {
        Vector<Product> list = new Vector<Product>();
        
        String getListQuery = "SELECT id, image, name, price, description FROM products";
        if (category != null) {
            getListQuery += " WHERE category_id = " + String.valueOf(category.getId());
        }
        
        PreparedStatement statement;
        try {
            statement = this.connect.prepareStatement(getListQuery);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setImage(result.getString("image"));
                product.setName(result.getString("name"));
                product.setPrice(Integer.valueOf(result.getString("price")));
                product.setDescription(result.getString("description"));
                
                list.add(product);
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
            PreparedStatement statement = this.connect.prepareStatement(findByIdSql);
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
