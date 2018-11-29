package be.massimo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.massimo.BusinessLayer.LoanBusiness;
import be.massimo.pojo.Loan;
import be.massimo.pojo.Player;

public class JRemoveLoan extends JFrame {

	private JPanel contentPane;
	private Player Player;
	private Loan Loan;

	/**
	 * Create the frame.
	 */
	public JRemoveLoan(Player player, Loan loan) {
		setTitle("Java_Project - Remove Loan");
		this.Player = player;
		this.Loan = loan;
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
				int n = JOptionPane.showConfirmDialog(null, "Are you sure to remove this Loan?", "Remove Loan", JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					LoanBusiness loanB = new LoanBusiness();
					loanB.RemoveLoan(Loan);
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
		lblName.setText(Loan.getCopy().getGame().getName());
		contentPane.add(lblName);
		
		JLabel lblConsole = new JLabel("");
		lblConsole.setBounds(120, 63, 304, 23);
		lblConsole.setText(Loan.getCopy().getGame().getConsole().getName() + " " + Loan.getCopy().getGame().getConsole().getVersion());
		contentPane.add(lblConsole);
	}

}
