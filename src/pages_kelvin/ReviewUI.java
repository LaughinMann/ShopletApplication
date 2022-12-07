package pages_kelvin;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;

import datebase_jon.Product;
import datebase_jon.ShopletSystemManager;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Review UI class
 * @author Kelvin Dhoman
 *
 */
public class ReviewUI extends JFrame {

    private JLabel lblUsername = new JLabel("Review (1-5 Stars):");
    private JLabel lblPassword = new JLabel("Review Text:");

    public JButton btnPost = new JButton("Post");
    private final JTextArea textArea = new JTextArea();
    SpinnerModel sm = new SpinnerNumberModel(1, 1, 5, 1); //default value,lower bound,upper bound,increment by
    private final JSpinner txtReviewStars = new JSpinner(sm);

    /**
     * Review UI constructor
     * @param windowTitle The window title for the constructor.
     */
    public ReviewUI(String windowTitle, Product product)
    {
        super(windowTitle);
        this.setMinimumSize(new Dimension(350, 340));
        this.setMaximumSize(new Dimension(350, 340));
        this.setResizable(false);

        getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][grow][][]"));

        getContentPane().add(lblUsername, "cell 0 1");
        getContentPane().add(lblPassword, "cell 0 2");
        textArea.setLineWrap(true);
        
        getContentPane().add(textArea, "cell 1 2,grow");
        btnPost.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		if (textArea.getText().isEmpty())
        		{
            		JOptionPane.showMessageDialog(null, "One or more missing fields.", "Shoplet", JOptionPane.ERROR_MESSAGE);
        		}
        		else
        		{
        		ShopletSystemManager.getInstance().add_review(
        				ShopletSystemManager.getInstance().current_user_id, product.product_id
        				, ShopletSystemManager.getInstance().grab_user_info(ShopletSystemManager.getInstance().current_user_id).firstname + " " + ShopletSystemManager.getInstance().grab_user_info(ShopletSystemManager.getInstance().current_user_id).lastname.charAt(0)
        				, txtReviewStars.getValue().toString()
        				, textArea.getText());
        		
        		setVisible(false);
        		JOptionPane.showMessageDialog(null, "Review Successfully Posted", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        	
        });

        btnPost.setPreferredSize(new Dimension(278, btnPost.getHeight()));
        getContentPane().add(btnPost, "cell 1 11");
        
        getContentPane().add(txtReviewStars, "cell 1 1");
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new ReviewUI("Shoplet - Review", new Product());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
