/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.client;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class Order extends javashop.entity.Order {
    
    public void clearCart() {
        this.orderProducts = null;
    }
    
    public void addCart(Product product, int quantity) {
        for (int i = 0; i < this.orderProducts.size(); i++) {
            OrderProduct orderProduct = (OrderProduct) this.orderProducts.get(i);
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
            OrderProduct orderProduct = (OrderProduct) this.orderProducts.get(i);
            totalAmount += orderProduct.getProduct().getPrice() * orderProduct.getQuantity();
        }
        
        return totalAmount;
    }

    public void add() {
        user = App.getUser();
        total = this.getTotalAmount();
        date = new Date(new java.util.Date().getTime());
        
        try {
            this.id = App.getServer().addOrder(this.toVector());
        } catch (RemoteException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }

        // add orderProducts
        for (int i = 0; i < this.orderProducts.size(); i++) {
            OrderProduct orderProduct = (OrderProduct) this.orderProducts.get(i);
            orderProduct.setOrder(this);
            orderProduct.add();
        }
    }
    
}
