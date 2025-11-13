

import java.util.*;
import Exception_handle.InvalidInputException;

public class MainRunner {
	private static double getValidatedDouble(Scanner sc) throws InvalidInputException {
        try {
            double value = sc.nextDouble();
            if (value < 0 || value > 100)
                throw new InvalidInputException("Grade must be between 0 and 100.");
            return value;
        } catch (InputMismatchException e) {
            sc.nextLine(); 
            throw new InvalidInputException("Grade must be a valid numeric value.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        while (true) {
            try {
                System.out.println("\n=== Student Grade Tracker ===");
                System.out.println("1. Add Student");
                System.out.println("2. Enter/Update Grades");
                System.out.println("3. View All Students");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();
                        tracker.addStudent(name);
                        break;

                    case 2:
                        System.out.print("Enter student name: ");
                        String sName = sc.nextLine();

                        System.out.print("Enter Maths grade: ");
                        double maths = getValidatedDouble(sc);

                        System.out.print("Enter Science grade: ");
                        double science = getValidatedDouble(sc);

                        System.out.print("Enter English grade: ");
                        double english = getValidatedDouble(sc);

                        tracker.updateGrades(sName, maths, science, english);
                        break;

                    case 3:
                        tracker.viewAll();
                        break;

                    case 4:
                        System.out.println("Program End");
                        sc.close();
                        return;

                    default:
                        throw new InvalidInputException("Invalid menu choice. Please select between 1 and 4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type! Please enter numbers for grades or menu choices.");
                
                sc.nextLine();
                
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
    }
    
    
}