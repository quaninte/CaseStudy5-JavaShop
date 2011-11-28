/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javashop.client;

import java.sql.Connection;

/**
 *
 * @author quanmt
 */
public class Entity {
    
    protected Connection connect;
    
    public Entity() {
        this.connect = Db.getConnect();
    }
    
}
