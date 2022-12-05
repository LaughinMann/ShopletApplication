package pages_jarold;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		setBounds(100, 100, 631, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user_label = new JLabel("Username:");
		user_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user_label.setBackground(SystemColor.info);
		user_label.setBounds(144, 218, 106, 33);
		contentPane.add(user_label);
		
		JLabel password_label = new JLabel("Password :");
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password_label.setBounds(144, 269, 106, 27);
		contentPane.add(password_label);
		
		JLabel logo_label = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		logo_label.setIcon(new ImageIcon(img1));
		
		
		logo_label.setBounds(155, 11, 275, 210);
		contentPane.add(logo_label);
		
		user_box = new JTextField();
		user_box.setBounds(260, 228, 126, 20);
		contentPane.add(user_box);
		user_box.setColumns(10);
		
		password_box = new JPasswordField();
		password_box.setBounds(260, 276, 126, 20);
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
				
				database login = new database();
				if(login.authenticate_user(user_box.getText(), String.valueOf(password_box.getPassword()))) {
					HomePage home = new HomePage();
					home.setVisible(true);
					dispose();
					
				}else {
					FailedLoginPrompt prompt = new FailedLoginPrompt();
					prompt.setVisible(true);
				}
			}
		});
		login_button.setBounds(260, 326, 126, 20);
		contentPane.add(login_button);
	}
}
