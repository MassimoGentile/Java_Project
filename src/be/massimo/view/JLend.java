package be.massimo.view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.massimo.BusinessLayer.ConsoleBusiness;
import be.massimo.BusinessLayer.GameBusiness;
import be.massimo.pojo.Console;
import be.massimo.pojo.Game;
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
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		lblUnit.setText(String.valueOf(Player.getAmount()));
		contentPane.add(lblUnit);
		
		JLabel lblNewLabel_1 = new JLabel("Select your game :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 80, 152, 23);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 84, 302, 74);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Select the console :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 169, 152, 20);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 172, 164, 38);
		contentPane.add(scrollPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("Game Informations");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(243, 236, 223, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 290, 121, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNameGame = new JLabel("");
		lblNameGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameGame.setBounds(141, 290, 537, 20);
		contentPane.add(lblNameGame);
		
		JLabel lblNewLabel_5 = new JLabel("Year Release :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 321, 121, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblYearReleaseGame = new JLabel("");
		lblYearReleaseGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYearReleaseGame.setBounds(141, 321, 139, 20);
		contentPane.add(lblYearReleaseGame);
		
		JLabel lblNewLabel_6 = new JLabel("Editor :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 352, 121, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblEditorGame = new JLabel("");
		lblEditorGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditorGame.setBounds(141, 352, 537, 20);
		contentPane.add(lblEditorGame);
		
		JLabel lblUnit_1 = new JLabel("Unit :");
		lblUnit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit_1.setBounds(10, 383, 121, 20);
		contentPane.add(lblUnit_1);
		
		JLabel lblUnitGame = new JLabel("");
		lblUnitGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnitGame.setBounds(141, 383, 65, 20);
		contentPane.add(lblUnitGame);
		
		GameBusiness gameB = new GameBusiness();
		List<Game> gameL = gameB.getAll();
		DefaultListModel<String> model = new DefaultListModel<>();
		for(int i = 0; i < gameL.size(); i++)
			model.addElement(String.valueOf(gameL.get(i).getId()) + " - " + gameL.get(i).getName());
		
		JList listGame = new JList(model);
		scrollPane.setViewportView(listGame);
		listGame.setVisibleRowCount(1);
		listGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listGame.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting() == false) {
					Game game = gameL.get(listGame.getSelectedIndex());
					lblNameGame.setText(game.getName());
					lblYearReleaseGame.setText(String.valueOf(game.getReleaseYear()));
					lblEditorGame.setText(game.getEditor());
					lblUnitGame.setText(String.valueOf(game.getUnit()));
				}
			}
		});
		
		
		ConsoleBusiness consoleB = new ConsoleBusiness();
		List<Console> consoleL = consoleB.getAll();
		DefaultListModel<String> model2 = new DefaultListModel<>();
		for(int i =0; i < consoleL.size(); i++)
			model2.addElement(consoleL.get(i).getName() + " " + consoleL.get(i).getVersion());
			
		JList listConsole = new JList(model2);
		scrollPane_1.setViewportView(listConsole);
		listConsole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listConsole.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting() == false) {
					Console console = consoleL.get(listConsole.getSelectedIndex());
				}
			}
		});
		
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
