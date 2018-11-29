package be.massimo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.massimo.BusinessLayer.PlayerBusiness;
import be.massimo.pojo.Player;

public class JLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
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
	public JLogin() {
		setTitle("Java_Project - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 70, 72, 37);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 124, 107, 37);
		contentPane.add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(141, 70, 333, 37);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(141, 124, 333, 37);
		contentPane.add(txtPassword);
		
		/*
		 * BUTTONS
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerBusiness playerB = new PlayerBusiness();
				if(txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "One or more fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					Player player = playerB.Login(txtEmail.getText(), txtPassword.getText());
					if( player == null)
						JOptionPane.showMessageDialog(null, "Bad email or password", "Error", JOptionPane.ERROR_MESSAGE);
					else if(player.getAdmin() == true) {
						JAdmin admin = new JAdmin(player);
						admin.setVisible(true);
						dispose();
					}
					else {
						JHome home = new JHome(player);
						home.setVisible(true);
						dispose();
					}
				}	
			}
		});
		btnLogin.setBounds(141, 182, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText("");
				txtPassword.setText("");
			}
		});
		btnClear.setBounds(266, 182, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRegistration registration = new JRegistration();
				registration.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setBounds(380, 182, 89, 23);
		contentPane.add(btnSignUp);
	}
}
