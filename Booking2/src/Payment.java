import java.util.*;

public class Payment {
    public static void main(String[] args) {
    	
    	/*
        Scanner sc = new Scanner(System.in);

        System.out.print("Baleno Model : ");
        String model = sc.next();

        System.out.print("Car Color: ");
        String y = sc.next();
        
        Car car=new Car(model,y);
        int x=car.getPrice();

        System.out.print("Loan Duration (in years): ");
        int time = sc.nextInt();

        System.out.print("Enter Rate Of Interest (%): ");
        double rate = sc.nextDouble();
        
        System.out.println("Enter DownPayment: ");
        int down=sc.nextInt();
        
        System.out.print("Enter Intrest Type(Simple or Compound): ");
        String type=sc.next();
        String type1=type.toLowerCase();
        System.out.println("\nCar Color: " + y);
        System.out.println("Car Price: "+x);
        System.out.println("Down Payment: "+down);
        switch(type1) {
        
        case "simple":
        	System.out.println("Simple Intrest: ");
        	SimpleIntrest si = new SimpleIntrest(x-down, rate, time);

            double interest = si.intrest();
            double total = si.total();

            System.out.println("Interest: ₹" + interest);
            System.out.println("Total Amount Paid: ₹" + total);

            double monthlyEmi = si.emi();
            System.out.println("Monthly EMI: ₹" + String.format("%.2f", monthlyEmi));
            break;
        case "compound":
        	System.out.println("Compound Intrest: ");
        	CompoundIntrest ci = new CompoundIntrest(x-down, rate, time);

            double interest1 = ci.interest();
            double total1 = ci.total();

            
            System.out.println("Interest: ₹" + interest1);
            System.out.println("Total Amount Paid: ₹" + total1);

            double monthlyEmi1 = ci.emi();
            System.out.println("Monthly EMI: ₹" + String.format("%.2f", monthlyEmi1));
            break;
        default:
        	System.out.println("Wrong Type");
        	break;
        }
		*/
    	
    	Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("Sunrise Hotel", 5); 

        boolean running = true;
        System.out.println("\n--- Hotel Booking Menu ---");
        System.out.println("1. Book a room");
        System.out.println("2. Release a room");
        System.out.println("3. Exit");
        while (running) {
            
            System.out.print("Enter your choice (1 or 2 or 3) : ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    hotel.bookRoom();
                    break;
                case "2":
                    hotel.releaseRoom();
                    break;
                case "3":
                    System.out.println("Thank you! Exiting booking system.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }

            if (hotel.getAvailableRooms() == 0) {
                System.out.println("All rooms are booked! Cannot book more.");
            }
        }

        sc.close();
    }
}
