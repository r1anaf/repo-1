/*
 * name: riana fazir
 * project name: HotelRunner
 * description: provides sample data to test all methods in Reservation and Hotel
 */

public class HotelRunner {
	public static void main(String[] args) {
		Hotel hilton = new Hotel(10);
		System.out.println("riana fazir");
	
		hilton.reserveRoom("Jones", 99);
		hilton.reserveRoom("Patel", 94.99);
		hilton.reserveRoom("Garcia", 94.99);
		hilton.reserveRoom("Chen", 94.99);
		
		hilton.reserveRoom("Connor", 94.99, 12);
		hilton.reserveRoom("Bryde", 107.99, 7);
		
		hilton.display();
		
		System.out.println("\nReserved Rooms Count: " 
				+ hilton.reservedRoomCount());
		
		System.out.println
			(String.format("Average Reservation Rate: $%,.2f", 
					hilton.averageRoomRate()));

	}

}
