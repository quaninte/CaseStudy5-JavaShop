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
public class Category extends javashop.entity.Category {
    
    public Vector<Category> getList() {
        Vector<Category> list = new Vector<Category>();
        
        Vector categoriesVector = null;
        try {
            categoriesVector = App.getServer().getCategories();
        } catch (RemoteException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < categoriesVector.size(); i++) {
            Category category = new Category();
            category.readVector((Vector)categoriesVector.get(i));
            list.add(category);
        }
        
        return list;
    }
    
}
