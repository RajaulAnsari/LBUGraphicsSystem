package razaul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBackground(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLbuGraphicsFinal = new JLabel("LBU Graphics Final Project");
		lblLbuGraphicsFinal.setForeground(Color.WHITE);
		lblLbuGraphicsFinal.setFont(new Font("Nimbus Roman", Font.BOLD, 24));
		lblLbuGraphicsFinal.setBackground(Color.BLACK);
		lblLbuGraphicsFinal.setBounds(281, 14, 316, 30);
		contentPane.add(lblLbuGraphicsFinal);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Main.class.getResource("/razaul/logoLbu1.png")));
		Logo.setForeground(Color.BLACK);
		Logo.setBackground(Color.BLACK);
		Logo.setBounds(57, 0, 200, 353);
		contentPane.add(Logo);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(298, 110, 106, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(298, 172, 106, 23);
		contentPane.add(lblPassword);
		
		JFormattedTextField EnterUsername = new JFormattedTextField();
		EnterUsername.setForeground(Color.BLACK);
		EnterUsername.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		EnterUsername.setBounds(517, 105, 139, 30);
		contentPane.add(EnterUsername);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = EnterUsername.getText();
                @SuppressWarnings("deprecation")
				String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select user_name, password from account where user_name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHomePage ah = new UserHomePage();
                        ah.setTitle(userName);
                        ah.setVisible(true);
                        contentPane.setVisible(false);
                        JOptionPane.showMessageDialog(btnLogin, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnLogin, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateNewAccount createnew = new CreateNewAccount();
				contentPane.setVisible(false);
				createnew.setVisible(true);
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(517, 167, 139, 28);
		contentPane.add(passwordField);
		
		btnCreateNewAccount.setForeground(Color.WHITE);
		btnCreateNewAccount.setFont(new Font("Nimbus Roman", Font.BOLD, 14));
		btnCreateNewAccount.setBackground(Color.BLACK);
		btnCreateNewAccount.setBounds(281, 260, 158, 25);
		contentPane.add(btnCreateNewAccount);
		
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Nimbus Roman", Font.BOLD, 14));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(565, 260, 91, 25);
		contentPane.add(btnLogin);
	}
}
