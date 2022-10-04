package lab3;
import java.util.Scanner;
public class PlaneApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option;
		int choice;
		int seatID;
		int customerID;
		Plane plane = new Plane();
		Scanner sc = new Scanner(System.in);
		System.out.println("(1) Show number of empty seats\r\n"
				+ "(2) Show the list of empty seats\r\n"
				+ "(3) Show the list of seat assignments by seat ID\r\n"
				+ "(4) Show the list of seat assignments by customer ID\r\n"
				+ "(5) Assign a customer to a seat\r\n"
				+ "(6) Remove a seat assignment\r\n"
				+ "(7) Exit");
		do {
				System.out.println("Enter the number of your choice: ");
				choice = sc.nextInt();
					switch(choice)
					{
					case 1: plane.showNumEmptySeats();
							break;
					case 2: plane.showEmptySeats();
							break;
					case 3: plane.showAssignedSeat(true);
							break;
					case 4: plane.showAssignedSeat(false);
							break;
					case 5: System.out.println("Assigning Seat ..");
							System.out.println("Please enter SeatID: ");
							seatID = sc.nextInt();
							System.out.println("Please enter Customer ID: ");
							customerID = sc.nextInt();
							plane.assignSeat(seatID, customerID);
							break;
					case 6: System.out.println("Enter SeatID to unassign customer from: ");
							seatID = sc.nextInt();
							plane.unAssignSeat(seatID);
							break;
					}
					
			}while(choice<7);
	}
}
