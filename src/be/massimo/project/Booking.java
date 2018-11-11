package be.massimo.project;

import java.time.LocalDateTime;

public class Booking {
	//	ATTRIBUTES
		private LocalDateTime BeginDateWanted;
		private Game GameWanted;
		private Borrower B;
		private LocalDateTime BookingDate;
		
	//	GET/SET
		public LocalDateTime getBeginDateWanted() {
			return this.BeginDateWanted;
		}
		
		public Game getGameWanted() {
			return this.GameWanted;
		}
		
		public Borrower getBorrower() {
			return this.B;
		}
		
		public LocalDateTime getBookingDate() {
			return this.BookingDate;
		}
		
	//	CONSTRUCTOR(S)
		public Booking(LocalDateTime beginDateWanted, Game gameWanted, Borrower borrower, LocalDateTime bookingDate) {
			this.BeginDateWanted = beginDateWanted;
			this.GameWanted = gameWanted;
			this.B = borrower;
			this.BookingDate = bookingDate;
		}
}
