package be.massimo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import be.massimo.pojo.Player;

public class JBook extends JFrame {

	private Player Player;
	private JPanel contentPane;
	private JTable tableGameBook;

	/**
	 * Create the frame.
	 */
	public JBook(Player player) {
		this.Player = player;
		setTitle("Java_Project - Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unit Amount :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(516, 11, 106, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblUnit = new JLabel("10");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		contentPane.add(lblUnit);
		
		tableGameBook = new JTable();
		tableGameBook.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableGameBook.setBounds(31, 85, 644, 122);
		contentPane.add(tableGameBook);
		
		JLabel lblNewLabel_2 = new JLabel("Informations about the game");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(31, 54, 644, 23);
		contentPane.add(lblNewLabel_2);
		
		/*
		 * BUTTONS
		 */
		JButton btnDisconnect = new JButton("");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setIcon(new ImageIcon(JBook.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBorrow borrow = new JBorrow(Player);
				borrow.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(31, 218, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnBookThisGame = new JButton("Book this game");
		btnBookThisGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Implementation require for the booking function
				JHome home = new JHome(Player);
				home.setVisible(true);
				dispose();
			}
		});
		btnBookThisGame.setBounds(545, 218, 125, 23);
		contentPane.add(btnBookThisGame);
	}
}
