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
public class Product implements Entity {
    
    protected int id = 0;
    protected Category category;
    protected String name;
    protected String image;
    protected int price;
    protected String description;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Vector toVector() {
        Vector product = new Vector();
        
        product.add(0, id);
        product.add(1, name);
        product.add(2, image);
        product.add(3, price);
        product.add(4, description);
        
        return product;
    }

    @Override
    public void readVector(Vector vector) {
        this.id = Integer.valueOf(vector.get(0).toString());
        this.name = (String) vector.get(1);
        this.image = (String) vector.get(2);
        this.price = Integer.valueOf(vector.get(3).toString());
        this.description = (String) vector.get(4);
    }
}
