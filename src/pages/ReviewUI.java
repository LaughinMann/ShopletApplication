package pages;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReviewUI extends JFrame {

    private JLabel lblUsername = new JLabel("Review (1-5 Stars):");
    private JLabel lblPassword = new JLabel("Review Text:");

    private JTextField txtReviewStars = new JTextField();

    public JButton btnUpdateAccount = new JButton("Post");
    private final JTextArea textArea = new JTextArea();

    public ReviewUI(String windowTitle)
    {
        super(windowTitle);
        this.setMinimumSize(new Dimension(350, 340));
        this.setMaximumSize(new Dimension(350, 340));
        this.setResizable(false);

        getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][grow][][]"));

        getContentPane().add(lblUsername, "cell 0 1");
        getContentPane().add(lblPassword, "cell 0 2");

        getContentPane().add(txtReviewStars, "cell 1 1");
        txtReviewStars.setColumns(25);
        textArea.setLineWrap(true);
        
        getContentPane().add(textArea, "cell 1 2,grow");

        btnUpdateAccount.setPreferredSize(new Dimension(278, btnUpdateAccount.getHeight()));
        getContentPane().add(btnUpdateAccount, "cell 1 11");
    }

    public static void main(String[] args) {
        JFrame frame = new ReviewUI("Shoplet - Review");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
