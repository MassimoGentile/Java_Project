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
		setBounds(100, 100, 565, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 24, 92, 25);
		contentPane.add(lblName);
		
		JLabel lblFirstname = new JLabel("Firstname :");
		lblFirstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstname.setBounds(10, 60, 92, 25);
		contentPane.add(lblFirstname);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthday.setBounds(10, 96, 92, 25);
		contentPane.add(lblBirthday);
		
		JLabel lblNewLabel = new JLabel("Address :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 132, 92, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 168, 92, 25);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 204, 92, 25);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(150, 28, 317, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtFirstaname = new JTextField();
		txtFirstaname.setBounds(150, 62, 317, 20);
		contentPane.add(txtFirstaname);
		txtFirstaname.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setBounds(150, 99, 317, 20);
		contentPane.add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(150, 134, 317, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(150, 170, 317, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(150, 208, 317, 20);
		contentPane.add(txtPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(150, 239, 317, 23);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome();
				home.setVisible(true);
				dispose();
			}
		});
		btnSaveChanges.setBounds(150, 273, 317, 23);
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
		btnDeleteAccount.setBounds(150, 307, 317, 23);
		contentPane.add(btnDeleteAccount);
	}
}
