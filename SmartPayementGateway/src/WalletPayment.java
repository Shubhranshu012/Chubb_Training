class WalletPayment extends Payment {
    private double walletBalance;

    public WalletPayment(double amount, String recipient,User obj) {
        super(amount, recipient);
        this.walletBalance = obj.GetBalance();
        
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (amount <= 0) throw new InvalidAmountException("Wallet amount cannot be negative or zero.");
            if (amount > walletBalance)
                throw new InsufficientBalanceException("Insufficient balance. Wallet: ₹" + walletBalance);
            walletBalance -= amount;
            System.out.println("Payment of " + amount + " sent to " + recipient + "Via Wallet");
        } catch (Exception e) {
            throw new TransactionFailedException("Wallet Transaction Failed.", e);
        }
    }
}
