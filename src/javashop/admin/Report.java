/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javashop.admin;

import java.sql.SQLException;

/**
 *
 * @author PAC
 */
public class Report extends Db {

    // doanh thu
    int total;

    // so luong ban duoc
    int quantity;

    // thog tin ngay thang nam
    int day;
    int month;
    int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // lay thong tin bao cao
   public void getReport() {
        this.connect();

        String dateQuery;
        // tim theo ngay
        if( this.day != 0){
            dateQuery = year + "-" + month + "-" + day;
        } else if( this.month != 0){
            // tim theo thang
            dateQuery = year + "-" + month + "-%";
        } else {
            // tim theo thang
            dateQuery = year + "-%";
        }
      try {

            statement = connect.createStatement();
            // Result set get the result of the SQL query

            String query = "SELECT SUM(total) AS summary_total FROM orders WHERE `date` LIKE ?" ;
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, dateQuery);
            
            resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            this.total = resultSet.getInt("summary_total");
        } catch (SQLException ex) {
            System.out.println("Loi sql");
        } 
          try {
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("SELECT SUM(quantity) AS summary FROM order_product AS op LEFT JOIN orders AS o ON (op.order_id = o.id) WHERE `date` LIKE ?");

            // Parameters start with 1
            preparedStatement.setString(1, dateQuery);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            this.quantity = resultSet.getInt("summary");

        } catch (SQLException ex) {
            System.out.println("Loi sql");
        }
        this.disconnect();


    }

}
