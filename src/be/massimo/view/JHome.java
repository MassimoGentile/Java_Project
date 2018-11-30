package be.massimo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import be.massimo.BusinessLayer.BookingBusiness;
import be.massimo.BusinessLayer.CopyBusiness;
import be.massimo.BusinessLayer.LoanBusiness;
import be.massimo.BusinessLayer.PlayerBusiness;
import be.massimo.pojo.Booking;
import be.massimo.pojo.Copy;
import be.massimo.pojo.Loan;
import be.massimo.pojo.Player;

public class JHome extends JFrame {

	private Player Player;
	private JPanel contentPane;
	private JTable tableBorrow;

	
	/**
	 * Create the frame.
	 */
	public JHome(Player player) {
		this.Player = player;
		setTitle("Java_Project - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 609);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblA = new JLabel("List of Games Lended");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblA.setBounds(37, 66, 644, 20);
		contentPane.add(lblA);
		
		JLabel lblListOfGames = new JLabel("List of Games Borrowed");
		lblListOfGames.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListOfGames.setBounds(37, 230, 644, 20);
		contentPane.add(lblListOfGames);
		
		JLabel lblUnitAmount = new JLabel("Unit Amount :");
		lblUnitAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnitAmount.setBounds(516, 11, 106, 32);
		contentPane.add(lblUnitAmount);
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnit.setBounds(628, 11, 50, 32);
		lblUnit.setText(String.valueOf(Player.getAmount()));
		contentPane.add(lblUnit);
		
		JLabel lblListOfGame = new JLabel("List of Games Booked");
		lblListOfGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListOfGame.setBounds(37, 394, 644, 20);
		contentPane.add(lblListOfGame);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 425, 644, 122);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPaneLend = new JScrollPane();
		scrollPaneLend.setBounds(38, 97, 644, 122);
		contentPane.add(scrollPaneLend);
		
		JScrollPane scrollPaneBorrow = new JScrollPane();
		scrollPaneBorrow.setBounds(37, 261, 644, 122);
		contentPane.add(scrollPaneBorrow);
		
		List<Copy> copyL = Player.getListCopy();
		DefaultListModel<String> modelCopy = new DefaultListModel<>();
		for(int i = 0; i < copyL.size(); i++)
			modelCopy.addElement("Name: " + copyL.get(i).getGame().getName() + " | Console: " + copyL.get(i).getGame().getConsole().getName() + " " + copyL.get(i).getGame().getConsole().getVersion() + " | Unit: " + copyL.get(i).getGame().getUnit());
		JList listLend = new JList(modelCopy);
		listLend.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLend.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					Copy copy = copyL.get(list.locationToIndex(evt.getPoint()));
					if(copy.getAvailable() == false)
						JOptionPane.showMessageDialog(null, "Error this copy is loaned, \nYou can't remove it !", "Impossible to remove now", JOptionPane.ERROR_MESSAGE);
					else {
						JRemoveCopy remCopy = new JRemoveCopy(Player, copy);
						remCopy.setVisible(true);
						dispose();
					}	
				}
			}
		});
		scrollPaneLend.setViewportView(listLend);
		
		LoanBusiness loanB = new LoanBusiness();
		List<Loan> loanL = loanB.getOwnLoan(Player.getId());
		DefaultListModel<String> modelLoan = new DefaultListModel<>();
		for(int i = 0; i < loanL.size(); i++)
			modelLoan.addElement("Game: " + loanL.get(i).getCopy().getGame().getName() + " | Console: " + loanL.get(i).getCopy().getGame().getConsole().getName() + " " + loanL.get(i).getCopy().getGame().getConsole().getVersion() +" | End Date: " + loanL.get(i).getEndDate() + " | Lender: " + loanL.get(i).getLender().getName() + " " + loanL.get(i).getLender().getFirstname());
		JList listBorrow = new JList(modelLoan);
		listBorrow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listBorrow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					Loan loan = loanL.get(list.locationToIndex(evt.getPoint()));
					JRemoveLoan remLoan = new JRemoveLoan(Player, loan);
					remLoan.setVisible(true);
					dispose();
				}
			}
		});
		scrollPaneBorrow.setViewportView(listBorrow);
		
		List<Booking> bookingL = Player.getListBokking();
		DefaultListModel<String> modelBooking = new DefaultListModel<>();
		for(int i = 0; i < bookingL.size(); i++)
			modelBooking.addElement("Game: " + bookingL.get(i).getGameWanted().getName() + " | Booking Date Wanted: " + bookingL.get(i).getBeginDateWanted());
		JList listBook = new JList(modelBooking);
		listBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listBook.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					Booking booking = bookingL.get(list.locationToIndex(evt.getPoint()));
					JRemoveBooking remBooking = new JRemoveBooking(Player, booking);
					remBooking.setVisible(true);
					dispose();
				}
			}
		});
		scrollPane.setViewportView(listBook);
		
		/*
		 * BUTTONS
		 */
		JButton btnDisconnect = new JButton("");
		btnDisconnect.setBorderPainted(false);
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLogin login = new JLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnDisconnect.setContentAreaFilled(false);
		btnDisconnect.setIcon(new ImageIcon(JHome.class.getResource("/Images/logout-sign32.png")));
		btnDisconnect.setBounds(10, 11, 32, 32);
		contentPane.add(btnDisconnect);
		
		JButton btnProfil = new JButton("");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JAlterProfil profil = new JAlterProfil(Player);
				profil.setVisible(true);
				dispose();
			}
		});
		btnProfil.setContentAreaFilled(false);
		btnProfil.setBorderPainted(false);
		btnProfil.setBackground(SystemColor.menu);
		btnProfil.setIcon(new ImageIcon(JHome.class.getResource("/Images/settings32.png")));
		btnProfil.setBounds(52, 11, 32, 32);
		contentPane.add(btnProfil);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBorrow borrow = new JBorrow(Player);
				borrow.setVisible(true);
				dispose();
			}
		});
		btnBorrow.setFocusable(false);
		btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrow.setBounds(691, 261, 127, 122);
		contentPane.add(btnBorrow);
		
		JButton btnLend = new JButton("Lend");
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLend lend = new JLend(Player);
				lend.setVisible(true);
				dispose();
			}
		});
		btnLend.setFocusable(false);
		btnLend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLend.setBounds(692, 96, 126, 62);
		contentPane.add(btnLend);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBooking.setFocusable(false);
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBooking booking = new JBooking(Player);
				booking.setVisible(true);
				dispose();
			}
		});
		btnBooking.setBounds(691, 424, 127, 123);
		contentPane.add(btnBooking);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(110, 11, 396, 32);
		lblNewLabel.setText("Welcome " + Player.getName() + " " + Player.getFirstname());
		contentPane.add(lblNewLabel);
		
		JButton btnBorrowFromBooking = new JButton("Find Borrower");
		btnBorrowFromBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listLend.isSelectionEmpty())
					JOptionPane.showMessageDialog(null, "You must select a lend !", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					BookingBusiness bookingB = new BookingBusiness();
					Booking booking = bookingB.getBooking(copyL.get(listLend.getSelectedIndex()).getGame());
					if(booking == null)
						JOptionPane.showMessageDialog(null, "No Borrower Available", "Error", JOptionPane.INFORMATION_MESSAGE);
					else {
						JContact contact = new JContact(Player, booking);
						contact.setVisible(true);
						dispose();
					}		
				}
			}
		});
		btnBorrowFromBooking.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrowFromBooking.setBounds(692, 157, 127, 62);
		contentPane.add(btnBorrowFromBooking);
	}
}
