/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * App.java
 *
 * Created on Nov 27, 2011, 1:59:54 PM
 */
package javashop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanmt
 */
public class App extends javax.swing.JFrame {

    public static User user = null;
    public static App app = null;
    public static Order order = null;
    public Users usersController = null;
    
    /** Creates new form App */
    public App() throws Exception {
        initComponents();
        App.setApp(this);
    }

    public static User getUser() {
        return App.user;
    }

    public static void setUser(User user) {
        App.user = user;
    }

    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        App.app = app;
    }

    public static Order getOrder() {
        if (App.order == null) {
            App.order = new Order();
        }
        return App.order;
    }

    public static void setOrder(Order order) {
        App.order = order;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        listProductsMenuItem = new javax.swing.JMenuItem();
        cartMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Shop");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        jLabel1.setText("Java Shop");

        jMenu1.setText("View");

        jMenuItem1.setText("User");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Shopping");

        listProductsMenuItem.setText("List Products");
        listProductsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listProductsMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(listProductsMenuItem);

        cartMenuItem.setText("Shopping Cart");
        cartMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(cartMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(113, 113, 113)
                .add(jLabel1)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(62, 62, 62)
                .add(jLabel1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (usersController == null) {
            usersController = new Users();
        }
        usersController.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void listProductsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listProductsMenuItemActionPerformed
        ListProducts listProducts = new ListProducts();
        listProducts.setVisible(true);
    }//GEN-LAST:event_listProductsMenuItemActionPerformed

    private void cartMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartMenuItemActionPerformed
        Cart cart = new Cart();
        cart.setVisible(true);
    }//GEN-LAST:event_cartMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new App().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cartMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem listProductsMenuItem;
    // End of variables declaration//GEN-END:variables
}
