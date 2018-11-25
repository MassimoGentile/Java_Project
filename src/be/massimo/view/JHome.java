package be.massimo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class JHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JHome frame = new JHome();
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
	public JHome() {
		setTitle("Java_Project - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 569);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setFocusable(false);
		btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnBorrow.setBounds(39, 403, 195, 77);
		contentPane.add(btnBorrow);
		
		JButton btnLend = new JButton("Lend");
		btnLend.setFocusable(false);
		btnLend.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnLend.setBounds(487, 403, 195, 77);
		contentPane.add(btnLend);
		
		JButton btnProfil = new JButton("");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JAlterProfil profil = new JAlterProfil();
				profil.setVisible(true);
				dispose();
			}
		});
		btnProfil.setContentAreaFilled(false);
		btnProfil.setBorderPainted(false);
		btnProfil.setBackground(SystemColor.menu);
		btnProfil.setIcon(new ImageIcon(JHome.class.getResource("/Images/settings32.png")));
		btnProfil.setBounds(52, 11, 32, 32);
		contentPane.add(btnProfil);
		
		JButton btnDisconnect = new JButton("");
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setIcon(new ImageIcon(JHome.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
	}
}
