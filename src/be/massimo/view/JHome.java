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
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class JHome extends JFrame {

	private JPanel contentPane;
	private JTable tableLend;
	private JTable tableBorrow;

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
		setBounds(100, 100, 722, 548);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBorrow borrow = new JBorrow();
				borrow.setVisible(true);
				dispose();
			}
		});
		btnBorrow.setFocusable(false);
		btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnBorrow.setBounds(38, 425, 195, 77);
		contentPane.add(btnBorrow);
		
		JButton btnLend = new JButton("Lend");
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLend lend = new JLend();
				lend.setVisible(true);
				dispose();
			}
		});
		btnLend.setFocusable(false);
		btnLend.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnLend.setBounds(487, 425, 195, 77);
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
		
		JLabel lblA = new JLabel("List of Games Lend");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblA.setBounds(38, 97, 644, 20);
		contentPane.add(lblA);
		
		tableLend = new JTable();
		tableLend.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableLend.setBounds(39, 128, 644, 122);
		contentPane.add(tableLend);
		
		JLabel lblListOfGames = new JLabel("List of Games Borrow");
		lblListOfGames.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListOfGames.setBounds(38, 261, 644, 20);
		contentPane.add(lblListOfGames);
		
		tableBorrow = new JTable();
		tableBorrow.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableBorrow.setBounds(38, 292, 644, 122);
		contentPane.add(tableBorrow);
		
		JLabel lblUnitAmount = new JLabel("Unit Amount :");
		lblUnitAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnitAmount.setBounds(516, 11, 106, 32);
		contentPane.add(lblUnitAmount);
		
		JLabel lblUnit = new JLabel("10");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		contentPane.add(lblUnit);
	}
}
