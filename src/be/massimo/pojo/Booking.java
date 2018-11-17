package be.massimo.pojo;

import java.time.LocalDateTime;

public class Booking {
	//	ATTRIBUTES
		private int Id;
		private LocalDateTime BeginDateWanted;
		private Game GameWanted;
		private Player P;
		private LocalDateTime BookingDate;
		
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
		
		public Game getGameWanted() {
			return this.GameWanted;
		}
		
		public Player getPlayer() {
			return this.P;
		}
		
		public LocalDateTime getBookingDate() {
			return this.BookingDate;
		}
		
	//	CONSTRUCTOR(S)
		public Booking(LocalDateTime beginDateWanted, Game gameWanted, Player player, LocalDateTime bookingDate) {
			this.BeginDateWanted = beginDateWanted;
			this.GameWanted = gameWanted;
			this.P = player;
			this.BookingDate = bookingDate;
		}
}
