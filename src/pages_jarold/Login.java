package pages_jarold;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datebase_jon.Admin;
import datebase_jon.Seller;
import datebase_jon.ShopletSystemManager;
import datebase_jon.User;
import pages_Jeff_Admin.AdminPanelUI;
import pages_Jeff_Seller.SellersPanelUI;
import pages_kelvin.BuyerCatalogUI;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3909207244919035906L;
	private JPanel contentPane;
	private JTextField user_box;
	private JPasswordField password_box;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Shoplet - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user_label = new JLabel("Email:");
		user_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user_label.setBackground(SystemColor.info);
		user_label.setBounds(111, 218, 106, 33);
		contentPane.add(user_label);
		
		JLabel password_label = new JLabel("Password :");
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password_label.setBounds(111, 269, 106, 27);
		contentPane.add(password_label);
		
		JLabel logo_label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		logo_label.setIcon(new ImageIcon(img1));
		
		
		logo_label.setBounds(122, 11, 275, 210);
		contentPane.add(logo_label);
		
		user_box = new JTextField();
		user_box.setBounds(227, 228, 201, 20);
		contentPane.add(user_box);
		user_box.setColumns(10);
		
		password_box = new JPasswordField();
		password_box.setBounds(227, 276, 201, 20);
		contentPane.add(password_box);
		
		JButton register_button = new JButton("Register");
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registration register = new Registration();
				register.setVisible(true);
				dispose();
			}
		});
		register_button.setBounds(260, 376, 126, 19);
		contentPane.add(register_button);
		
		JLabel desc_box = new JLabel("Don't have an account?");
		desc_box.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desc_box.setBounds(119, 376, 131, 14);
		contentPane.add(desc_box);
		
		JButton login_button = new JButton("Login");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShopletSystemManager db = ShopletSystemManager.getInstance();
				
				User user = db.authenticate_user(user_box.getText(), String.valueOf(password_box.getPassword()));		
				
				if (user.firstname != null)
				{
					if (user.account_type.equals("seller") && user.approval == true)
					{
						hideLogin();
						SellersPanelUI sellerPanel = new SellersPanelUI();
						sellerPanel.setVisible(true);
					} 
					else if (user.account_type.equals("seller") && user.approval == false) 
					{
		        		JOptionPane.showMessageDialog(null, "Seller account pending approval. Try again later.", "Shoplet", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					if (user.account_type.equals("buyer"))
					{
						hideLogin();
						BuyerCatalogUI buyerCatalog = new BuyerCatalogUI("Buyers Catalog - Logged in as " + user.firstname + " " + user.lastname);
						buyerCatalog.setVisible(true);
					}
					
					if (user.account_type.equals("admin"))
					{
						hideLogin();
						AdminPanelUI adminPanel = new AdminPanelUI();
						adminPanel.setVisible(true);
					}
				}
				else
				{								
	        		JOptionPane.showMessageDialog(null, "User not found or incorrect Username or Password.", "Shoplet", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		login_button.setBounds(260, 326, 126, 20);
		contentPane.add(login_button);
	}
	
	public void hideLogin()
	{
		this.setVisible(false);
	}
}
