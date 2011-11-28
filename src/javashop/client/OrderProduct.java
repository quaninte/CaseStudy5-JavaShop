/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.client;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class OrderProduct extends javashop.entity.OrderProduct {

    public void add() {
        try {
            App.getServer().addOrderProduct(this.toVector());
        } catch (RemoteException ex) {
            Logger.getLogger(OrderProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
