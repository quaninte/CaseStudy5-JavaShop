/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class Order extends javashop.entity.Order {

    public void add() {
        try {
            String addQuery = "INSERT INTO orders"
                    + "(`user_id`, `total`, `date`)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = Db.getConnect().prepareStatement(addQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, user.getId());
            statement.setInt(2, total);
            statement.setDate(3, date);
            
            statement.executeUpdate();
            
            // get last inserted id
            ResultSet result = statement.getGeneratedKeys();
            
            int orderId;
            if (result != null && result.next()) {
                orderId = result.getInt(1);
                this.id = orderId;
            }
            
            // add orderProducts
            for (int i = 0; i < this.orderProducts.size(); i++) {
                OrderProduct orderProduct = (OrderProduct) this.orderProducts.get(i);
                orderProduct.setOrder(this);
                orderProduct.add();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
