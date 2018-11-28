package be.massimo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import be.massimo.BusinessLayer.CopyBusiness;
import be.massimo.pojo.Booking;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Player;
import javax.swing.ListSelectionModel;

public class JHome extends JFrame {

	private Player Player;
	private JPanel contentPane;
	private JTable tableBorrow;

	
	/**
	 * Create the frame.
	 */
	public JHome(Player player) {
		this.Player = player;
		setTitle("Java_Project - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 627);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblA = new JLabel("List of Games Lend");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblA.setBounds(37, 66, 644, 20);
		contentPane.add(lblA);
		
		JLabel lblListOfGames = new JLabel("List of Games Borrow");
		lblListOfGames.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListOfGames.setBounds(37, 230, 644, 20);
		contentPane.add(lblListOfGames);
		
		JLabel lblUnitAmount = new JLabel("Unit Amount :");
		lblUnitAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnitAmount.setBounds(516, 11, 106, 32);
		contentPane.add(lblUnitAmount);
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		lblUnit.setText(String.valueOf(Player.getAmount()));
		contentPane.add(lblUnit);
		
		JLabel lblListOfGame = new JLabel("List of Game Book");
		lblListOfGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListOfGame.setBounds(37, 394, 644, 20);
		contentPane.add(lblListOfGame);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 425, 644, 122);
		contentPane.add(scrollPane);
		
		List<Copy> copyL = Player.getListCopy();
		DefaultListModel<String> modelCopy = new DefaultListModel<>();
		for(int i = 0; i < copyL.size(); i++)
			modelCopy.addElement("Name: " + copyL.get(i).getGame().getName() + " | Console: " + copyL.get(i).getGame().getConsole().getName() + " " + copyL.get(i).getGame().getConsole().getVersion() + " | Unit: " + copyL.get(i).getGame().getUnit());
		JList tableLend = new JList(modelCopy);
		tableLend.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableLend.setBounds(38, 97, 644, 122);
		contentPane.add(tableLend);
		
		
		JList tableBorrow = new JList();
		tableBorrow.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableBorrow.setBounds(37, 261, 644, 122);
		contentPane.add(tableBorrow);
		
		List<Booking> bookingL = Player.getListBokking();
		DefaultListModel<String> modelBooking = new DefaultListModel<>();
		for(int i = 0; i < bookingL.size(); i++)
			modelBooking.addElement("Game:" + bookingL.get(i).getGameWanted().getName() + " | Available: " + bookingL.get(i).getAvailable() + " | Booking Date:" + bookingL.get(i).getBookingDate());
		JList listBook = new JList(modelBooking);
		listBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listBook);
		
		/*
		 * BUTTONS
		 */
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
		
		JButton btnProfil = new JButton("");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JAlterProfil profil = new JAlterProfil(Player);
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
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBorrow borrow = new JBorrow(Player);
				borrow.setVisible(true);
				dispose();
			}
		});
		btnBorrow.setFocusable(false);
		btnBorrow.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrow.setBounds(37, 558, 127, 20);
		contentPane.add(btnBorrow);
		
		JButton btnLend = new JButton("Lend");
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLend lend = new JLend(Player);
				lend.setVisible(true);
				dispose();
			}
		});
		btnLend.setFocusable(false);
		btnLend.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLend.setBounds(570, 558, 113, 20);
		contentPane.add(btnLend);
	}
}
