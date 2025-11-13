abstract class Payment {
    protected double amount;
    protected String recipient;

    public Payment(double a, String r) {
        this.amount = a;
        this.recipient = r;
    }

    public abstract void processPayment() throws TransactionFailedException;
}
