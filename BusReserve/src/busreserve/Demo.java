package busreserve;
import java.util.Scanner;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		
	
		ArrayList<Bus> buses = new ArrayList<Bus>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		buses.add(new Bus(1,true,22));
		buses.add(new Bus(2,false,38));
		buses.add(new Bus(3,true,37));
		
		int userClick = 1;
		Scanner scanner = new Scanner(System.in);
		
		for(Bus b:buses) {
			b.displayBusInfo();
		}
		
		while(userClick==1) {
			System.out.println("Enter 1 to Book and 2 to exit");
			userClick = scanner.nextInt();
			if(userClick == 1) {
				Booking booking = new Booking();
				if(booking.isAvailable(bookings,buses)) {
					bookings.add(booking);
					System.out.println("Your booking is sucessful");
				}
				else
					System.out.println("Sorry. Bus is full.  So Try another bus or date.");
			}
		}
	}

}


