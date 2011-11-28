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
public class OrderProduct implements Entity {
    
    protected int id;
    protected Order order;
    protected Product product;
    protected int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Vector toVector() {
        Vector vector = new Vector();
        vector.add(0, id);
        vector.add(1, order.toVector());
        vector.add(2, product.toVector());
        vector.add(3, quantity);
        return vector;
    }

    @Override
    public void readVector(Vector vector) {
        this.id = (Integer) vector.get(0);
        this.order = new Order();
        this.order.readVector((Vector) vector.get(1));
        this.product = new Product();
        this.product.readVector((Vector) vector.get(2));
        this.quantity = (Integer) vector.get(3);
    }
    
}
