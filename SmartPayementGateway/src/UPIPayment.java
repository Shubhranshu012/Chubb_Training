
class UPIPayment extends Payment {
	private double balance;
    public UPIPayment(double amount, String recipient,User obj) {
        super(amount, recipient);
        this.balance=obj.GetBalance();
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (amount <= 0) throw new InvalidAmountException("Invalid UPI Amount: " + amount);
            if (amount > balance)
                throw new InsufficientBalanceException("Insufficient balance");
            System.out.println("Payment of ₹" + amount + " sent to " + recipient+" Via UPI");
        } catch (Exception e) {
            throw new TransactionFailedException("UPI Transaction Failed.", e);
        }
    }
}
