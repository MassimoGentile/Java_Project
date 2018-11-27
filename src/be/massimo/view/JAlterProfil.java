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
import be.massimo.pojo.Player;

public class JAlterProfil extends JFrame {

	private Player Player;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFirstname;
	private JTextField txtBirthday;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public JAlterProfil(Player player) {
		this.Player = player;
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
		txtName.setText(Player.getName());
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(150, 62, 317, 20);
		txtFirstname.setText(Player.getFirstname());
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JFormattedTextField txtBirthday = new JFormattedTextField(dateFormat);
		txtBirthday.setBounds(150, 99, 317, 20);
		txtBirthday.setColumns(10);
		contentPane.add(txtBirthday);
		try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(txtBirthday);
        } catch (ParseException ex) {
            ex.getMessage();
        }
		txtBirthday.setText(Player.getBirthday());
		
		txtAddress = new JTextField();
		txtAddress.setBounds(150, 134, 317, 20);
		txtAddress.setText(Player.getAddress());
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(150, 170, 317, 20);
		txtEmail.setText(Player.getEmail());
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(150, 208, 317, 20);
		contentPane.add(txtPassword);
		
		/*
		 * BUTTONS
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome(Player);
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(150, 239, 317, 23);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().isEmpty() || txtFirstname.getText().isEmpty() || txtBirthday.getText().isEmpty() || txtAddress.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "One ore more fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					PlayerBusiness playerB = new PlayerBusiness();
					Player = playerB.Modification(Player.getId() ,txtName.getText(), txtFirstname.getText(), txtBirthday.getText(), txtAddress.getText(), txtEmail.getText(), txtPassword.getText());
					if(Player == null) {
						JOptionPane.showMessageDialog(null, "Update fail, relaunch the application", "Update Fail", JOptionPane.ERROR_MESSAGE);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Update success", "Success", JOptionPane.INFORMATION_MESSAGE);
						JHome home = new JHome(Player);
						home.setVisible(true);
						dispose();
					}
						
					
				}
			}
		});
		btnSaveChanges.setBounds(150, 273, 317, 23);
		contentPane.add(btnSaveChanges);
		
		JButton btnDeleteAccount = new JButton("Delete your account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure to remove your account?", "Remove Account", JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					PlayerBusiness playerB = new PlayerBusiness();
					boolean test = false;
					test = playerB.Remove(Player);
					if(test == false) {
						JOptionPane.showMessageDialog(null, "Fail to remove this account", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Remove successfull,\n" + "Hope to see you again !", "Success", JOptionPane.INFORMATION_MESSAGE);
						JLogin login = new JLogin();
						login.setVisible(true);
						dispose();
					}
				}
			}
		});
		btnDeleteAccount.setBounds(150, 307, 317, 23);
		contentPane.add(btnDeleteAccount);
	}
}
