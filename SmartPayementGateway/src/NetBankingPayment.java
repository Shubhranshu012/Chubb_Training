class NetBankingPayment extends Payment {
    private String userId;
    private String password;
    private double balance;

    public NetBankingPayment(double amount, String recipient, User obj) {
        super(amount, recipient);
        this.balance=obj.GetBalance();
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (amount <= 0) throw new InvalidAmountException("Amount cannot be 0 or negative.");
            if (amount >balance) throw new InsufficientBalanceException("Insufficient balance");
            if (!"secure123".equals(password)) throw new InvalidCredentialsException("Invalid NetBanking password.");
            System.out.println("✅ NetBanking payment of ₹" + amount + " sent to " + recipient + " from " + userId);
        } catch (Exception e) {
            throw new TransactionFailedException("NetBanking Transaction Failed.", e);
        }
    }
}