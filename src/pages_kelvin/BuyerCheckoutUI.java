package pages_kelvin;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class to create a the checkout UI
 * @author Kelvin Dhoman
 *
 */
public class BuyerCheckoutUI extends JFrame {
	
	// Variables
    private JLabel lblFirstName = new JLabel("First Name:");
    private JLabel lblLastName = new JLabel("Last Name:");
    private JLabel lblStreetAddress = new JLabel("Street Address:");
    private JLabel lblCity = new JLabel("City:");
    private JLabel lblState = new JLabel("State:");
    private JLabel lblZipcode = new JLabel("Zip Code:");
    private JLabel lblPhoneNumber = new JLabel("Phone Number:");
    private JLabel lblCreditCard = new JLabel("Credit Card #:");
    private JLabel lblCVV = new JLabel("CVV:");
    private JLabel lblExpirationDate = new JLabel("Expiration Date:");
    private JLabel lblTotalPrice = new JLabel("Total: $" + Cart.getInstance().calculateGrandTotal());


    private JTextField txtFirstName = new JTextField();
    private JTextField txtLastName  = new JTextField();
    private JTextField txtStreetAddress  = new JTextField();
    private JTextField txtCity  = new JTextField();
    private JTextField txtZipcode  = new JTextField();
    private JTextField txtPhoneNumber  = new JTextField();
    private JTextField txtCreditCard  = new JTextField();
    private JTextField txtCVV  = new JTextField();
    private JTextField txtExpirationDate  = new JTextField();
    private JComboBox stateComboBox = new JComboBox(StatesList.States);

    public JButton btnCancel = new JButton("Cancel");
    public JButton btnConfirmOrder = new JButton("Confirm Order");

    /**
     * Constructor for the Buyer Checkout UI
     * @param windowTitle The name of the window
     * @param cartWindow The Cart UI reference to be based off of
     */
    public BuyerCheckoutUI(String windowTitle, CartUI cartWindow)
    { // TODO: Add cart parameter to retrieve cart info.
        super(windowTitle);
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		cartWindow.checkout = null;
        	}
        });
        this.setMinimumSize(new Dimension(350, 370));
        this.setMaximumSize(new Dimension(350, 370));
        this.setResizable(false);

        getContentPane().setLayout(new MigLayout("", "[][]", "[]"));

        getContentPane().add(lblFirstName, "cell 0 1");
        getContentPane().add(lblLastName, "cell 0 2");
        getContentPane().add(lblStreetAddress, "cell 0 3");
        getContentPane().add(lblCity, "cell 0 4");
        getContentPane().add(lblState, "cell 0 5");
        getContentPane().add(lblZipcode, "cell 0 6");
        getContentPane().add(lblPhoneNumber, "cell 0 7");
        getContentPane().add(lblCreditCard, "cell 0 8");
        getContentPane().add(lblCVV, "cell 0 9");
        getContentPane().add(lblExpirationDate, "cell 0 10");

        getContentPane().add(txtFirstName, "cell 1 1");
        txtFirstName.setColumns(25);

        getContentPane().add(txtLastName, "cell 1 2");
        txtLastName.setColumns(25);

        getContentPane().add(txtStreetAddress, "cell 1 3");
        txtStreetAddress.setColumns(25);

        getContentPane().add(txtCity, "cell 1 4");
        txtCity.setColumns(25);

        getContentPane().add(stateComboBox, "cell 1 5");

        getContentPane().add(txtZipcode, "cell 1 6");
        txtZipcode.setColumns(25);

        getContentPane().add(txtPhoneNumber, "cell 1 7");
        txtPhoneNumber.setColumns(25);

        getContentPane().add(txtCreditCard, "cell 1 8");
        txtCreditCard.setColumns(25);

        getContentPane().add(txtCVV, "cell 1 9");
        txtCVV.setColumns(25);

        getContentPane().add(txtExpirationDate, "cell 1 10");
        txtExpirationDate.setColumns(25);
        
        lblTotalPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 26));
        lblTotalPrice.setPreferredSize(new Dimension(278, lblTotalPrice.getHeight()));
        getContentPane().add(lblTotalPrice, "cell 1 11");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cancelCheckoutWindow();
        		JOptionPane.showMessageDialog(null, "Payment cancelled.", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
        		
        	}
        });

        btnCancel.setPreferredSize(new Dimension(125, btnCancel.getHeight()));
        getContentPane().add(btnCancel, "cell 1 12");
        btnConfirmOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Input verification
        	    txtFirstName.setInputVerifier(normalTextFieldVerifier);
        		cancelCheckoutWindow();
        		JOptionPane.showMessageDialog(null, "Payment confirmed.", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        btnConfirmOrder.setPreferredSize(new Dimension(145, btnConfirmOrder.getHeight()));
        getContentPane().add(btnConfirmOrder, "cell 1 12");
    }
    
    /**
     * Hides the Checkout Window
     */
    public void cancelCheckoutWindow()
    {
    	this.setVisible(false);
    }
    
    /**
     * Input Verifier for normal basic text fields that require just text.
     */
    InputVerifier normalTextFieldVerifier = new InputVerifier() {
		@Override
		public boolean verify(JComponent input) {
			// TODO Auto-generated method stub
			return false;
		}
    };

    /**
     * Main class for the Buyer Checkout UI
     * @param args Arguments
     */
    public static void main(String[] args) {
   	 	JFrame frame = new BuyerCheckoutUI("Shoplet - Checkout", new CartUI("Dummy"));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
