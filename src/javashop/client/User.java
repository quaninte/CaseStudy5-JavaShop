/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.client;

import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class User extends javashop.entity.User {

    public void add() {
        try {
            App.getServer().addUser(this.toVector());
        } catch (RemoteException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean login(String username, String password) {
        Vector userVector = null;
        try {
            userVector = App.getServer().login(username, password);
        } catch (RemoteException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (userVector != null) {
            this.readVector(userVector);
            return true;
        }
        
        return false;
    }
    
}
