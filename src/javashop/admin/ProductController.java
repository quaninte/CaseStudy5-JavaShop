/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javashop.admin;

import java.util.Vector;

/**
 *
 * @author PAC
 */
public class ProductController {
    ProductView view;
    Product entity;

    public ProductController() {
        this.view = new ProductView();
        this.entity = new Product();
        this.view.setController(this);
    }
   void start() {
        this.updateList();
        this.view.setVisible(true);

    }

   void updateList() {
         Vector list = this.entity.getList();
            for(int  i = 0; i < list.size(); i++ ){
                Product products = (Product)list.elementAt(i);
                this.view.addProductsToTable(products.getId(), products.getName(), products.getImage(), products.getPrice(), products.getDescription(), products.categories.getName());
         }
    }
    public static void main(String args[]){
        ProductController productsController = new ProductController();
        productsController.start();
    }

    void add(String name, String image, int price, String description, int categoryID) {
        Product products = new Product();
        products.setName(name);
        products.setImage(image);
        products.setPrice(price);
        products.setDescription(description);
        products.setCategories(categoryID);
        products.add();
        this.view.clearTable();
        this.updateList();
    }

    void add(int productId, String name, String image, int price, String description, int categoryId) {
        Product product = new Product();
        product.setImage(image);
        product.setName(name);
        product.setDescription(description);
        product.setId(productId);
        product.setPrice(price);
        product.setCategories(categoryId);
        product.save();
        this.view.clearTable();
        this.updateList();
    }

    void delete(int productId) {
        this.entity.delete(productId);

        this.view.clearTable();
        this.updateList();
    }

}
