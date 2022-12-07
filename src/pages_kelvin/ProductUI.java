package pages_kelvin;

import datebase_jon.Review;
import datebase_jon.ShopletSystemManager;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import javax.swing.border.Border;

import datebase_jon.Product;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * Product Panel UI CLass
 * @author Kelvin Dhoman
 *
 */
public class ProductUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Product UI constructor
	 * @param windowTitle The title of the product panel
	 * @param product The product the panel will be created for
	 */
	
    JPanel reviewsArea = new JPanel();
    Product product;

	public ProductUI(String windowTitle, Product product)
    {
        super(windowTitle);   
        this.product = product;
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowActivated(WindowEvent e) {
        		// Update cart text button when user focuses on window.
        		refreshUI();
        	}
        });
        
        this.setMinimumSize(new Dimension(1000, 650));
        this.setMaximumSize(new Dimension(1000, 650));
        this.setResizable(false);

        //Layout and Buttons
        getContentPane().setLayout(new MigLayout("wrap", "[793.00,grow][::100px,grow]", "[73.00][67.00][177.00][27.00][grow,fill][]"));
        
        JLabel lblProductName = new JLabel(product.name);
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
        txtProductDescription.setText(product.description);
        getContentPane().add(txtProductDescription, "cell 0 2,growx,gapright 100,aligny top");
        
        JLabel lblReviewText = new JLabel("Reviews");
        getContentPane().add(lblReviewText, "cell 0 3");
        
        JButton btnLeaveAReview = new JButton("Review");
        btnLeaveAReview.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ReviewUI reviewUI = new ReviewUI("Product - " + product.name + " - Review", product);
        		reviewUI.setVisible(true);
        	}
        });
        getContentPane().add(btnLeaveAReview, "cell 1 3,alignx right");
              
        /**
        JLabel lblNewLabel = new JLabel("No reviews currently...");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        getContentPane().add(lblNewLabel, "cell 0 4,alignx center,aligny center");
        **/
        
        //Reviews
        List<Review> productReviews = ShopletSystemManager.getInstance().grab_reviews(product.product_id);
        
        for (int i = 0; i < productReviews.size(); i++)
        {
        	reviewsArea.add(addReview(productReviews.get(i).review_id, productReviews.get(i).user_id
            		,productReviews.get(i).product_id, productReviews.get(i).reviewer_name, productReviews.get(i).review_rating
            		, productReviews.get(i).review_content), "span, growx");
        }
        
        getContentPane().add(reviewsArea, "cell 0 4 2 2");
        reviewsArea.setLayout(new BoxLayout(reviewsArea, BoxLayout.Y_AXIS));
    }
	
	/**
	 * Refreshes UI elements of the window
	 */
	void refreshUI()
	{
		reviewsArea.removeAll();
		
		 //Reviews
        List<Review> productReviews = ShopletSystemManager.getInstance().grab_reviews(product.product_id);
        
        for (int i = 0; i < productReviews.size(); i++)
        {
        	reviewsArea.add(addReview(productReviews.get(i).review_id, productReviews.get(i).user_id
            		,productReviews.get(i).product_id, productReviews.get(i).reviewer_name, productReviews.get(i).review_rating
            		, productReviews.get(i).review_content), "span, growx");
        }
		
		reviewsArea.revalidate();
		reviewsArea.repaint();	
	}
	
	/**
	 * Creates each review element for the product
	 * @param review_id The review id
	 * @param product_id The product id
	 * @param reviewerName the reviewer's name
	 * @param review_rating the review's rating
	 * @param review_content the review's content
	 * @return A review panel UI element
	 */
	public JPanel addReview(Integer review_id, Integer user_id, Integer product_id, String review_name, String review_rating, String review_content)
    {
    	Review review = new Review(review_id, user_id, product_id, review_name, review_rating, review_content);
    	
        // Convert price to 2 decimal places
        Border border = BorderFactory.createLineBorder(Color.black);

        // Build product entry
        JPanel reviewPanel = new JPanel(new MigLayout("", "[][]push[][]15", "[]"));
        reviewPanel.setPreferredSize(new Dimension(1000, 60));
        reviewPanel.setMaximumSize(new Dimension(1000, 60));
        reviewPanel.setBackground(Color.white);
        
        JLabel reviewerLabel = new JLabel(review.reviewer_name);
        reviewerLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        reviewerLabel.setMaximumSize(new Dimension(200, 100));
        reviewPanel.add(reviewerLabel);
        
        reviewPanel.add(new JLabel(" Rating: " + review_rating)).setFont(new Font("Arial", Font.PLAIN, 16));
        reviewPanel.add(new JLabel(review_content)).setFont(new Font("Arial", Font.PLAIN, 16));
        

        reviewPanel.setBorder(border);

        // Return the product panel
        return reviewPanel;
    }

	/**
	 * Main
	 * @param args
	 */
    public static void main(String[] args) {
    	Product dummy = new Product(1, "Dummy", 0, "Dummy", true, 1, false);
        JFrame frame = new ProductUI("Shoplet - Product", dummy);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
