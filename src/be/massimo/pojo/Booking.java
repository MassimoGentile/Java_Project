package be.massimo.pojo;

public class Booking {
	//	ATTRIBUTES
		private int Id;
		private String BeginDateWanted;
		private String BookingDate;
		private Game GameWanted;
		private Player Borrower;
		
	//	GET/SET
		public int getId() {
			return this.Id;
		}
		
		public void setId(int id) {
			this.Id = id;
		}
		
		public String getBeginDateWanted() {
			return this.BeginDateWanted;
		}
		
		public void setBeginDateWanted(String beginDateWanted) {
			this.BeginDateWanted = beginDateWanted;
		}
		
		public String getBookingDate() {
			return this.BookingDate;
		}
		
		public void setBookingDate(String bookingDate) {
			this.BookingDate = bookingDate;
		}
		
		public Game getGameWanted() {
			return this.GameWanted;
		}
		
		public void setGameWanted(Game gameWanted) {
			this.GameWanted = gameWanted;
		}
		
		public Player getBorrower() {
			return this.Borrower;
		}
		
		public void setBorrower(Player borrower) {
			this.Borrower = borrower;
		}
		
	//	CONSTRUCTOR(S)
		public Booking(String beginDateWanted, String bookingDate, Game gameWanted, Player borrower) {
			this.BeginDateWanted = beginDateWanted;
			this.BookingDate = bookingDate;
			this.GameWanted = gameWanted;
			this.Borrower = borrower;
		}
		
		public Booking(int id, String beginDateWanted, String bookingDate, Game gameWanted, Player borrower) {
			this.Id = id;
			this.BeginDateWanted = beginDateWanted;
			this.BookingDate = bookingDate;
			this.GameWanted = gameWanted;
			this.Borrower = borrower;
		}
}
