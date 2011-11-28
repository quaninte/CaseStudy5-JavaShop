/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.entity;

import java.util.Vector;

/**
 *
 * @author quanmt
 */
public class Category implements Entity {
    
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public Vector toVector() {
        Vector category = new Vector();
        
        category.add(0, id);
        category.add(1, name);
        
        return category;
    }
    
    @Override
    public void readVector(Vector category) {
        id = Integer.valueOf(category.get(0).toString());
        name = (String) category.get(1);
    }
    
}
