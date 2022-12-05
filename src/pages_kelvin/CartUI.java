package pages_kelvin;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class for Cart UI that contains all the products the user has in the cart.
 * @author Kelvin Dhoman
 *
 */
public class CartUI extends JFrame {
    private JButton btnCheckout;
    private JPanel productsArea;
    private JPanel pricingArea;
    public BuyerCheckoutUI checkout = null;
    public CartUI cart = null;
    JLabel lblTotalCost = null;
    JLabel lblTax = null;
    JLabel lblTotalPrice = null;
    private JLabel lblEmptyCart;

    /**
     * Constructor for the Cart UI
     * @param windowTitle The name of the window title.
     */
    public CartUI(String windowTitle)
    {
        super(windowTitle);
        cart = this;
        this.setMinimumSize(new Dimension(930, 570));
        this.setMaximumSize(new Dimension(930, 570));
        this.setResizable(false);

        //Layout and Buttons
        getContentPane().setLayout(new MigLayout("wrap", "[][][][][][][][][][]", "[][][][][][][][][][][]"));

        productsArea = new JPanel(new MigLayout("wrap", "[push]", "[]"));
        pricingArea = new JPanel(new MigLayout("wrap", "[]",""));
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


        lblTotalPrice = new JLabel("Price: $" + Cart.getInstance().calculatePreTaxTotal());
        lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 32));
        lblTax = new JLabel("Tax: $" + Cart.getInstance().calculateTaxTotal());
        lblTax.setFont(new Font("Arial", Font.PLAIN, 32));
        lblTotalCost = new JLabel("Total Cost: $" + Cart.getInstance().calculateGrandTotal());
        lblTotalCost.setFont(new Font("Arial", Font.PLAIN, 32));

        pricingArea.add(lblTotalPrice, "gaptop 1");
        pricingArea.add(lblTax);
        pricingArea.add(lblTotalCost, "gaptop 275");

        /** PRODUCTS DEMO **/
        for (int i = 0; i < Cart.getInstance().getCartSize(); i++)
        {
        	productsArea.add(ProductItem(Cart.getInstance().itemsInCart.get(i).productName, Cart.getInstance().itemsInCart.get(i).productPrice), "span");
        }
        
        //Products
        
        // Reset products panel
    	productsArea.removeAll();
    	this.revalidate();
    	this.repaint();
    	pack();
    	
    	// Load all the products from cart 
        for (int i = 0; i < Cart.getInstance().getCartSize(); i++)
        {
        	if (Cart.getInstance().getCartSize() == 0)
        		return;
        	
            productsArea.add(ProductItem(Cart.getInstance().itemsInCart.get(i).productName, Cart.getInstance().itemsInCart.get(i).getProductPrice()), "growx");     
        }
        
        getContentPane().add(productsArea, "cell 0 0");
        getContentPane().add(pricingArea, "pos 550 0,cell 0 0,width 350");
        getContentPane().add(btnCheckout, "pos 550 418.5,cell 0 0");
        
        lblEmptyCart = new JLabel("Cart is currently empty...");
        lblEmptyCart.setFont(new Font("Tahoma", Font.PLAIN, 38));
        getContentPane().add(lblEmptyCart, "cell 1 1");
        
        if (Cart.getInstance().getCartSize() == 0)
        {
	        lblEmptyCart.setVisible(true);
        }
        else
        {
	        lblEmptyCart.setVisible(false);
        }
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
        JPanel newProductPanel = new JPanel(new MigLayout("wrap", "[]10[grow]140[grow]", "[]"));
        
        // Product Label
        JLabel lblProductName = new JLabel(productName);
        lblProductName.setFont(new Font("Arial", Font.PLAIN, 32));
        lblProductName.setMaximumSize(new Dimension(200, 100));

        // Product Name
        newProductPanel.add(lblProductName, "");
        newProductPanel.add(new JLabel("Cost: $" + priceDecimals)).setFont(new Font("Arial", Font.PLAIN, 16));
        
        // Product Delete Button
        JButton btnDeleteProductFromCart = new JButton("X");
        btnDeleteProductFromCart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		removeItemFromCart(productName ,newProductPanel);
        	}
        });
        btnDeleteProductFromCart.setPreferredSize(new Dimension(65, 65));
        newProductPanel.add(btnDeleteProductFromCart, "dock east");
        
        // Black border
        newProductPanel.setBorder(border);

        // Return the product panel
        return newProductPanel;
    }
    
    /**
     * Removes a product from the cart.
     * @param productToDelete The product name to remove from the cart.
     * @param panel The JPanel that the product is associated with.
     */
    public void removeItemFromCart(String productToDelete, JPanel panel)
    {
    	// Remove from Cart
    	Cart.getInstance().removeProductFromCart(productToDelete);
    	productsArea.remove(panel);
    	
    	// Update UI
    	lblTotalCost.setText("Total Cost: $" + Cart.getInstance().calculateGrandTotal());
        lblTax.setText("Tax: $" + Cart.getInstance().calculateTaxTotal());
        lblTotalPrice.setText("Price: $" + Cart.getInstance().calculatePreTaxTotal());
    	
		JOptionPane.showMessageDialog(null, "Item removed from cart.", "Shoplet", JOptionPane.ERROR_MESSAGE);
        
		 if (Cart.getInstance().getCartSize() == 0)
        {
	        lblEmptyCart.setVisible(true);
        }
        else
        {
	        lblEmptyCart.setVisible(false);
        }
		
    	this.revalidate();
    	this.repaint();
    	pack();
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new CartUI("Shoplet - Cart");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
