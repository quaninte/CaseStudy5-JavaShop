/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class OrderProduct extends Entity {
    
    protected int id;
    protected Order order;
    protected Product product;
    protected int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void add() {
        try {
            String addQuery = "INSERT INTO order_product"
                    + "(`order_id`, `product_id`, `quantity`)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = this.connect.prepareStatement(addQuery);
            statement.setInt(1, order.getId());
            statement.setInt(2, product.getId());
            statement.setInt(3, quantity);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
