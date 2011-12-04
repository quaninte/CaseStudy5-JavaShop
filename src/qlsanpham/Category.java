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
public class Category extends Db {
   int id;
   String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Vector getList() {
        Vector list = new Vector();
        this.connect();


        try {
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("SELECT * FROM categories");

            while (resultSet.next()) {
                Category categories = new Category();
                categories.setId(resultSet.getInt(1));
                categories.setName(resultSet.getString(2));
                list.add(categories);

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
            preparedStatement = connect.prepareStatement("INSERT INTO categories(`name`) VALUES (?)");
            // Parameters start with 1
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {

        }
        this.disconnect();
    }

    Category get(int categoriesID) {
        this.connect();

        Category categories = new Category();
        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("SELECT * FROM categories WHERE `id` = ?");

            // Parameters start with 1
            preparedStatement.setInt(1, categoriesID);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            categories.setId(resultSet.getInt(1));
            categories.setName(resultSet.getString(2));
        } catch (SQLException ex) {
            System.out.println("Loi sql");
        }
        this.disconnect();

        return categories;

    }

    void save() {
        this.connect();

        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("UPDATE categories SET name = ? WHERE id = ?");
            // Parameters start with 1
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi sql");
        }
        this.disconnect();
    }

    void delete(int categoryId) {
        this.connect();

        try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("DELETE FROM `categories` WHERE `id` = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi sql");
        }
        this.disconnect();

    }

}
