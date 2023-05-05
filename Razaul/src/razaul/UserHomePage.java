package razaul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UserHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHomePage frame = new UserHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param ah 
	 * @param frame 
	 * @param frame 
	 */
	public UserHomePage() {
//		this.userName=userName;
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
		lblLbuGraphicsFinal.setBounds(236, 14, 316, 30);
		contentPane.add(lblLbuGraphicsFinal);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(UserHomePage.class.getResource("/razaul/logoLbu1.png")));
		Logo.setForeground(Color.BLACK);
		Logo.setBackground(Color.BLACK);
		Logo.setBounds(12, 0, 200, 353);
		contentPane.add(Logo);
		
		JButton btnNewButton = new JButton("Graphics System");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GraphicsSystem gs=new GraphicsSystem();
				gs.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(364, 94, 188, 25);
		contentPane.add(btnNewButton);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChangePassword cp = new ChangePassword();
                cp.setVisible(true);
			}
		});
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		btnChangePassword.setBackground(Color.BLACK);
		btnChangePassword.setBounds(364, 143, 188, 25);
		contentPane.add(btnChangePassword);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfrimationForDelete cfd=new ConfrimationForDelete();
				cfd.setVisible(true);
			}
		});
		
		btnDeleteAccount.setForeground(Color.WHITE);
		btnDeleteAccount.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		btnDeleteAccount.setBackground(Color.BLACK);
		btnDeleteAccount.setBounds(364, 198, 188, 25);
		contentPane.add(btnDeleteAccount);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main main=new Main();
				main.setVisible(true);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Nimbus Roman", Font.BOLD, 18));
		btnLogout.setBackground(Color.BLACK);
		btnLogout.setBounds(364, 252, 188, 25);
		contentPane.add(btnLogout);
	}

}
