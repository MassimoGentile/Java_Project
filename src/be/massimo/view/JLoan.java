package be.massimo.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import be.massimo.BusinessLayer.LoanBusiness;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Player;

public class JLoan extends JFrame {

	private Player Player;
	private Copy Copy;
	private JPanel contentPane;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public JLoan(Player player, Copy copy) {
		this.Player = player;
		this.Copy = copy;
		
		setTitle("Java_Project - Loan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unit Amount :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(516, 11, 106, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		lblUnit.setText(String.valueOf(Player.getAmount()));
		contentPane.add(lblUnit);
		
		JLabel label = new JLabel("Informations about the game");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(31, 54, 644, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Lender :");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(31, 88, 75, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Name :");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(31, 119, 75, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Version :");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(31, 150, 75, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Unit :");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(472, 88, 75, 20);
		contentPane.add(label_4);
		
		JLabel txtLender = new JLabel("");
		txtLender.setBounds(155, 93, 307, 14);
		txtLender.setText(Copy.getLender().getName() + " " + Copy.getLender().getFirstname());
		contentPane.add(txtLender);
		
		JLabel txtUnit = new JLabel("");
		txtUnit.setBounds(557, 93, 113, 14);
		txtUnit.setText(String.valueOf(Copy.getGame().getUnit()));
		contentPane.add(txtUnit);
		
		JLabel txtVersion = new JLabel("");
		txtVersion.setBounds(155, 155, 307, 14);
		txtVersion.setText(Copy.getGame().getConsole().getName() + " " + Copy.getGame().getConsole().getVersion());
		contentPane.add(txtVersion);
		
		JLabel txtName = new JLabel((String) null);
		txtName.setBounds(155, 124, 523, 14);
		txtName.setText(Copy.getGame().getName());
		contentPane.add(txtName);
		
		JLabel lblEndDate = new JLabel("End Date :");
		lblEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEndDate.setBounds(31, 181, 75, 20);
		contentPane.add(lblEndDate);
		
		JButton btnDisconnect = new JButton("");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		
		JFormattedTextField txtEndDate = new JFormattedTextField(dateFormat);
		txtEndDate.setBounds(155, 183, 113, 18);
		txtEndDate.setColumns(10);
		contentPane.add(txtEndDate);
		try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(txtEndDate);
        } catch (ParseException ex) {
            ex.getMessage();
        }
		
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setIcon(new ImageIcon(JLoan.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBorrow borrow = new JBorrow(Player);
				borrow.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(31, 222, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnLoan = new JButton("Get Loan");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EndDate = txtEndDate.getText();
				if(EndDate.trim().length() != 10)
					JOptionPane.showMessageDialog(null, "You must set a Date", "Error", JOptionPane.ERROR_MESSAGE);
				else if(Player.getAmount() < Copy.getGame().getUnit()) {
					JOptionPane.showMessageDialog(null, "You don't have enought Unit !", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					LoanBusiness loanB = new LoanBusiness();
					loanB.MakeLoan(EndDate, Player, Copy);
					JHome home = new JHome(Player);
					home.setVisible(true);
					dispose();
				}
			}
		});
		btnLoan.setBounds(557, 222, 89, 23);
		contentPane.add(btnLoan);
	}
}
