package pages_Jeff_Admin;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import datebase_jon.Order;
import datebase_jon.Product;
import datebase_jon.ShopletSystemManager;
import net.miginfocom.swing.MigLayout;
import pages_Jeff_Seller.ProductUI;

public class OrdersUI extends JFrame implements ActionListener{

    //private Refund refund;
    /**
     * Creates new form OrdersUI
     */
    public OrdersUI() {
    	setTitle("Admin Panel - Orders");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        menuPane = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        home.setForeground(new Color(255, 255, 255));
        ordersPane = new javax.swing.JPanel();

        contentPane.setBackground(new Color(240, 240, 240));

        menuPane.setBackground(new Color(240, 240, 240));

        home.setBackground(new java.awt.Color(102, 102, 102));
        home.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        home.setText("Close");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPaneLayout = new javax.swing.GroupLayout(menuPane);
        menuPaneLayout.setHorizontalGroup(
        	menuPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(menuPaneLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(home, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(497, Short.MAX_VALUE))
        );
        menuPaneLayout.setVerticalGroup(
        	menuPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(menuPaneLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(home, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        			.addContainerGap())
        );
        menuPane.setLayout(menuPaneLayout);

        ordersPane.setBackground(new Color(240, 240, 240));

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPaneLayout.setHorizontalGroup(
        	contentPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(contentPaneLayout.createSequentialGroup()
        			.addGroup(contentPaneLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, contentPaneLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(ordersPane, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
        				.addGroup(Alignment.LEADING, contentPaneLayout.createSequentialGroup()
        					.addGap(64)
        					.addComponent(menuPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
        	contentPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(contentPaneLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(menuPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(ordersPane, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPane.setLayout(contentPaneLayout);
        ordersPane.setLayout(new BoxLayout(ordersPane, BoxLayout.X_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        ordersPane.setLayout(new BoxLayout(ordersPane, BoxLayout.Y_AXIS));
        
        //Orders
        List<Order> orders = ShopletSystemManager.getInstance().get_all_orders();
        
        for (int i = 0; i < orders.size(); i++)
        {
        	ordersPane.add(addOrderItem(orders.get(i).order_id, orders.get(i).buyer_id, orders.get(i).total_cost, orders.get(i).product_ids), "span, growx");
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adds an order item UI element
     * @param order_id the order_id of the order
     * @param buyer_id the buyer_id of the order
     * @param total_cost the total_cost of the order
     * @param productIds the product ids involved in the order
     * @return A JPanel element reperesnting a order
     */
    public JPanel addOrderItem(Integer order_id, Integer buyer_id, String total_cost, String productIds)
    {    	
        // Convert price to 2 decimal places
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel orderPanel = new JPanel(new MigLayout("", "[][]push[][]15", "[]"));
        orderPanel.setPreferredSize(new Dimension(1000, 60));
        orderPanel.setMaximumSize(new Dimension(1000, 60));
        orderPanel.setBackground(Color.white);
        
        JLabel orderNumber = new JLabel("Order #000" + order_id.toString());
        orderNumber.setMaximumSize(new Dimension(200, 100));
        orderPanel.add(orderNumber);

        JLabel orderBuyer = new JLabel("Buyer ID: " + buyer_id.toString());
        orderBuyer.setMaximumSize(new Dimension(200, 100));
        orderPanel.add(orderBuyer);
        
        JLabel orderTotalCost = new JLabel("Total cost: $" + total_cost);
        orderTotalCost.setMaximumSize(new Dimension(200, 100));
        orderPanel.add(orderTotalCost);
        
        JLabel productsIdsInCart = new JLabel("Order Products: " + productIds);
        productsIdsInCart.setMaximumSize(new Dimension(200, 100));
        orderPanel.add(productsIdsInCart);
        
        JButton cancelOrder = new JButton("Cancel Order");
        cancelOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ShopletSystemManager.getInstance().delete_order(order_id);
        		refreshOrdersUI();
        		JOptionPane.showMessageDialog(null, "Order has been cancelled. Refund in process...", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        
        orderPanel.add(cancelOrder);
        orderPanel.setBorder(border);

        // Return the product panel
        return orderPanel;
    }
    
    void refreshOrdersUI()
    {
    	ordersPane.removeAll();
		
    	 //Orders
        List<Order> orders = ShopletSystemManager.getInstance().get_all_orders();
        
        for (int i = 0; i < orders.size(); i++)
        {
        	ordersPane.add(addOrderItem(orders.get(i).order_id, orders.get(i).buyer_id, orders.get(i).total_cost, orders.get(i).product_ids), "span, growx");
        }
			
	     ordersPane.revalidate();
	     ordersPane.repaint();	
    }
    
    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
    	this.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    /**
     * Main
     * @param args
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
            java.util.logging.Logger.getLogger(OrdersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersUI().setVisible(true);
            }
        });
    }
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton home;
    private javax.swing.JPanel menuPane;
    private javax.swing.JPanel ordersPane;
    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
