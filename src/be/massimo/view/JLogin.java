package be.massimo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	private JPanel contentPane;
	private JTextField TxtFEmail;
	private JPasswordField PassFPassword;

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
		setBounds(100, 100, 557, 300);
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
		
		TxtFEmail = new JTextField();
		TxtFEmail.setHorizontalAlignment(SwingConstants.CENTER);
		TxtFEmail.setBounds(141, 70, 333, 37);
		contentPane.add(TxtFEmail);
		TxtFEmail.setColumns(10);
		
		PassFPassword = new JPasswordField();
		PassFPassword.setHorizontalAlignment(SwingConstants.CENTER);
		PassFPassword.setBounds(141, 124, 333, 37);
		contentPane.add(PassFPassword);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRegistration registration = new JRegistration();
				registration.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setBounds(385, 193, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Doit permettre de faire la connexion à la base de données et si les données sont correctes, envoyer vers un nouvelle JFrame qui contient la page d'accueil des gens
			}
		});
		btnLogin.setBounds(141, 193, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxtFEmail.setText("");
				PassFPassword.setText("");
			}
		});
		btnClear.setBounds(265, 193, 89, 23);
		contentPane.add(btnClear);
	}
}
