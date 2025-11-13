import java.util.*;
import java.util.stream.Collectors;

public class SalesReportService {

    public List<Sale> loadSales(String filePath) {
        return FileReaderUtil.readFile(filePath).stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(arr -> new Sale(arr[0], arr[1], Double.parseDouble(arr[2])))
                .collect(Collectors.toList());
    }

    public Map<String, Double> report(List<Sale> sales) {
        return sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getRegion,
                        Collectors.summingDouble(Sale::getRevenue)
                ));
    }
}
