import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        SalesReportService salesService = new SalesReportService();
        LogParserService logService = new LogParserService();
        AsyncApiService apiService = new AsyncApiService();

        logger.info("start");
        logger.error("Testing");
        logger.error("error");

       
        System.out.println(" SALES REPORT ");
        List<Sale> sales = salesService.loadSales(
                "C:/Users/KIIT/eclipse-workspace/Nov8WeeklyAssignment/src/main/java/sales.csv"
        );

        Map<String, Double> report = salesService.report(sales);

        report.forEach((region, total) -> System.out.println(region + " => " + total));

       
        System.out.println("Async call");
        apiService.simulateApiCall("Sales Upload").thenAccept(System.out::println).join();

        System.out.println("Report");
        
		
		Map<String, Long> logReport = logService.countErrors("logs/app.log");
		
		logReport.forEach((date, count) ->
		        System.out.println(date + " => " + count + " errors")
		);
		logger.info("Completed");
    }
}
