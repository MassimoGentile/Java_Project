package be.massimo.view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.massimo.pojo.Player;

public class JLend extends JFrame {

	private Player Player;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JLend(Player player) {
		this.Player = player;
		setTitle("Java_Project - Lend");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 458);
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
		
		JLabel lblNewLabel_1 = new JLabel("Select your game :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 80, 152, 23);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 84, 302, 74);
		contentPane.add(scrollPane);
		
		JList listGame = new JList();
		scrollPane.setViewportView(listGame);
		listGame.setVisibleRowCount(1);
		listGame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		listGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listGame.setModel(new AbstractListModel() {
			String[] values = new String[] {"1 - Il \u00E9tait une fois les noirs", "2 - La congolexicomatisation des lois du march\u00E9", "3 - Retour vers la friture", "4 - La mer noir ", "5 - Mamadou contre-attaque", "6 - Gizmo et les 7 nains", "7 - Bakala attraper les tous", "8 - Le retour du jet d'ail", "9 - Alibaba et les 40 trou duc", "10 - Attention \u00E0 la merde"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Select the console :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 169, 152, 20);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 172, 164, 38);
		contentPane.add(scrollPane_1);
		
		JList listConsole = new JList();
		scrollPane_1.setViewportView(listConsole);
		listConsole.setModel(new AbstractListModel() {
			String[] values = new String[] {"1 - PC", "2 - PS4", "3 - XBOX ONE", "4 - NINTENDO SWITCH", "5 - PS3", "6 - XBOX 360", "7 - NINTENDO 3DS", "8 - NINTENDO DS", "9 - GAMEBOY"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listConsole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel_3 = new JLabel("Game Informations");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(243, 236, 223, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 290, 121, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNameGame = new JLabel("Alibaba et les 40 trou duc");
		lblNameGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameGame.setBounds(141, 290, 537, 20);
		contentPane.add(lblNameGame);
		
		JLabel lblNewLabel_5 = new JLabel("Year Release :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 321, 121, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblYearReleaseGame = new JLabel("2012");
		lblYearReleaseGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYearReleaseGame.setBounds(141, 321, 139, 20);
		contentPane.add(lblYearReleaseGame);
		
		JLabel lblNewLabel_6 = new JLabel("Editor :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 352, 121, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblEditorGame = new JLabel("Mamadou Production");
		lblEditorGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditorGame.setBounds(141, 352, 537, 20);
		contentPane.add(lblEditorGame);
		
		JLabel lblUnit_1 = new JLabel("Unit :");
		lblUnit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit_1.setBounds(10, 383, 121, 20);
		contentPane.add(lblUnit_1);
		
		JLabel lblUnitGame = new JLabel("5");
		lblUnitGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnitGame.setBounds(141, 383, 65, 20);
		contentPane.add(lblUnitGame);
		
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
		btnDisconnect.setIcon(new ImageIcon(JLend.class.getResource("/Images/logout-sign32.png")));
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
		btnBack.setBounds(456, 384, 73, 23);
		contentPane.add(btnBack);
		
		JButton btnLendGame = new JButton("Lend this game");
		btnLendGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call the insert function of copy
				JHome home = new JHome(Player);
				home.setVisible(true);
				dispose();
			}
		});
		btnLendGame.setBounds(539, 384, 139, 23);
		contentPane.add(btnLendGame);
	}
}
