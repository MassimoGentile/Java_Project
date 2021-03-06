package be.massimo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import be.massimo.BusinessLayer.PlayerBusiness;



// ATTENTION IL FAUT CHANGER LE NOM DE LA CLASSE HOME EN JHOME
public class JRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFirstname;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public JRegistration() {
		setTitle("Java_Project - Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(150, 85, 317, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
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
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(150, 119, 317, 20);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(150, 191, 317, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(150, 227, 317, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(150, 265, 317, 20);
		contentPane.add(txtPassword);
		
		JFormattedTextField txtBirthday = new JFormattedTextField(dateFormat);
		txtBirthday.setBounds(150, 157, 317, 20);
		txtBirthday.setColumns(10);
		contentPane.add(txtBirthday);
		try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(txtBirthday);
        } catch (ParseException ex) {
            ex.getMessage();
        }
		
		/*
		 * BUTTONS
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(150, 296, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().isEmpty() && txtFirstname.getText().isEmpty() && txtBirthday.getText().isEmpty() && txtAddress.getText().isEmpty() && txtEmail.getText().isEmpty() && txtPassword.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Field(s) are empty", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					PlayerBusiness player = new PlayerBusiness();
					if(player.Registration(txtName.getText(), txtFirstname.getText(), txtBirthday.getText(), txtAddress.getText(), txtEmail.getText(), txtPassword.getText())) {
						JOptionPane.showMessageDialog(null, "New User Created", "Success", JOptionPane.INFORMATION_MESSAGE);
						JLogin login = new JLogin();
						login.setVisible(true);
						dispose();
					}else
						JOptionPane.showMessageDialog(null, "Error user creation", "Error", JOptionPane.ERROR_MESSAGE);
					
				}		
			}
		});
		btnSignUp.setBounds(378, 296, 89, 23);
		contentPane.add(btnSignUp);
	}
}

