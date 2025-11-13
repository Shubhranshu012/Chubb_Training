class Payment {
    private double balance;

    public Payment(double balance) {
        this.balance = balance;
    }

    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

