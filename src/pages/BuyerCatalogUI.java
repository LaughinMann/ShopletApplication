package pages;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerCatalogUI extends JFrame {
	
    private JButton catalogBtn;
    private JButton profileBtn;
    private JButton viewCartBtn;
    
    public BuyerCatalogUI(String windowTitle)
    {
        super(windowTitle);

        this.setMinimumSize(new Dimension(1000, 700));
        this.setMaximumSize(new Dimension(1000, 700));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Layout and Buttons
        getContentPane().setLayout(new MigLayout("wrap", "[][]push[]","[][][]"));
        catalogBtn = new JButton("Catalog");
        profileBtn = new JButton("Profile");
        viewCartBtn = new JButton("[0] View Cart");
        viewCartBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CartUI cartUI = new CartUI("Shoplet Cart");
        		cartUI.setVisible(true);
        	}
        });

        // Add to window
        getContentPane().add(catalogBtn);
        getContentPane().add(profileBtn);
        getContentPane().add(viewCartBtn);

        //Products
        getContentPane().add(ProductItem("Pants", 12), "span, growx");
        getContentPane().add(ProductItem("Test1Test1Test1", 4), "span, growx");
        getContentPane().add(ProductItem("Shirt", 65), "span, growx");
        getContentPane().add(ProductItem("Test1Test1Test1Test1Test1Test1Test1Test1Test1Test1Test1Test1", 542), "span, growx");
    }

    public JPanel ProductItem(String productName, double productPrice)
    {
    	Product product = new Product(1, productName, productPrice, "Test", true, 1, false);
    	
        // Convert price to 2 decimal places
        String priceDecimals = String.format("%.2f", productPrice);
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel newProductPanel = new JPanel(new MigLayout("", "[][]push[][]15", "[]"));
        JLabel productLabel = new JLabel(productName);
        productLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        productLabel.setMaximumSize(new Dimension(200, 100));
        
        newProductPanel.add(productLabel);
        newProductPanel.add(new JLabel("Cost: $" + priceDecimals)).setFont(new Font("Arial", Font.PLAIN, 16));
        
        JButton viewProduct = new JButton("View Product");
        viewProduct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProductUI productPanel = new ProductUI("Shoplet Cart - " + productName, product);
        		productPanel.setVisible(true);
        	}
        });
        
        newProductPanel.add(viewProduct);
        JButton button = new JButton("+");
        
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cart.getInstance().addProduct(product);
        		updateViewCartUI();
        		JOptionPane.showMessageDialog(null, "Item added to cart.", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        
        newProductPanel.add(button);
        newProductPanel.setBorder(border);

        // Return the product panel
        return newProductPanel;
    }
    
    public void updateViewCartUI()
    {
    	viewCartBtn.setText("["+Cart.getInstance().getProductInCartCount()+"]" + " View Cart");
    }

    public static void main(String[] args) {
        JFrame frame = new BuyerCatalogUI("Products - Catalog");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
