package be.massimo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JAlterProfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFirstaname;
	private JTextField txtBirthday;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAlterProfil frame = new JAlterProfil();
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
	public JAlterProfil() {
		setTitle("Java_Project - Profil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 81, 92, 25);
		contentPane.add(lblName);
		
		JLabel lblFirstname = new JLabel("Firstname :");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstname.setBounds(10, 117, 92, 25);
		contentPane.add(lblFirstname);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthday.setBounds(10, 153, 92, 25);
		contentPane.add(lblBirthday);
		
		JLabel lblNewLabel = new JLabel("Address :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 189, 92, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 225, 92, 25);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 261, 92, 25);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(150, 85, 317, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtFirstaname = new JTextField();
		txtFirstaname.setBounds(150, 119, 317, 20);
		contentPane.add(txtFirstaname);
		txtFirstaname.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setBounds(150, 156, 317, 20);
		contentPane.add(txtBirthday);
		txtBirthday.setColumns(10);
		
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(150, 296, 317, 23);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome();
				home.setVisible(true);
				dispose();
			}
		});
		btnSaveChanges.setBounds(150, 330, 317, 23);
		contentPane.add(btnSaveChanges);
		
		JButton btnDeleteAccount = new JButton("Delete your account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call the player delete function
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnDeleteAccount.setBounds(150, 364, 317, 23);
		contentPane.add(btnDeleteAccount);
	}
}
