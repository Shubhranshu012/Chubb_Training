import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParserService {

    public Map<String, Long> countErrors(String logPath) {

        List<String> lines = FileReaderUtil.readFile(logPath);

        Stream<String> errorLines = lines.stream()
                .filter(line -> line.contains("ERROR"));

        Stream<String> dates = errorLines
                .map(line -> line.substring(0, 10));

        Map<String, Long> result = dates.collect(
                Collectors.groupingBy(
                        date -> date,
                        Collectors.counting()
                )
        );

        return result;
    }
}
