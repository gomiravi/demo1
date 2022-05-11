package busreserve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
	String passName;
	int busNo;
	int capacity;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter you name: ");
		passName = scanner.next();
		System.out.println("Enter bus no: ");
			busNo = scanner.nextInt();
			System.out.println("Enter No.of sheets: ");
			capacity=scanner.nextInt();
		System.out.println("Enter date DD/MM/YYYY");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		int capacity = 0;
		for(Bus bus:buses) {
			if(bus.getBusNo() == busNo)
				capacity = bus.getCapacity();
		}
		
		int booked = 0;
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
				
			}
		}
		
		return booked<capacity?true:false;
		
	}
}

