/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.server;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class OrderProduct extends javashop.entity.OrderProduct {

    public void add() {
        try {
            String addQuery = "INSERT INTO order_product"
                    + "(`order_id`, `product_id`, `quantity`)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = Db.getConnect().prepareStatement(addQuery);
            statement.setInt(1, order.getId());
            statement.setInt(2, product.getId());
            statement.setInt(3, quantity);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
