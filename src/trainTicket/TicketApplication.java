package trainTicket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TicketApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k=new Scanner(System.in);
		System.out.println("Enter the train number: ");
		int trainNo=k.nextInt();
		k.nextLine();
		Train t=null;
		try {
			t=TrainDAO.findTrain(trainNo);
		}
		catch(Exception e) {
			System.out.println("Train with given number does not exist");
			System.exit(0);
		}
		System.out.println("Enter Travel Date: ");
		String dateString=k.nextLine();
		Date date=new Date();
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ticket ticket=new Ticket(date,t);
		System.out.println("Enter Number of Passengers: ");
		int pCount=k.nextInt();
		k.nextLine();
		int i=1;
		while(i<=pCount) {
			System.out.println("Enter Passenger Name: ");
			String name=k.nextLine();
			System.out.println("Enter Age: ");
			int age=k.nextInt();
			k.nextLine();
			if(age<0) {
				throw new IllegalArgumentException("Age cannot be negative.");
			}
			System.out.println("Enter Gender(M/F): ");
			char gender=k.nextLine().toCharArray()[0];
			if((gender=='M')||(gender=='m')||(gender=='F')||(gender=='f')) {
				ticket.addPassenger(name, age, gender);
			}
			else {
				throw new IllegalArgumentException("Gender should be M or F.");
			}
			
			i++;
		}
		ticket.writeTicket();
		//Output
		System.out.println("Ticket Booked with PNR: "+ticket.getPnr());
		
	}

}
