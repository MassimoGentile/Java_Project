package be.massimo.pojo;

import java.time.LocalDateTime;

public class Booking {
	//	ATTRIBUTES
		private int Id;
		private LocalDateTime BeginDateWanted;
		private LocalDateTime BookingDate;
		private Game GameWanted;
		private Player P;
		
	//	GET/SET
		public int getId() {
			return this.Id;
		}
		
		public void setId(int id) {
			this.Id = id;
		}
		
		public LocalDateTime getBeginDateWanted() {
			return this.BeginDateWanted;
		}
		
		public void setBeginDateWanted(LocalDateTime beginDateWanted) {
			this.BeginDateWanted = beginDateWanted;
		}
		
		public LocalDateTime getBookingDate() {
			return this.BookingDate;
		}
		
		public void setBookingDate(LocalDateTime bookingDate) {
			this.BookingDate = bookingDate;
		}
		
		public Game getGameWanted() {
			return this.GameWanted;
		}
		
		public void setGameWanted(Game gameWanted) {
			this.GameWanted = gameWanted;
		}
		
		public Player getPlayer() {
			return this.P;
		}
		
		public void setPlayer(Player player) {
			this.P = player;
		}
		
	//	CONSTRUCTOR(S)
		public Booking(LocalDateTime beginDateWanted, LocalDateTime bookingDate, Game gameWanted, Player player) {
			this.BeginDateWanted = beginDateWanted;
			this.BookingDate = bookingDate;
			this.GameWanted = gameWanted;
			this.P = player;
		}
}
