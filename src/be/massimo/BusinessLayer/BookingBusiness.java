package be.massimo.BusinessLayer;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import be.massimo.dao.BookingDAO;
import be.massimo.dao.ConnectionAccess;
import be.massimo.pojo.Booking;
import be.massimo.pojo.Game;

public class BookingBusiness {
	
	private Connection conn;
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public BookingBusiness() {
		conn = ConnectionAccess.getInstance();
	}
		
	public List<Booking> getOwnBooking(int id){
		return new BookingDAO(conn).getOwnBooking(id);
	}
	
	public Booking getBooking(Game game) {
		BookingDAO bookingDAO = new BookingDAO(conn);
		List<Booking> list1 = bookingDAO.getAll();
		List<Booking> list2 = new ArrayList<Booking>();
		
		for(int i = 0; i < list1.size(); i++) {
			if(list1.get(i).getGameWanted().getId() == game.getId())
				list2.add(list1.get(i));
		}
		list1 = list2;
		if(list1.size() > 1) {
			Booking landMark = list1.get(0);
			list2.clear();
			for(int i = 1; i < list1.size(); i++) {
				if(list1.get(i).getBorrower().getAmount() > landMark.getBorrower().getAmount()) {
					list2.clear();	// If the landMark player have minus Unit than the new one, I clear the list and I take it as landMark
					landMark = list1.get(i);
					list2.add(landMark);
				} else if(list1.get(i).getBorrower().getAmount() == landMark.getBorrower().getAmount())
					list2.add(list1.get(i)); //If the player have the same amount as the landMark I add him into the list
			}
			list1 = list2;
			if(list1.size() > 1) {
				landMark = list1.get(0);
				list2.clear();
				for(int i = 1; i < list1.size(); i++) {
					try {
						Date date1 = dateFormat.parse(list1.get(i).getBeginDateWanted());
						Date date2 = dateFormat.parse(landMark.getBeginDateWanted());
						if(date1.after(date2)) {
							list2.clear();
							landMark = list1.get(i);
							list2.add(landMark);
						} else if(date1.equals(date2))
							list2.add(list1.get(i));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				list1 = list2;
				if(list1.size() > 1) {
					landMark = list1.get(0);
					list2.clear();
					for(int i = 1; i < list1.size(); i++) {
						try {
							Date date1 = dateFormat.parse(list1.get(i).getBorrower().getRegisterDate());
							Date date2 = dateFormat.parse(landMark.getBorrower().getRegisterDate());
							if(date1.after(date2)) {
								list2.clear();
								landMark = list1.get(i);
								list2.add(landMark);
							} else if(date1.equals(date2))
								list2.add(list1.get(i));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					list1 = list2;
					if(list1.size() > 1) {
						landMark = list1.get(0);
						list2.clear();
						for(int i = 1; i < list1.size(); i++) {
							try {
								Date date1 = dateFormat.parse(list1.get(i).getBorrower().getBirthday());
								Date date2 = dateFormat.parse(landMark.getBorrower().getBirthday());
								if(date1.after(date2)) {
									list2.clear();
									landMark = list1.get(i);
									list2.add(landMark);
								} else if(date1.equals(date2))
									list2.add(list1.get(i));
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
						list1 = list2;
						if(list1.size() > 1) {
							Random random = new Random();
							return list1.get(random.nextInt(list1.size() - 1));
						}else
							return list1.get(0);
					}else
						return list1.get(0);
				}else
					return list1.get(0);
			}else
			return list1.get(0);
		}else
			return list1.get(0);
	}
}
