package razaul;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ConfrimationForDelete extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfrimationForDelete dialog = new ConfrimationForDelete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfrimationForDelete() {
		setResizable(false);
		getContentPane().setBackground(Color.BLUE);
		setBackground(Color.BLUE);
		setBounds(100, 100, 325, 243);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(12, 38, 106, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(12, 100, 106, 23);
		getContentPane().add(lblPassword);
		
		JFormattedTextField EnterUsername = new JFormattedTextField();
		EnterUsername.setForeground(Color.BLACK);
		EnterUsername.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		EnterUsername.setBounds(157, 35, 139, 30);
		getContentPane().add(EnterUsername);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(160, 98, 139, 28);
		getContentPane().add(passwordField);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String userName = EnterUsername.getText();
	                @SuppressWarnings("deprecation")
					String password = passwordField.getText();
					try {
						if (userName.length()<1 || password.length()<1) {
							JOptionPane.showMessageDialog(okButton, "Please enter Your username and password");
						}
						else if(userName.length()>1 || password.length()>1){
	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
	                        "root", "");

	                    PreparedStatement st = (PreparedStatement) con
	                        .prepareStatement("DELETE FROM account WHERE user_name=? and password=?");
	                    st.setString(1, userName);
	                    st.setString(2, password);
	                    st.executeUpdate();
	                    JOptionPane.showMessageDialog(okButton, "Account has been successfully deleted");
	                    dispose();
	                    Main mn=new Main();
	                    mn.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(okButton, "Wrong Username & Password");
						}

	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
				}
			});
			okButton.setBounds(80, 169, 54, 25);
			getContentPane().add(okButton);
			okButton.setForeground(Color.WHITE);
			okButton.setBackground(Color.BLACK);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(160, 169, 81, 25);
			getContentPane().add(cancelButton);
			cancelButton.setForeground(Color.WHITE);
			cancelButton.setBackground(Color.BLACK);
			cancelButton.setActionCommand("Cancel");
		}
	}
}
