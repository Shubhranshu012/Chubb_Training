import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class LoggerTest {
    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.trace("Trace Message — Verbose details for debugging");
        logger.debug("Entering in method main");
        logger.info("Info Message — Normal flow information");
        logger.warn("Warning Message — Something might be off");
        logger.error("Error Message — Something failed");
        logger.fatal("Fatal Message — Critical system failure");

       
        try {
            String name = null;
            name.toLowerCase();
        } catch (Exception ex) {
            logger.error("Error in LoggingTest: " + ex.getMessage());
        }

        logger.debug("Leaving from method main");
    }
}
