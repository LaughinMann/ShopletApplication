package pages;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductUI(String windowTitle, Product product)
    {
        super(windowTitle);
        this.setMinimumSize(new Dimension(1000, 650));
        this.setMaximumSize(new Dimension(1000, 650));
        this.setResizable(false);

        //Layout and Buttons
        getContentPane().setLayout(new MigLayout("wrap", "[793.00,grow][::100px,grow]", "[73.00][67.00][177.00][27.00][grow,fill]"));
        
        JLabel lblProductName = new JLabel(product.productName);
        lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblProductName, "cell 0 0");
        
        JButton btnAddToCart = new JButton("Add To Cart");
        btnAddToCart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cart.getInstance().addProduct(product);
        		JOptionPane.showMessageDialog(null, "Item added to cart.", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        btnAddToCart.setPreferredSize(new Dimension(100, 100));
        getContentPane().add(btnAddToCart, "cell 1 0,alignx center,aligny center");
        
        JLabel lblProductPrice = new JLabel("Price: " + product.getProductPrice());
        getContentPane().add(lblProductPrice, "cell 0 1");
        
        JTextArea txtProductDescription = new JTextArea();
        txtProductDescription.setWrapStyleWord(true);
        txtProductDescription.setEditable(false);
        txtProductDescription.setLineWrap(true);
        txtProductDescription.setBackground(null);
        txtProductDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\r\n");
        getContentPane().add(txtProductDescription, "cell 0 2,growx,gapright 100,aligny top");
        
        JLabel lblReviewText = new JLabel("Reviews");
        getContentPane().add(lblReviewText, "cell 0 3");
        
        JButton btnLeaveAReview = new JButton("Review");
        btnLeaveAReview.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ReviewUI reviewUI = new ReviewUI("Product - " + product.productName + " - Review");
        		reviewUI.setVisible(true);
        	}
        });
        getContentPane().add(btnLeaveAReview, "cell 1 3,alignx right");
        
        JLabel lblNewLabel = new JLabel("No reviews currently...");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        getContentPane().add(lblNewLabel, "cell 0 4,alignx center,aligny center");
    }

    public static void main(String[] args) {
    	Product dummy = new Product(1, "Dummy", 00.00, "Dummy", true, 1, false);
        JFrame frame = new ProductUI("Shoplet - Product", dummy);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
