package be.massimo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import be.massimo.BusinessLayer.CopyBusiness;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Player;
import javax.swing.ListSelectionModel;

public class JBorrow extends JFrame {

	private Player Player;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JBorrow(Player player) {
		this.Player = player;
		setTitle("Java_Project - Borrow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 491);
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
		
		JLabel lblNewLabel_2 = new JLabel("List of all Copy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(33, 70, 644, 23);
		contentPane.add(lblNewLabel_2);
		
		
		List<Copy> copyL = new CopyBusiness().getCopies();
		DefaultListModel<String> modelCopy = new DefaultListModel<>();
		for(int i = 0; i < copyL.size(); i++)
			modelCopy.addElement("Owner : " + copyL.get(i).getLender().getName() + " " + copyL.get(i).getLender().getFirstname() + " | Name: " + copyL.get(i).getGame().getName() + " | Console: " + copyL.get(i).getGame().getConsole().getName() + " " + copyL.get(i).getGame().getConsole().getVersion() + " | Unit: " + copyL.get(i).getGame().getUnit() + " | Available : " + copyL.get(i).getAvailable());
		
		JList listGames = new JList(modelCopy);
		listGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listGames.setBorder(new LineBorder(new Color(0, 0, 0)));
		listGames.setBounds(33, 104, 644, 300);
		contentPane.add(listGames);
		
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
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setIcon(new ImageIcon(JBorrow.class.getResource("/Images/logout-sign32.png")));
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
		btnBack.setBounds(33, 415, 70, 23);
		contentPane.add(btnBack);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listGames.isSelectionEmpty())
					JOptionPane.showMessageDialog(null, "You must choose a game !", "Error", JOptionPane.ERROR_MESSAGE);
				else if(copyL.get(listGames.getSelectedIndex()).getLender().getId() == Player.getId())
					JOptionPane.showMessageDialog(null, "You can't borrow your own copy !", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					JBook book = new JBook(Player, copyL.get(listGames.getSelectedIndex()));
					book.setVisible(true);
					dispose();
				}
			}
		});
		btnBook.setBounds(307, 415, 90, 23);
		contentPane.add(btnBook);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listGames.isSelectionEmpty())
					JOptionPane.showMessageDialog(null, "You must choose a game !", "Error", JOptionPane.ERROR_MESSAGE);
				else if(copyL.get(listGames.getSelectedIndex()).getLender().getId() == Player.getId())
					JOptionPane.showMessageDialog(null, "You can't borrow your own copy !", "Error", JOptionPane.ERROR_MESSAGE);
				else if(copyL.get(listGames.getSelectedIndex()).getAvailable() == false)
					JOptionPane.showMessageDialog(null, "You can't borrow this unavailable copy !", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					JLoan loan = new JLoan(Player, copyL.get(listGames.getSelectedIndex()));
					loan.setVisible(true);
					dispose();
				}
			}
		});
		btnBorrow.setBounds(588, 415, 89, 23);
		contentPane.add(btnBorrow);
	}
}
