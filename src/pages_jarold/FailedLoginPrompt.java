package pages_jarold;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class FailedLoginPrompt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FailedLoginPrompt frame = new FailedLoginPrompt();
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
	public FailedLoginPrompt() {
		
		setBounds(100, 100, 392, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wrong username or password!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(115, 11, 251, 37);
		contentPane.add(lblNewLabel);
		
		JLabel logo_label = new JLabel("");
		logo_label.setBounds(29, 11, 50, 48);
		contentPane.add(logo_label);
		Image logo = new ImageIcon(this.getClass().getResource("x.png")).getImage();
		Image scaledImage = logo.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		logo_label.setIcon(new ImageIcon(scaledImage));
	}
}
