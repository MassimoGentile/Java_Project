package be.massimo.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import be.massimo.BusinessLayer.GameBusiness;
import be.massimo.pojo.Game;
import be.massimo.pojo.Player;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JGame extends JFrame {

	private JPanel contentPane;
	private Game Game;
	private Player Player;
	private JTextField txtName;
	private JTextField txtReleaseYear;
	private JTextField txtEditor;
	private JTextField txtUnit;

	/**
	 * Create the frame.
	 */
	public JGame(Player player, Game game) {
		setTitle("Java_Project - Game Update");
		this.Game = game;
		this.Player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 32, 104, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblReleaseYear = new JLabel("Release Year :");
		lblReleaseYear.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReleaseYear.setBounds(10, 64, 123, 21);
		contentPane.add(lblReleaseYear);
		
		JLabel lblEditor = new JLabel("Editor :");
		lblEditor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditor.setBounds(10, 96, 104, 21);
		contentPane.add(lblEditor);
		
		JLabel lblUnit = new JLabel("Unit :");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(10, 128, 104, 21);
		contentPane.add(lblUnit);
		
		txtName = new JTextField();
		txtName.setBounds(143, 34, 281, 20);
		txtName.setText(Game.getName());
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtReleaseYear = new JTextField();
		txtReleaseYear.setColumns(10);
		txtReleaseYear.setBounds(143, 66, 281, 20);
		txtReleaseYear.setText(String.valueOf(Game.getReleaseYear()));
		contentPane.add(txtReleaseYear);
		
		txtEditor = new JTextField();
		txtEditor.setColumns(10);
		txtEditor.setBounds(143, 98, 281, 20);
		txtEditor.setText(Game.getEditor());
		contentPane.add(txtEditor);
		
		txtUnit = new JTextField();
		txtUnit.setColumns(10);
		txtUnit.setBounds(143, 130, 281, 20);
		txtUnit.setText(String.valueOf(Game.getUnit()));
		contentPane.add(txtUnit);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameBusiness gameB = new GameBusiness();
				gameB.Modification(Game.getId(), txtName.getText(), Integer.parseInt(txtReleaseYear.getText()), txtEditor.getText(), Integer.parseInt(txtUnit.getText()), Game.getConsole());
				JAdmin admin = new JAdmin(Player);
				admin.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setBounds(335, 161, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JAdmin admin = new JAdmin(Player);
				admin.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(143, 161, 89, 23);
		contentPane.add(btnBack);
	}

}
