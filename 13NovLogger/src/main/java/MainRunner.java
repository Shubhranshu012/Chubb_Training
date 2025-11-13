
import org.apache.log4j.Logger;

public class MainRunner {

    private static final Logger logger = Logger.getLogger(MainRunner.class);

    public static void main(String[] args) {

        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        logger.fatal("This is a FATAL message");

    }
}