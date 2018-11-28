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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import be.massimo.BusinessLayer.PlayerBusiness;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Player;

public class JBook extends JFrame {

	private Player Player;
	private Copy Copy;
	private JPanel contentPane;
	private JTextField txtBeginDateWanted;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public JBook(Player player, Copy copy) {
		this.Player = player;
		this.Copy = copy;
		setTitle("Java_Project - Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 293);
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
		
		JLabel lblNewLabel_2 = new JLabel("Informations about the game");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(31, 54, 644, 23);
		contentPane.add(lblNewLabel_2);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Lender :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 88, 75, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(31, 119, 75, 20);
		contentPane.add(lblName);
		
		JLabel lblVersion = new JLabel("Version :");
		lblVersion.setHorizontalAlignment(SwingConstants.LEFT);
		lblVersion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVersion.setBounds(31, 150, 75, 20);
		contentPane.add(lblVersion);
		
		JLabel lblUnit_1 = new JLabel("Unit :");
		lblUnit_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit_1.setBounds(472, 88, 75, 20);
		contentPane.add(lblUnit_1);
		
		JLabel lblDateWanted = new JLabel("Date Wanted :");
		lblDateWanted.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateWanted.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateWanted.setBounds(31, 181, 111, 20);
		contentPane.add(lblDateWanted);
		
		JFormattedTextField txtBeginDateWanted = new JFormattedTextField(dateFormat);
		txtBeginDateWanted.setBounds(152, 183, 111, 20);
		txtBeginDateWanted.setColumns(10);
		contentPane.add(txtBeginDateWanted);
		try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(txtBeginDateWanted);
        } catch (ParseException ex) {
            ex.getMessage();
        }
		
		
		JLabel txtLender = new JLabel("");
		txtLender.setBounds(152, 93, 307, 14);
		txtLender.setText(Copy.getLender().getName() + " " + Copy.getLender().getFirstname());
		contentPane.add(txtLender);
		
		JLabel txtName = new JLabel("");
		txtName.setBounds(152, 124, 523, 14);
		txtName.setText(Copy.getGame().getName());
		contentPane.add(txtName);
		
		JLabel txtVersion = new JLabel("");
		txtVersion.setBounds(152, 155, 307, 14);
		txtVersion.setText(Copy.getGame().getConsole().getName() + " " + Copy.getGame().getConsole().getVersion());
		contentPane.add(txtVersion);
		
		JLabel txtUnit = new JLabel("");
		txtUnit.setBounds(557, 93, 113, 14);
		txtUnit.setText(String.valueOf(Copy.getGame().getUnit()));
		contentPane.add(txtUnit);
		
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.setIcon(new ImageIcon(JBook.class.getResource("/Images/logout-sign32.png")));
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
		btnBack.setBounds(31, 218, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnBookThisGame = new JButton("Book this game");
		btnBookThisGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Implementation require for the booking function
				String DateWanted = txtBeginDateWanted.getText();
				if(DateWanted.trim().length() != 10)
					JOptionPane.showMessageDialog(null, "You must set a Date", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					PlayerBusiness playerB = new PlayerBusiness();
					Player = playerB.AddBooking(Player, DateWanted, copy.getGame());
					JOptionPane.showMessageDialog(null, "Booking registered !", "Success", JOptionPane.INFORMATION_MESSAGE);
					JHome home = new JHome(Player);
					home.setVisible(true);
					dispose();
				}
			}
		});
		btnBookThisGame.setBounds(545, 218, 125, 23);
		contentPane.add(btnBookThisGame);
	}
}
