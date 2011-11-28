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
public class Product extends javashop.entity.Product {
    
    /**
     * Get product list by category
     * @param category
     * @return Vector<Product>
     */
    public Vector<Product> getListByCategory(Category category) {
        Vector<Product> list = new Vector<Product>();
        
        Vector productsVector = null;
        try {
            int categoryId;
            if (category != null) {
                categoryId = category.getId();
            } else {
                categoryId = 0;
            }
            productsVector = App.getServer().getProductsByCategory(categoryId);
        } catch (RemoteException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < productsVector.size(); i++) {
            Product product = new Product();
            product.readVector((Vector)productsVector.get(i));
            list.add(product);
        }
        
        return list;
    }

    /**
     * Find product by id
     * @param productId
     * @return 
     */
    public boolean findByid(int productId) {
        Vector productVector = null;
        try {
            productVector = App.getServer().getProductByid(productId);
        } catch (RemoteException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.readVector(productVector);
        
        if (this.id != 0) {
            return true;
        }
        
        return false;
    }
}
