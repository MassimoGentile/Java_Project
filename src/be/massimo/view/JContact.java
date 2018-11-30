package be.massimo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;


import be.massimo.pojo.Booking;

import be.massimo.pojo.Player;

public class JContact extends JFrame {

	private JPanel contentPane;
	private Player Player;
	private Booking Booking;


	/**
	 * Create the frame.
	 */
	public JContact(Player player, Booking booking) {
		this.Player = player;
		this.Booking = booking;
		
		setTitle("Java_Project - Contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unit Amount :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(516, 11, 106, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		lblUnit.setText(String.valueOf(Player.getAmount()));
		contentPane.add(lblUnit);
		
		JLabel lblInformationsAboutBorrower = new JLabel("Informations about Borrower");
		lblInformationsAboutBorrower.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInformationsAboutBorrower.setBounds(31, 54, 644, 23);
		contentPane.add(lblInformationsAboutBorrower);
		
		JLabel lblN = new JLabel("Name :");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblN.setBounds(31, 88, 75, 20);
		contentPane.add(lblN);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(31, 119, 75, 20);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(31, 150, 75, 20);
		contentPane.add(lblEmail);
		
		JLabel txtName = new JLabel("");
		txtName.setBounds(155, 93, 515, 14);
		txtName.setText(Booking.getBorrower().getName() + Booking.getBorrower().getFirstname());
		contentPane.add(txtName);
		
		JLabel txtEmail = new JLabel("");
		txtEmail.setBounds(155, 155, 515, 14);
		txtEmail.setText(Booking.getBorrower().getEmail());
		contentPane.add(txtEmail);
		
		JLabel txtAddress = new JLabel((String) null);
		txtAddress.setBounds(155, 124, 523, 14);
		txtAddress.setText(Booking.getBorrower().getAddress());
		contentPane.add(txtAddress);
		
		JLabel lblEndDate = new JLabel("Birthday :");
		lblEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEndDate.setBounds(31, 181, 75, 20);
		contentPane.add(lblEndDate);
		
		JButton btnDisconnect = new JButton("");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            ex.getMessage();
        }
		
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setIcon(new ImageIcon(JLoan.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome(Player);
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(31, 222, 89, 23);
		contentPane.add(btnBack);
		
		JLabel txtBirthday = new JLabel("");
		txtBirthday.setBounds(155, 186, 515, 14);
		txtBirthday.setText(Booking.getBorrower().getBirthday());
		contentPane.add(txtBirthday);
	}

}
