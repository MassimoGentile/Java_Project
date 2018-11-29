package be.massimo.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.massimo.BusinessLayer.GameBusiness;
import be.massimo.pojo.Game;
import be.massimo.pojo.Player;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class JBooking extends JFrame {

	private Player Player;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JBooking(Player player) {
		setTitle("Java_Project - Booking");
		this.Player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnitAmount = new JLabel("Unit Amount :");
		lblUnitAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnitAmount.setBounds(516, 11, 106, 32);
		contentPane.add(lblUnitAmount);
		
		JLabel label = new JLabel("Select your game :");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(10, 80, 152, 23);
		contentPane.add(label);
		
		GameBusiness gameB = new GameBusiness();
		List<Game> gameL = gameB.getAll();
		DefaultListModel<String> model = new DefaultListModel<>();
		for(int i = 0; i < gameL.size(); i++)
			model.addElement(String.valueOf(gameL.get(i).getId()) + " - " + gameL.get(i).getName());
		
		JLabel label_1 = new JLabel("Game Informations");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(242, 195, 223, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Console :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(10, 259, 152, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Name :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(10, 290, 121, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Year Release :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(10, 321, 121, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Editor :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(10, 352, 121, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Unit :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(10, 383, 121, 20);
		contentPane.add(label_6);
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setBounds(628, 11, 50, 32);
		lblUnit.setText(String.valueOf(Player.getAmount()));
		contentPane.add(lblUnit);
		
		JLabel txtConsole = new JLabel("");
		txtConsole.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtConsole.setBounds(141, 259, 537, 20);
		contentPane.add(txtConsole);
		
		JLabel txtName = new JLabel("");
		txtName.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtName.setBounds(141, 290, 537, 20);
		contentPane.add(txtName);
		
		JLabel txtYearRelease = new JLabel("");
		txtYearRelease.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtYearRelease.setBounds(141, 321, 139, 20);
		contentPane.add(txtYearRelease);
		
		JLabel txtEditor = new JLabel("");
		txtEditor.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEditor.setBounds(141, 352, 537, 20);
		contentPane.add(txtEditor);
		
		JLabel txtUnit = new JLabel("");
		txtUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtUnit.setBounds(141, 383, 65, 20);
		contentPane.add(txtUnit);
		
		JButton btnDisconnect = new JButton("");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 84, 302, 74);
		contentPane.add(scrollPane);
		JList listGame = new JList(model);
		listGame.setVisibleRowCount(1);
		listGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listGame);
		listGame.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting() == false) {
					Game game = gameL.get(listGame.getSelectedIndex());
					txtName.setText(game.getName());
					txtYearRelease.setText(String.valueOf(game.getReleaseYear()));
					txtEditor.setText(game.getEditor());
					txtUnit.setText(String.valueOf(game.getUnit()));
					txtConsole.setText(game.getConsole().getName() + " " + game.getConsole().getVersion());
				}
			}
		});
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setIcon(new ImageIcon(JBooking.class.getResource("/Images/logout-sign32.png")));
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
		btnBack.setBounds(506, 384, 73, 23);
		contentPane.add(btnBack);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listGame.isSelectionEmpty())
					JOptionPane.showMessageDialog(null, "You must choose a game !", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					JBook book = new JBook(Player, gameL.get(listGame.getSelectedIndex()));
					book.setVisible(true);
					dispose();
				}
			}
		});
		btnBook.setBounds(589, 384, 89, 23);
		contentPane.add(btnBook);
	}
}
