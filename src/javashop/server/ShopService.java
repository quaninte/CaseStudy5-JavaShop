/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author quanmt
 */
public interface ShopService extends Remote {
    
    public Vector getCategories() throws RemoteException;
    
    public Vector getProductsByCategory(int categoryId) throws RemoteException;
    
    public Vector getProductByid(int productId) throws RemoteException;
    
    public int addOrder(Vector vector) throws RemoteException;
    
    public void addOrderProduct(Vector vector) throws RemoteException;
    
    public void addUser(Vector vector) throws RemoteException;
    
    public Vector login(String username, String password) throws RemoteException;
    
}
