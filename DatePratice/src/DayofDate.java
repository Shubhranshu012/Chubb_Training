import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.time.DayOfWeek;
import java.util.Scanner;

class DayOfDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter date (yyyy-mm-dd): ");
        String input = scanner.nextLine();
        
        LocalDate date = LocalDate.parse(input);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        
        System.out.println("Day of the week: " + dayOfWeek);




        //formate
        LocalDate today = LocalDate.now();
        System.out.println("Today is: " + today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter); 
        System.out.println("Formatted date: " + formattedDate);



        System.out.println("Hello".hashCode());

    }
}
