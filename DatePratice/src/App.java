import java.util.HashSet;

import java.time.*;
import java.util.stream.*;

//Local Datetime is thread safe 
public class App {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();  
        
        int year = today.getYear();
        Month month = Month.NOVEMBER;

        
        LocalDate start = today.isBefore(LocalDate.of(year, month, 1)) 
                          ? LocalDate.of(year, month, 1) 
                          : today;

        
        LocalDate end = LocalDate.of(year, month, 30);

        start.datesUntil(end.plusDays(1))  
             .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY ||d.getDayOfWeek() == DayOfWeek.SATURDAY ||
                          d.getDayOfWeek() == DayOfWeek.SUNDAY)
             .forEach(x -> System.out.println(x));
    }
}
