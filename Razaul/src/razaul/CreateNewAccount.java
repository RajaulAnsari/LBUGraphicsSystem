package razaul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;


public class CreateNewAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccount frame = new CreateNewAccount();
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
	public CreateNewAccount() {
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CreateNewAccount.class.getResource("/razaul/logoLbu1.png")));
		Logo.setForeground(Color.WHITE);
		Logo.setBackground(Color.BLACK);
		Logo.setBounds(12, 90, 240, 168);
		contentPane.add(Logo);
		
		JLabel lblCreateNewAccount = new JLabel("Create New Account");
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setBackground(Color.BLACK);
		lblCreateNewAccount.setFont(new Font("Nimbus Roman", Font.BOLD, 24));
		lblCreateNewAccount.setBounds(275, 27, 279, 30);
		contentPane.add(lblCreateNewAccount);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		lblFirstName.setBackground(Color.BLACK);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(264, 90, 94, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		lblLastName.setBackground(Color.BLACK);
		lblLastName.setBounds(264, 136, 94, 20);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setBounds(264, 187, 94, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(264, 232, 94, 20);
		contentPane.add(lblPassword);
		
		JFormattedTextField EnterFName = new JFormattedTextField();
		EnterFName.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		EnterFName.setForeground(Color.BLACK);
		EnterFName.setBackground(Color.WHITE);
		EnterFName.setBounds(503, 79, 147, 30);
		contentPane.add(EnterFName);
		
		JFormattedTextField EnterLName = new JFormattedTextField();
		EnterLName.setForeground(Color.BLACK);
		EnterLName.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		EnterLName.setBackground(Color.WHITE);
		EnterLName.setBounds(503, 131, 147, 30);
		contentPane.add(EnterLName);
		
		JFormattedTextField EnterUName = new JFormattedTextField();
		EnterUName.setForeground(Color.BLACK);
		EnterUName.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		EnterUName.setBackground(Color.WHITE);
		EnterUName.setBounds(503, 182, 147, 30);
		contentPane.add(EnterUName);
		
		JPasswordField EnterPassword = new JPasswordField();
		EnterPassword.setForeground(Color.BLACK);
		EnterPassword.setFont(new Font("Nimbus Roman", Font.PLAIN, 18));
		EnterPassword.setEchoChar('*');
		EnterPassword.setBackground(Color.WHITE);
		EnterPassword.setBounds(503, 227, 147, 30);
		contentPane.add(EnterPassword);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = EnterFName.getText();
                String lastName = EnterLName.getText();
                String userName = EnterUName.getText();
				@SuppressWarnings("deprecation")
				String password = EnterPassword.getText();

                String msg = "" + firstName;
                msg += " \n";

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "");

                    String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "')";
                    
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
                    if (x ==0) {
                        JOptionPane.showMessageDialog(btnSignup, "This is alredy exist.");
                    } 
                    
                    else if(firstName.length()==0 || lastName.length()==0 || userName.length()==0 || password.length()==0){
                        JOptionPane.showMessageDialog(btnSignup,
                            "Please fill all the information.");
                    }
                    else if(password.length()<8){
                        JOptionPane.showMessageDialog(btnSignup,
                            "Password Must Be Eight Character Length.");
                    }
                    else{
//                    	LoginSystem log=new LoginSystem();
//                    	log.setVisible(true);
                    	JOptionPane.showMessageDialog(btnSignup,
                            "Welcome, " + msg + "Your account is sucessfully created.");
                    }
                    
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                Main log =new Main();
                log.setVisible(true);
                dispose();
			}
		});
		btnSignup.setFont(new Font("Nimbus Roman", Font.BOLD, 16));
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBackground(Color.BLACK);
		btnSignup.setBounds(404, 309, 117, 25);
		contentPane.add(btnSignup);
	}
}
