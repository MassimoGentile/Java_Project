package be.massimo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



// ATTENTION IL FAUT CHANGER LE NOM DE LA CLASSE HOME EN JHOME
public class JRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRegistration frame = new JRegistration();
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
	public JRegistration() {
		setTitle("Java_Project - Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 85, 317, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 81, 92, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Firstname :");
		lblFirstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstname.setBounds(10, 117, 92, 25);
		contentPane.add(lblFirstname);
		
		JLabel lblNewLabel_1 = new JLabel("Birthday :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 153, 92, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(10, 189, 92, 25);
		contentPane.add(lblAddress);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 225, 92, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 261, 92, 25);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 119, 317, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 156, 317, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 191, 317, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 227, 317, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 265, 317, 20);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(473, 225, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(473, 264, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblTheFiedls = new JLabel("Fields with a red * must be filled !");
		lblTheFiedls.setForeground(Color.RED);
		lblTheFiedls.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheFiedls.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTheFiedls.setBounds(150, 297, 317, 14);
		contentPane.add(lblTheFiedls);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Crée un nouvelle utilisateur et renvoie sur JHome
			}
		});
		btnSignUp.setBounds(378, 344, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retourne sur JHome sans sauvegarder les champs
			}
		});
		btnBack.setBounds(150, 344, 89, 23);
		contentPane.add(btnBack);
	}

}

