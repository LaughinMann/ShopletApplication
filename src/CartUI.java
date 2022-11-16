import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CartUI extends JFrame {
    private JButton btnCheckout;
    private JPanel productsArea;
    private JPanel pricingArea;
    public BuyerCheckoutUI checkout = null;
    public CartUI cart = null;

    public CartUI(String windowTitle)
    {
        super(windowTitle);
        cart = this;
        this.setMinimumSize(new Dimension(930, 570));
        this.setMaximumSize(new Dimension(930, 570));
        this.setResizable(false);

        //Layout and Buttons
        getContentPane().setLayout(new MigLayout("wrap", "[]", "[]"));

        productsArea = new JPanel(new MigLayout("wrap, debug", "[push]", "[]"));
        pricingArea = new JPanel(new MigLayout("wrap, debug", "[]",""));
        btnCheckout = new JButton("Checkout");
        btnCheckout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (checkout == null)
        		{
	        		checkout = new BuyerCheckoutUI("Shoplet - Checkout", cart);
	        		checkout.setVisible(true);
        		}
        	}
        });
        btnCheckout.setPreferredSize(new Dimension(350, 100));


        JLabel lblTotalPrice = new JLabel("Price: " + "$51.43");
        lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 32));
        JLabel lblTax = new JLabel("Tax: " + "$51.43");
        lblTax.setFont(new Font("Arial", Font.PLAIN, 32));
        JLabel lblTotalCost = new JLabel("Total Cost: " + "$51.43");
        lblTotalCost.setFont(new Font("Arial", Font.PLAIN, 32));

        pricingArea.add(lblTotalPrice, "gaptop 1");
        pricingArea.add(lblTax);
        pricingArea.add(lblTotalCost, "gaptop 275");

        /** PRODUCTS DEMO **/
        for (int i = 0; i < Cart.getInstance().getProductInCartCount(); i++)
        {
        	productsArea.add(ProductItem(Cart.getInstance().itemsInCart.get(i).productName, Cart.getInstance().itemsInCart.get(i).productPrice), "span");
        }
        
        //Products Debug
        productsArea.add(ProductItem("Pants", 12), "growx"); 
        productsArea.add(ProductItem("Test1Test1Test1", 4), "growx");
        productsArea.add(ProductItem("Shirt", 65), "growx");
        productsArea.add(ProductItem("Test1Test1Test1Test1Test1Test1Test1Test1Test1Test1Test1Test1", 542), "growx");
        
        getContentPane().add(productsArea, "cell 0 0");
        getContentPane().add(pricingArea, "pos 550 0,cell 0 1,width 350");
        getContentPane().add(btnCheckout, "pos 550 418.5,cell 0 1");
    }

    /**
     * Creates new Product item entry.
     * @param productName The name of the product.
     * @param productPrice The price of the product.
     * @return returns a product JPanel to be inserted into another JPanel.
     */
    public JPanel ProductItem(String productName, double productPrice)
    {
        // Convert price to 2 decimal places
        String priceDecimals = String.format("%.2f", productPrice);
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel newProductPanel = new JPanel(new MigLayout("wrap, debug", "[]10[grow]140[grow]", "[]"));
        
        // Product Label
        JLabel lblProductName = new JLabel(productName);
        lblProductName.setFont(new Font("Arial", Font.PLAIN, 32));
        lblProductName.setMaximumSize(new Dimension(200, 100));

        // Product Name
        newProductPanel.add(lblProductName, "");
        newProductPanel.add(new JLabel("Cost: $" + priceDecimals)).setFont(new Font("Arial", Font.PLAIN, 16));
        
        // Product Delete Button
        JButton btnDeleteProductFromCart = new JButton("X");
        btnDeleteProductFromCart.setPreferredSize(new Dimension(65, 65));
        newProductPanel.add(btnDeleteProductFromCart, "dock east");
        
        // Black border
        newProductPanel.setBorder(border);

        // Return the product panel
        return newProductPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new CartUI("Shoplet - Cart");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
