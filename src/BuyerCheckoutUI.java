import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BuyerCheckoutUI extends JFrame {

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
    private JLabel lblTotalPrice = new JLabel("Total: ");


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

    // Add cart parameter
    public BuyerCheckoutUI(String windowTitle)
    {
        super(windowTitle);

        this.setMinimumSize(new Dimension(350, 410));
        this.setMaximumSize(new Dimension(350, 410));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new MigLayout("", "[][]", "[]"));

        add(lblFirstName, "cell 0 1");
        add(lblLastName, "cell 0 2");
        add(lblStreetAddress, "cell 0 3");
        add(lblCity, "cell 0 4");
        add(lblState, "cell 0 5");
        add(lblZipcode, "cell 0 6");
        add(lblPhoneNumber, "cell 0 7");
        add(lblCreditCard, "cell 0 8");
        add(lblCVV, "cell 0 9");
        add(lblExpirationDate, "cell 0 10");

        add(txtFirstName, "cell 1 1");
        txtFirstName.setColumns(25);

        add(txtLastName, "cell 1 2");
        txtLastName.setColumns(25);

        add(txtStreetAddress, "cell 1 3");
        txtStreetAddress.setColumns(25);

        add(txtCity, "cell 1 4");
        txtCity.setColumns(25);

        add(stateComboBox, "cell 1 5");

        add(txtZipcode, "cell 1 6");
        txtZipcode.setColumns(25);

        add(txtPhoneNumber, "cell 1 7");
        txtPhoneNumber.setColumns(25);

        add(txtCreditCard, "cell 1 8");
        txtCreditCard.setColumns(25);

        add(txtCVV, "cell 1 9");
        txtCVV.setColumns(25);

        add(txtExpirationDate, "cell 1 10");
        txtExpirationDate.setColumns(25);

        lblTotalPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 26));
        lblTotalPrice.setPreferredSize(new Dimension(278, lblTotalPrice.getHeight()));
        add(lblTotalPrice, "cell 1 11");

        btnCancel.setPreferredSize(new Dimension(125, btnCancel.getHeight()));
        add(btnCancel, "cell 1 12");
        btnConfirmOrder.setPreferredSize(new Dimension(145, btnConfirmOrder.getHeight()));
        add(btnConfirmOrder, "cell 1 12");
    }

    public static void main(String[] args) {
        JFrame frame = new BuyerCheckoutUI("Shoplet - Checkout");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
