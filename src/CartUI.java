import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CartUI extends JFrame {
    private JButton btnCheckout;
    private JPanel productsArea;
    private JPanel pricingArea;

    public CartUI(String windowTitle)
    {
        super(windowTitle);

        this.setMinimumSize(new Dimension(750, 450));
        this.setMaximumSize(new Dimension(1000, 450));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Layout and Buttons
        this.setLayout(new MigLayout("wrap, debug", "[]","[]"));

        productsArea = new JPanel(new MigLayout("wrap", "[]","[]"));
        pricingArea = new JPanel(new MigLayout("wrap", "[]","[]"));

        btnCheckout = new JButton("Checkout");
        btnCheckout.setPreferredSize(new Dimension(350, 100));


        JLabel lblTotalPrice = new JLabel("Price: " + "$51.43");
        lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 32));
        JLabel lblTax = new JLabel("Tax: " + "$51.43");
        lblTax.setFont(new Font("Arial", Font.PLAIN, 32));
        JLabel lblTotalCost = new JLabel("Total Cost: " + "$51.43");
        lblTotalCost.setFont(new Font("Arial", Font.PLAIN, 32));

        pricingArea.add(lblTotalPrice, "gaptop 1");
        pricingArea.add(lblTax);
        pricingArea.add(lblTotalCost, "gaptop 300");

        /** PRODUCTS DEMO **/
        productsArea.add(ProductItem("Test", 45), "span");
        productsArea.add(ProductItem("Test", 45), "span");
        productsArea.add(ProductItem("Test", 45), "span");
        productsArea.add(ProductItem("Test", 45), "span");
        productsArea.add(ProductItem("Test", 45), "span");
        productsArea.add(ProductItem("Test", 45), "span");


        add(productsArea);
        add(pricingArea, "pos 550 0, width 350");
        add(btnCheckout, "pos 550 450");
    }

    public JPanel ProductItem(String productName, double productPrice)
    {
        // Convert price to 2 decimal places
        String priceDecimals = String.format("%.2f", productPrice);
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel newProductPanel = new JPanel(new MigLayout("", "push[][]295[]push", "[]"));
        newProductPanel.add(new JLabel(productName)).setFont(new Font("Arial", Font.PLAIN, 32));
        newProductPanel.add(new JLabel("Cost: $" + priceDecimals)).setFont(new Font("Arial", Font.PLAIN, 16));
        newProductPanel.add(new JButton("X")).setPreferredSize(new Dimension(65, 65));
        newProductPanel.setBorder(border);

        // Return the product panel
        return newProductPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new CartUI("Products - Cart");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
