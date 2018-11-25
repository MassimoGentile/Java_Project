package be.massimo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JBorrow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JBorrow frame = new JBorrow();
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
	public JBorrow() {
		setTitle("Java_Project - Borrow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisconnect = new JButton("");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setIcon(new ImageIcon(JBorrow.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("List of all games available to borrow");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(38, 95, 644, 23);
		contentPane.add(lblNewLabel_2);
		
		JList listGames = new JList();
		listGames.setBorder(new LineBorder(new Color(0, 0, 0)));
		listGames.setBounds(38, 129, 644, 300);
		contentPane.add(listGames);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(38, 440, 70, 23);
		contentPane.add(btnBack);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome();
				home.setVisible(true);
				dispose();
			}
		});
		btnBorrow.setBounds(593, 440, 89, 23);
		contentPane.add(btnBorrow);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Need to transfert the selected game in the list to the following JFrame
				JBook book = new JBook();
				book.setVisible(true);
				dispose();
			}
		});
		btnBook.setBounds(312, 440, 90, 23);
		contentPane.add(btnBook);
	}
}
