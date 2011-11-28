/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author quanmt
 */
public class App extends UnicastRemoteObject implements ShopService {

    public App() throws RemoteException {
        super();
    }
    
    @Override
    public Vector getCategories() throws RemoteException {
        Category category = new Category();
        return category.getList();
    }

    @Override
    public Vector getProductsByCategory(int categoryId) throws RemoteException {
        Category category = new Category();
        category.setId(categoryId);
        
        Product product = new Product();
        return product.getListByCategory(category);
    }

    @Override
    public Vector getProductByid(int productId) throws RemoteException {
        Product product = new Product();
        product.findByid(productId);
        
        return product.toVector();
    }

    @Override
    public int addOrder(Vector vector) throws RemoteException {
        Order order = new Order();
        order.readVector(vector);
        order.add();
        
        return order.getId();
    }

    @Override
    public void addOrderProduct(Vector vector) throws RemoteException {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.readVector(vector);
        orderProduct.add();
    }
    
    public static void main(String[] args) throws Exception {
        App app = new App();

        LocateRegistry.createRegistry(12345);
        Naming.rebind("rmi://localhost:12345/ShopService", app);
        
        System.out.print("RMI server is running ...");
    }

    @Override
    public void addUser(Vector vector) throws RemoteException {
        User user = new User();
        user.readVector(vector);
        user.add();
    }

    @Override
    public Vector login(String username, String password) throws RemoteException {
        User user = new User();
        if (user.login(username, password)) {
            return user.toVector();
        }
        
        return null;
    }
}
