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
public interface Entity {
    
    public Vector toVector() ;
    public void readVector(Vector vector);

}
