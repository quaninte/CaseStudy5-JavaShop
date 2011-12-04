/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qlsanpham;

import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author PAC
 */
public class Product extends Db{
    int id;
    String name;
    String image;
    int price;
    String description;
    Category categories;

    public Category getCategories() {
        return categories;
    }

    public void setCategories(int categoryID) {
        this.categories = new Category();
        this.categories.setId(categoryID);

    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public Vector getList() {
        Vector list = new Vector();
        this.connect();


        try {
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("SELECT products.*, categories.name AS category_name FROM products LEFT JOIN categories ON products.category_id = categories.id");

            while (resultSet.next()) {
                Product products = new Product();
                products.setId(resultSet.getInt(1));
                products.setCategories(resultSet.getInt(2));
                products.setName(resultSet.getString(3));
                products.setImage(resultSet.getString(4));
                products.setPrice(resultSet.getInt(5));
                products.setDescription(resultSet.getString(6));
                products.getCategories().setName(resultSet.getString(7));
                list.add(products);

            }
        } catch (SQLException ex) {

        }
        this.disconnect();

        return list;
    }

    void add() {
          this.connect();

        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("INSERT INTO products (`category_id`, `name`, `image`, `price`, `description`) VALUES (?,?,?,?,?)");

            // Parameters start with 1
            preparedStatement.setInt(1,categories.getId());
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, image);
            preparedStatement.setInt(4, price);
            preparedStatement.setString(5, description);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
           System.out.println("loi");

        }
        this.disconnect();
    }

    Product get(int productId) {
        this.connect();

        Product product = new Product();
        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(" SELECT products.* , categories.name AS category_name FROM products LEFT JOIN categories ON products.category_id = categories.id WHERE products.id = ?");

            // Parameters start with 1
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();
             resultSet.next();
            product.setId(resultSet.getInt(1));
            product.setCategories(resultSet.getInt(2));
            product.setName(resultSet.getString(3));
            product.setImage(resultSet.getString(4));
            product.setPrice(resultSet.getInt(5));
            product.setDescription(resultSet.getString(6));
            product.getCategories().setName(resultSet.getString(7));


        } catch (SQLException ex) {
            System.out.println("Loi sql");
        }
        this.disconnect();

        return product;
    }

    void save() {
           this.connect();

        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("UPDATE `products` SET `category_id` = ?,`name` = ?, `image` = ?, `price` = ?, `description` = ?  WHERE `id` = ?");

            // Parameters start with 1
            preparedStatement.setInt(1, categories.getId());
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, image);
            preparedStatement.setInt(4, price);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
         } catch (SQLException ex) {
            System.out.println("Khong luu duoc");
        }
        this.disconnect();
    }

    void delete(int productId) {
        this.connect();

        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("DELETE FROM `products` WHERE `id` =?");

            // Parameters start with 1
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {

        }
        this.disconnect();

    }
}
