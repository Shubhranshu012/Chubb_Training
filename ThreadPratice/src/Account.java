class Account {
    private int balance;

    Account(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(String user, int amount) {
        if (balance >= amount) {
            System.out.println(user + " is trying to withdraw $" + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(user + " completed withdrawal. Remaining balance: $" + balance);
        } else {
            System.out.println(user + " cannot withdraw $" + amount + " (Insufficient balance: $" + balance + ")");
        }
    }
}
