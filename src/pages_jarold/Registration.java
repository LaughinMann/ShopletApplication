package pages_jarold;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datebase_jon.ShopletSystemManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JPasswordField password2_box;
	private JPasswordField password_box;
	private JTextField inputFirstName;
	private JTextField email_box;
	private JTextField inputLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setTitle("Shoplet - Registration");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel registration_desc = new JLabel("Create a Shoplet account");
		registration_desc.setBounds(184, 36, 231, 42);
		registration_desc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(registration_desc);
		
		JLabel logo_label = new JLabel("");
		logo_label.setBounds(10, 11, 148, 144);
		contentPane.add(logo_label);
		Image logo = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		Image scaledImage = logo.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		logo_label.setIcon(new ImageIcon(scaledImage));
		
		JLabel account_label = new JLabel("Account type :");
		account_label.setBounds(48, 166, 128, 28);
		account_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(account_label);
		
		JComboBox account_box = new JComboBox();
		account_box.setModel(new DefaultComboBoxModel(new String[] {"Buyer", "Seller"}));
		account_box.setMaximumRowCount(2);
		account_box.setBounds(186, 171, 201, 22);
		contentPane.add(account_box);
		
		JLabel email_label = new JLabel("Email : ");
		email_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email_label.setBounds(48, 205, 128, 28);
		contentPane.add(email_label);
		
		JButton cancel_button = new JButton("Cancel");
		cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
				
			}
		});
		cancel_button.setBounds(297, 407, 89, 23);
		contentPane.add(cancel_button);
		
		JButton register_button = new JButton("Register");
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean match = false;
				
				if(String.valueOf(password_box.getPassword()) == String.valueOf(password_box.getPassword())) {
					match = true;
				}
				else {
					match = false;
				}					
				
				if ((String.valueOf(account_box.getSelectedItem()).equals("Seller")))
				{
					System.out.println("Test");
					ShopletSystemManager.getInstance().add_user(inputFirstName.getText(), inputLastName.getText(), email_box.getText(), String.valueOf(password_box.getPassword()), String.valueOf(account_box.getSelectedItem()), false);
				}
				else if ((String.valueOf(account_box.getSelectedItem()).equals("Buyer")))
				{
					System.out.println("Test1");
					ShopletSystemManager.getInstance().add_user(inputFirstName.getText(), inputLastName.getText(), email_box.getText(), String.valueOf(password_box.getPassword()), String.valueOf(account_box.getSelectedItem()), true);
				}
				//String firstname, String lastname, String email, String password, String account_type, Boolean approval
			}
		});
		register_button.setBounds(183, 407, 89, 23);
		contentPane.add(register_button);
		
		JLabel user_label = new JLabel("First Name:");
		user_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user_label.setBounds(48, 244, 128, 28);
		contentPane.add(user_label);
		
		JLabel pass_label = new JLabel("Password : ");
		pass_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass_label.setBounds(48, 318, 128, 28);
		contentPane.add(pass_label);
		
		JLabel confpass_label = new JLabel("Confirm password : ");
		confpass_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confpass_label.setBounds(51, 357, 148, 28);
		contentPane.add(confpass_label);
		
		password2_box = new JPasswordField();
		password2_box.setColumns(25);
		password2_box.setBounds(184, 363, 203, 20);
		contentPane.add(password2_box);
		
		password_box = new JPasswordField();
		password_box.setColumns(25);
		password_box.setBounds(184, 324, 203, 20);
		contentPane.add(password_box);
		
		inputFirstName = new JTextField();
		inputFirstName.setColumns(20);
		inputFirstName.setBounds(184, 250, 203, 20);
		contentPane.add(inputFirstName);
		
		email_box = new JTextField();
		email_box.setBounds(184, 211, 203, 20);
		contentPane.add(email_box);
		email_box.setColumns(30);
		
		JLabel user_label_1 = new JLabel("Last Name:");
		user_label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user_label_1.setBounds(48, 282, 128, 28);
		contentPane.add(user_label_1);
		
		inputLastName = new JTextField();
		inputLastName.setColumns(20);
		inputLastName.setBounds(184, 281, 203, 20);
		contentPane.add(inputLastName);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
