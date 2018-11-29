package be.massimo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.massimo.BusinessLayer.GameBusiness;
import be.massimo.pojo.Console;
import be.massimo.pojo.Game;
import be.massimo.pojo.Player;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JAdmin extends JFrame {

	private Player Player;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JAdmin(Player player) {
		this.Player = player;
		setTitle("Java_Project - Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Home Boss !");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 11, 253, 35);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 302, 74);
		contentPane.add(scrollPane);
		
		GameBusiness gameB = new GameBusiness();
		List<Game> gameL = gameB.getAll();
		DefaultListModel<String> model = new DefaultListModel<>();
		for(int i = 0; i < gameL.size(); i++)
			model.addElement(String.valueOf(gameL.get(i).getId()) + " - " + gameL.get(i).getName());
		JList listGame = new JList(model);
		scrollPane.setViewportView(listGame);
		listGame.setVisibleRowCount(1);
		listGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		btnDisconnect.setIcon(new ImageIcon(JAdmin.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
		
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listGame.isSelectionEmpty())
					JOptionPane.showMessageDialog(null, "You must select a game !", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					Game game = gameL.get(listGame.getSelectedIndex());
					JGame jgame = new JGame(Player, game);
					jgame.setVisible(true);
					dispose();
				}
			}
		});
		btnUpdateGame.setBounds(10, 160, 302, 23);
		contentPane.add(btnUpdateGame);
		
		JButton btnUpdateUnit = new JButton("Update Unit User");
		btnUpdateUnit.setBounds(10, 194, 302, 23);
		contentPane.add(btnUpdateUnit);
		listGame.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting() == false) {
					Game game = gameL.get(listGame.getSelectedIndex());
				}
			}
		});
	}

}
