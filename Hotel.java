/*
 * name: riana fazir
 * project name: Hotel
 * description: methods for taking reservations, and running reports to provide certain information
 */


/**
 * Stores reservation objects in an array with room numbers as indexes.
 */
public class Hotel {
	/*
	 * list[] stores reservations for each room. The index is the room number. All
	 * elements are null at the beginning.
	 */
	private Reservation[] list;

	public Hotel(int numbRooms) {
		list = new Reservation[numbRooms];
	}

	// Displays room numbers and reservation information.
	public void display() {
		System.out.println("\nreservation and availibity list");
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null)
				System.out.println(String.format("Room " + i + " " + list[i].getName() + "\t$%,.2f", list[i].getRate()));
			else 
				System.out.println("Room " + i + " null");
		}

	}

	// returns true if room is occupied
	public boolean isOccupied(int room) {

		if (list[room] == null)
			return false;
		return true;

	}

	/*
	 * Assigns a new Reservation to an designated room. If room is occupied, find
	 * the first available room in the array Print out reservation with room number
	 * or indicate that hotel is full
	 */
	public void reserveRoom(String name, double rate) {
		for (int i = 0; i < list.length; i++) {
			if (!(isOccupied(i))) {
				System.out.println(String.format("Reservation confirmed: " + name + " $%,.2f room: " + i + "\n", rate));
				list[i] = new Reservation(name, rate);
				break;
			}
		}
	}

	public void reserveRoom(String name, double rate, int room) {
		if (room >= list.length) {

			System.out.println("\nreservation for " + name + " could not be made for room " + room
					+ ".\nthe highest room is #9.\nthe reservation will be made for the first available room.");

			for (int i = 0; i < list.length; i++) {

				if (!(isOccupied(i))) {
					System.out.println(String.format("Reservation confirmed: " + name + " $%,.2f room: " + i + "\n", rate));
					list[i] = new Reservation(name, rate);
					break;
				}
			}
			
		} else if (!(isOccupied(room))) {

			System.out.println(String.format("Reservation confirmed: " + name + " $%,.2f room: " + room + "\n", rate));
			list[room] = new Reservation(name, rate);
		}
		
		else {
			for (int i = 0; i < list.length; i++) {
				if (!(isOccupied(i))) {
					System.out.println(String.format("Reservation confirmed: " + name + " $%,.2f room: " + i + "\n", rate));
					list[i] = new Reservation(name, rate);
					break;
				}
			}
		}

	}

	// Find and return number of rooms with a reservation
	public int reservedRoomCount() {
		int ct = 0;
		for (int i = 0; i<list.length; i++) {
			if (list[i] != null)
				ct++;
		}
		return ct;
	}

	// find and return the average room rate of the occupied rooms.
	public double averageRoomRate() {
		double sum = 0;
		int count = 0;
		for (int i =0; i< list.length; i++) {
			if (list[i] != null) {
				sum += list[i].getRate();
				count++;
			}
		}
		return sum/count;

	}
}
