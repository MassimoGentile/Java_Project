package be.massimo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.massimo.BusinessLayer.PlayerBusiness;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Player;
import javax.swing.JLabel;
import java.awt.Font;

public class JRemoveCopy extends JFrame {

	private JPanel contentPane;
	private Copy Copy;
	private Player Player;
	/**
	 * Create the frame.
	 */
	public JRemoveCopy(Player player, Copy copy) {
		setTitle("Java_Project - Remove Copy");
		this.Player = player;
		this.Copy = copy;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JHome home = new JHome(Player);
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(110, 105, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure to remove this copy?", "Remove Copy", JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					PlayerBusiness playerB = new PlayerBusiness();
					Player = playerB.RemoveCopy(Player, Copy.getId());
					JOptionPane.showMessageDialog(null, "Remove successfully !", "Success", JOptionPane.INFORMATION_MESSAGE);
					JHome home = new JHome(Player);
					home.setVisible(true);
					dispose();
				}
			}
		});
		btnRemove.setBounds(233, 105, 89, 23);
		contentPane.add(btnRemove);
		
		JLabel lblNamet = new JLabel("Name:");
		lblNamet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNamet.setBounds(10, 29, 83, 23);
		contentPane.add(lblNamet);
		
		JLabel lblConsolet = new JLabel("Console:");
		lblConsolet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConsolet.setBounds(10, 63, 83, 23);
		contentPane.add(lblConsolet);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(120, 29, 304, 23);
		lblName.setText(Copy.getGame().getName());
		contentPane.add(lblName);
		
		JLabel lblConsole = new JLabel("");
		lblConsole.setBounds(120, 63, 304, 23);
		lblConsole.setText(Copy.getGame().getConsole().getName() + " " + Copy.getGame().getConsole().getVersion());
		contentPane.add(lblConsole);
	}
}
