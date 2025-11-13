class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cvv;
    private double balance;
    private User obj;
    public CreditCardPayment(double amount, String recipient, String cardNumber, String cvv, User obj) {
        super(amount, recipient);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.balance = obj.GetBalance();
        this.obj=obj;
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (amount <= 0) throw new InvalidAmountException("Amount must be greater than 0.");
            if (amount > balance) throw new InsufficientBalanceException("Amount exceeds Balance");
            this.obj.Update(amount);
            
            System.out.println("Payment of " + amount + " sent to " + recipient + "Via Credit Card");
        } catch (Exception e) {
            throw new TransactionFailedException("Credit Card Transaction Failed.", e);
        }
    }
}
