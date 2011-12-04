/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javashop.admin;

import java.util.Vector;
import javax.swing.text.View;

/**
 *
 * @author PAC
 */
public class CategoryController {
    CategoryView view;
    Category entity;

    

    public CategoryController() {
        this.view = new CategoryView();
        this.view.setController(this);
        this.entity = new Category();
    }
    void start() {
            this.updateList();
            this.view.setVisible(true);
            }


    void updateList() {
            Vector list = this.entity.getList();
            for(int i = 0; i < list.size(); i++) {
            Category categories = (Category) list.elementAt(i);
            this.view.addCategoriesToTable(categories.getId(), categories.getName());
            }
           }

    public static void main(String args[]){
        CategoryController categoriesController = new CategoryController();
        categoriesController.start();
    }

    void add(String name) {
        Category categories = new Category();
        categories.setName(name);
        categories.add();
        this.view.clearTable();
        this.updateList();
    }

    void save(int categoryId,String name) {
        Category categories = new Category();
        categories.setId(categoryId);
        categories.setName(name);
        categories.save();
        this.view.clearTable();
        this.updateList();
    }

    void delete(int categoryId) {
        this.entity.delete(categoryId);
        this.view.clearTable();
        this.updateList();

    }

}
