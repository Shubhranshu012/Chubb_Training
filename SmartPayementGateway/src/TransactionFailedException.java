

public class TransactionFailedException extends Exception {
    public TransactionFailedException(String message, Exception cause) {
        super(message, cause);
    }
}