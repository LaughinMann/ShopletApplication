package pages_kelvin;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class for the Profile UI edit window
 * @author Kelvin Dhoman
 *
 */
public class ProfileUI extends JFrame {

    private JLabel lblUsername = new JLabel("Username:");
    private JLabel lblPassword = new JLabel("Password:");
    private JLabel lblEmail = new JLabel("Email:");
    private JLabel lblFirstName = new JLabel("First Name:");
    private JLabel lblLastName = new JLabel("Last Name");
    private JLabel lblStreetAddress = new JLabel("Street Address:");
    private JLabel lblCity = new JLabel("City:");
    private JLabel lblState = new JLabel("State:");
    private JLabel lblZipcode = new JLabel("Zipcode:");
    private JLabel lblPhoneNumber = new JLabel("Phone Number:");

    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword  = new JPasswordField();
    private JTextField txtEmail  = new JTextField();
    private JTextField txtFirstName  = new JTextField();
    private JTextField txtLastName  = new JTextField();
    private JTextField txtStreetAddress  = new JTextField();
    private JTextField txtCity  = new JTextField();
    private JTextField txtZipCode  = new JTextField();
    private JTextField txtPhoneNumber  = new JTextField();
    private JComboBox stateComboBox = new JComboBox(StatesList.States);

    public JButton btnUpdateAccount = new JButton("Update Account");

    /**
     * Profile UI constructor
     * @param windowTitle The window title.
     */
    public ProfileUI(String windowTitle)
    {
        super(windowTitle);
        this.setMinimumSize(new Dimension(350, 340));
        this.setMaximumSize(new Dimension(350, 340));
        this.setResizable(false);

        getContentPane().setLayout(new MigLayout("", "[][]", "[]"));

        getContentPane().add(lblUsername, "cell 0 1");
        getContentPane().add(lblPassword, "cell 0 2");
        getContentPane().add(lblEmail, "cell 0 3");
        getContentPane().add(lblFirstName, "cell 0 4");
        getContentPane().add(lblLastName, "cell 0 5");
        getContentPane().add(lblStreetAddress, "cell 0 6");
        getContentPane().add(lblCity, "cell 0 7");
        getContentPane().add(lblState, "cell 0 8");
        getContentPane().add(lblZipcode, "cell 0 9");
        getContentPane().add(lblPhoneNumber, "cell 0 10");

        getContentPane().add(txtUsername, "cell 1 1");
        txtUsername.setColumns(25);

        getContentPane().add(txtPassword, "cell 1 2");
        txtPassword.setColumns(25);

        getContentPane().add(txtEmail, "cell 1 3");
        txtEmail.setColumns(25);

        getContentPane().add(txtFirstName, "cell 1 4");
        txtFirstName.setColumns(25);

        getContentPane().add(txtLastName, "cell 1 5");
        txtLastName.setColumns(25);

        getContentPane().add(txtStreetAddress, "cell 1 6");
        txtStreetAddress.setColumns(25);

        getContentPane().add(txtCity, "cell 1 7");
        txtCity.setColumns(25);
        
        getContentPane().add(stateComboBox, "cell 1 8");

        getContentPane().add(txtZipCode, "cell 1 9");
        txtZipCode.setColumns(25);
        
        getContentPane().add(txtPhoneNumber, "cell 1 10");
        txtPhoneNumber.setColumns(25);

        btnUpdateAccount.setPreferredSize(new Dimension(278, btnUpdateAccount.getHeight()));
        getContentPane().add(btnUpdateAccount, "cell 1 11");
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new ProfileUI("Shoplet - Profile");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
