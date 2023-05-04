package razaul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField NewPasswordField;
	private JPasswordField OldPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setResizable(false);
		setBackground(Color.BLACK);
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
		lblLbuGraphicsFinal.setBounds(252, 14, 316, 30);
		contentPane.add(lblLbuGraphicsFinal);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(ChangePassword.class.getResource("/razaul/logoLbu1.png")));
		Logo.setForeground(Color.BLACK);
		Logo.setBackground(Color.BLACK);
		Logo.setBounds(28, 0, 200, 353);
		contentPane.add(Logo);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setForeground(Color.WHITE);
		lblEnterNewPassword.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		lblEnterNewPassword.setBackground(Color.BLACK);
		lblEnterNewPassword.setBounds(255, 183, 172, 20);
		contentPane.add(lblEnterNewPassword);
		
		OldPasswordField = new JPasswordField();
		OldPasswordField.setForeground(Color.BLACK);
		OldPasswordField.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		OldPasswordField.setEchoChar('*');
		OldPasswordField.setBackground(Color.WHITE);
		OldPasswordField.setBounds(502, 110, 147, 30);
		contentPane.add(OldPasswordField);
		
		JLabel lblEnterOldPassword = new JLabel("Enter Old Password");
		lblEnterOldPassword.setForeground(Color.WHITE);
		lblEnterOldPassword.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		lblEnterOldPassword.setBackground(Color.BLACK);
		lblEnterOldPassword.setBounds(255, 115, 172, 20);
		contentPane.add(lblEnterOldPassword);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String ops = OldPasswordField.getText();
				@SuppressWarnings("deprecation")
				String nps = NewPasswordField.getText();
                try {
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) con
                        .prepareStatement("Update `account` set `password`=? where `password`='"+ops+"'");

                    st.setString(1, nps);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnConfirm, "Password has been successfully changed");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                dispose();
                UserHomePage uhp=new UserHomePage();
                uhp.setVisible(true);
			}
		});
		
		NewPasswordField = new JPasswordField();
		NewPasswordField.setForeground(Color.BLACK);
		NewPasswordField.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		NewPasswordField.setEchoChar('*');
		NewPasswordField.setBackground(Color.WHITE);
		NewPasswordField.setBounds(502, 178, 147, 30);
		contentPane.add(NewPasswordField);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setBounds(356, 277, 188, 25);
		contentPane.add(btnConfirm);
	}
}
