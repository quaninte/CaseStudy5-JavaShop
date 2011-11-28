/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.entity;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author quanmt
 */
public class Order implements Entity {
    
    protected int id;
    protected User user;
    protected int total;
    protected Vector<OrderProduct> orderProducts = new Vector();
    protected Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vector<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    @Override
    public Vector toVector() {
        Vector orderVector = new Vector();
        orderVector.add(0, id);
        orderVector.add(1, user.toVector());
        orderVector.add(2, total);
        orderVector.add(3, date);
        
        return orderVector;
    }

    @Override
    public void readVector(Vector vector) {
        this.id = (Integer)vector.get(0);
        this.user = new User();
        this.user.readVector((Vector) vector.get(1));
        this.total = (Integer) vector.get(2);
        this.date = (Date) vector.get(3);
    }
    
}
