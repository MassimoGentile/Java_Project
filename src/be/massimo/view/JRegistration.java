package be.massimo.view;

import java.awt.Color;
import java.awt.EventQueue;
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



// ATTENTION IL FAUT CHANGER LE NOM DE LA CLASSE HOME EN JHOME
public class JRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFirstname;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

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
				if(txtEmail.getText().isEmpty() && txtPassword.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Email and Password are empty", "Error", JOptionPane.ERROR_MESSAGE);
				else if(txtEmail.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Email is empty", "Error", JOptionPane.ERROR_MESSAGE);
				else if(txtPassword.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Password is empty", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					JOptionPane.showMessageDialog(null, "Work in progress please wait", "Success", JOptionPane.INFORMATION_MESSAGE);
				}		
			}
		});
		btnSignUp.setBounds(378, 344, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(150, 344, 89, 23);
		contentPane.add(btnBack);
		
		
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
	}
}

