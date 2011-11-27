/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class Order extends Entity {
    
    protected int id;
    protected User user;
    protected int total;
    protected Vector<OrderProduct> orderProducts = new Vector();
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vector<OrderProduct> getOrderProducts() {
        return orderProducts;
    }
    
    public void clearCart() {
        this.orderProducts = null;
    }
    
    public void addCart(Product product, int quantity) {
        for (int i = 0; i < this.orderProducts.size(); i++) {
            OrderProduct orderProduct = this.orderProducts.get(i);
            if (orderProduct.getProduct().getId() == product.getId()) {
                orderProduct.setQuantity(orderProduct.getQuantity() + quantity);
                return;
            }
        }
        
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setQuantity(quantity);
        
        this.orderProducts.add(orderProduct);
    }
    
    public int getTotalAmount() {
        int totalAmount = 0;
        for (int i = 0; i < this.orderProducts.size(); i++) {
            OrderProduct orderProduct = this.orderProducts.get(i);
            totalAmount += orderProduct.getProduct().getPrice() * orderProduct.getQuantity();
        }
        
        return totalAmount;
    }

    public void add() {
        user = App.getUser();
        total = this.getTotalAmount();
        date = new Date(new java.util.Date().getTime());
        
        try {
            String addQuery = "INSERT INTO orders"
                    + "(`user_id`, `total`, `date`)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = this.connect.prepareStatement(addQuery, Statement.RETURN_GENERATED_KEYS);
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
                OrderProduct orderProduct = this.orderProducts.get(i);
                orderProduct.setOrder(this);
                orderProduct.add();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
