import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BuyerPortalUI extends JFrame {
    private JButton catalogBtn;
    private JButton profileBtn;
    private JButton viewCartBtn;
    public BuyerPortalUI(String windowTitle)
    {
        super(windowTitle);

        this.setMinimumSize(new Dimension(1000, 750));
        this.setMaximumSize(new Dimension(1000, 750));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Layout and Buttons
        this.setLayout(new MigLayout("wrap", "[][]push[]","[][][]"));
        catalogBtn = new JButton("Catalog");
        profileBtn = new JButton("Profile");
        viewCartBtn = new JButton("[0] View Cart");

        // Add to window
        add(catalogBtn);
        add(profileBtn);
        add(viewCartBtn);

        //Products
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
        add(ProductItem("Test", 45), "span");
    }

    public JPanel ProductItem(String productName, double productPrice)
    {
        // Convert price to 2 decimal places
        String priceDecimals = String.format("%.2f", productPrice);
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel newProductPanel = new JPanel(new MigLayout("", "15[]25[]850[][]15", "[]"));
        newProductPanel.add(new JLabel(productName)).setFont(new Font("Arial", Font.PLAIN, 32));
        newProductPanel.add(new JLabel("Cost: $" + priceDecimals)).setFont(new Font("Arial", Font.PLAIN, 16));
        newProductPanel.add(new JButton("View Product"));
        newProductPanel.add(new JButton("+"));
        newProductPanel.setBorder(border);

        // Return the product panel
        return newProductPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new BuyerPortalUI("Products - Catalog");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
