package pages_kelvin;
import datebase_jon.Product;
import datebase_jon.ShopletSystemManager;
import net.miginfocom.swing.MigLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class for the Buyer Catalog UI to display to the user.
 * @author Kelvin Dhoman
 *
 */
public class BuyerCatalogUI extends JFrame {
	
    private JButton catalogBtn;
    private JButton profileBtn;
    private JButton viewCartBtn;
    
    /**
     * Default constructor for the Buyer Catalog UI
     * @param windowTitle The title for the window.
     */
    public BuyerCatalogUI(String windowTitle)
    {
        super(windowTitle);
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowActivated(WindowEvent e) {
        		// Update cart text button when user focuses on window.
        		updateViewCartUI();
        	}
        });
        
        this.setMinimumSize(new Dimension(1000, 700));
        this.setMaximumSize(new Dimension(1000, 700));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Layout and Buttons
        getContentPane().setLayout(new MigLayout("wrap", "[][]push[]","[][][]"));
        catalogBtn = new JButton("Catalog");
        profileBtn = new JButton("Profile");
        profileBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProfileUI profileUI = new ProfileUI("Shoplet - Profile");
        		profileUI.setVisible(true);
        	}
        });
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
        List<Product> products = ShopletSystemManager.getInstance().get_list_of_products();
        for (int i = 0; i < products.size(); i++)
        {
            getContentPane().add(ProductItem(products.get(i).product_id, products.get(i).name, products.get(i).price, products.get(i).description), "span, growx");
        }
    }

    /**
     * The JPanel object that represents a product item entry in the product catalog.
     * @param productName The name of the product to show
     * @param productPrice The price of the product to show
     * @return
     */
    public JPanel ProductItem(Integer productId, String productName, Integer productPrice, String productDescription)
    {
    	Product product = new Product(productId, productName, productPrice, productDescription, true, 1, false);

        // Convert price to 2 decimal places
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel newProductPanel = new JPanel(new MigLayout("", "[][]push[][]15", "[]"));
        JLabel productLabel = new JLabel(productName);
        productLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        productLabel.setMaximumSize(new Dimension(200, 100));
        
        newProductPanel.add(productLabel);
        newProductPanel.add(new JLabel("Cost: $" + productPrice)).setFont(new Font("Arial", Font.PLAIN, 16));
        
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
    
    /**
     * Updates the view cart button text to represent the current number of products in the cart.
     */
    public void updateViewCartUI()
    {
    	viewCartBtn.setText("["+Cart.getInstance().getCartSize()+"]" + " View Cart");
    }

    /**
     * Main constructor
     * @param args Arguments to be supplied.
     */
    public static void main(String[] args) {
        JFrame frame = new BuyerCatalogUI("Products - Catalog");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
