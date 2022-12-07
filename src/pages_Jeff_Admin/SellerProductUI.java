/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pages_Jeff_Admin;

/**
 *
 * @author jeffplatel
 */
public class SellerProductUI extends javax.swing.JFrame {

    /**
     * Creates new form SellerProductUI
     */
    public SellerProductUI() {
    	setTitle("Seller Products");
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
        back_button = new javax.swing.JButton();
        product_listPane = new javax.swing.JPanel();
        product1 = new javax.swing.JPanel();
        product_name1 = new javax.swing.JLabel();
        view_button1 = new javax.swing.JButton();
        cost1 = new javax.swing.JLabel();
        product2 = new javax.swing.JPanel();
        product_name2 = new javax.swing.JLabel();
        view_button2 = new javax.swing.JButton();
        cost2 = new javax.swing.JLabel();
        product3 = new javax.swing.JPanel();
        product_name3 = new javax.swing.JLabel();
        view_button3 = new javax.swing.JButton();
        cost3 = new javax.swing.JLabel();
        product4 = new javax.swing.JPanel();
        product_name4 = new javax.swing.JLabel();
        view_button4 = new javax.swing.JButton();
        cost4 = new javax.swing.JLabel();

        contentPane.setBackground(new java.awt.Color(255, 255, 255));

        back_button.setBackground(new java.awt.Color(102, 102, 102));
        back_button.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        back_button.setText("Back");
        back_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActiveSellersUI obj = new ActiveSellersUI();
                obj.setVisible(true);
            }
        });

        product_listPane.setBackground(new java.awt.Color(255, 255, 255));

        product1.setBackground(new java.awt.Color(255, 255, 255));
        product1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        product_name1.setText("Product Name");

        view_button1.setBackground(new java.awt.Color(102, 102, 102));
        view_button1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        view_button1.setText("View");
        view_button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        view_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductUI obj = new ProductUI();
                obj.setVisible(true);
            }
        });

        cost1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cost1.setText("Cost: $XXX.XX");

        javax.swing.GroupLayout product1Layout = new javax.swing.GroupLayout(product1);
        product1.setLayout(product1Layout);
        product1Layout.setHorizontalGroup(
            product1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cost1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(view_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        product1Layout.setVerticalGroup(
            product1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(product1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cost1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(view_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        product2.setBackground(new java.awt.Color(255, 255, 255));
        product2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        product_name2.setText("Product Name");

        view_button2.setBackground(new java.awt.Color(102, 102, 102));
        view_button2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        view_button2.setText("View");
        view_button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        view_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductUI obj = new ProductUI();
                obj.setVisible(true);
            }
        });

        cost2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cost2.setText("Cost: $XXX.XX");

        javax.swing.GroupLayout product2Layout = new javax.swing.GroupLayout(product2);
        product2.setLayout(product2Layout);
        product2Layout.setHorizontalGroup(
            product2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(cost2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(view_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        product2Layout.setVerticalGroup(
            product2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(product2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cost2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(view_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        product3.setBackground(new java.awt.Color(255, 255, 255));
        product3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        product_name3.setText("Product Name");

        view_button3.setBackground(new java.awt.Color(102, 102, 102));
        view_button3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        view_button3.setText("View");
        view_button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        view_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductUI obj = new ProductUI();
                obj.setVisible(true);
            }
        });

        cost3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cost3.setText("Cost: $XXX.XX");

        javax.swing.GroupLayout product3Layout = new javax.swing.GroupLayout(product3);
        product3.setLayout(product3Layout);
        product3Layout.setHorizontalGroup(
            product3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cost3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(view_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        product3Layout.setVerticalGroup(
            product3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(product3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cost3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_name3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(view_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        product4.setBackground(new java.awt.Color(255, 255, 255));
        product4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        product_name4.setText("Product Name");

        view_button4.setBackground(new java.awt.Color(102, 102, 102));
        view_button4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        view_button4.setText("View");
        view_button4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        view_button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductUI obj = new ProductUI();
                obj.setVisible(true);
            }
        });

        cost4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        cost4.setText("Cost: $XXX.XX");

        javax.swing.GroupLayout product4Layout = new javax.swing.GroupLayout(product4);
        product4.setLayout(product4Layout);
        product4Layout.setHorizontalGroup(
            product4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_name4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cost4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(view_button4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        product4Layout.setVerticalGroup(
            product4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(product4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cost4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_name4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(view_button4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout product_listPaneLayout = new javax.swing.GroupLayout(product_listPane);
        product_listPane.setLayout(product_listPaneLayout);
        product_listPaneLayout.setHorizontalGroup(
            product_listPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_listPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(product_listPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(product1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        product_listPaneLayout.setVerticalGroup(
            product_listPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_listPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(product_listPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(product_listPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SellerProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellerProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellerProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellerProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellerProductUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel cost1;
    private javax.swing.JLabel cost2;
    private javax.swing.JLabel cost3;
    private javax.swing.JLabel cost4;
    private javax.swing.JPanel product1;
    private javax.swing.JPanel product2;
    private javax.swing.JPanel product3;
    private javax.swing.JPanel product4;
    private javax.swing.JPanel product_listPane;
    private javax.swing.JLabel product_name1;
    private javax.swing.JLabel product_name2;
    private javax.swing.JLabel product_name3;
    private javax.swing.JLabel product_name4;
    private javax.swing.JButton view_button1;
    private javax.swing.JButton view_button2;
    private javax.swing.JButton view_button3;
    private javax.swing.JButton view_button4;
    // End of variables declaration//GEN-END:variables
}
