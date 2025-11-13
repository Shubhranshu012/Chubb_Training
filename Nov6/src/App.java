public class App {
    public static void main(String[] args) {
        AccountInfo account1 = new AccountInfo("123456789", 1000.50);
        AccountInfo account2 = new AccountInfo("123456780", 1000.50);

        System.out.println("Before Transfer:");
        System.out.println("Account 1: " + account1.accountNumber() + ", Balance: $" + account1.balance());
        System.out.println("Account 2: " + account2.accountNumber() + ", Balance: $" + account2.balance());

        App app = new App();

        // Perform transfer and get new account objects
        AccountInfo[] updatedAccounts = app.fundtransfer(account1, account2, 200.00);
        account1 = updatedAccounts[0];
        account2 = updatedAccounts[1];

        System.out.println("After Transfer:");
        System.out.println("Account 1: " + account1.accountNumber() + ", Balance: $" + account1.balance());
        System.out.println("Account 2: " + account2.accountNumber() + ", Balance: $" + account2.balance());
    }

    AccountInfo[] fundtransfer(AccountInfo from, AccountInfo to, double amount) {
        if (from.balance() >= amount) {
            double newFromBalance = from.balance() - amount;
            double newToBalance = to.balance() + amount;

            AccountInfo updatedFrom = new AccountInfo(from.accountNumber(), newFromBalance);
            AccountInfo updatedTo = new AccountInfo(to.accountNumber(), newToBalance);

            System.out.println("Transferring $" + amount + " from " + from.accountNumber() + " to " + to.accountNumber());
            return new AccountInfo[]{updatedFrom, updatedTo};
        } else {
            System.out.println("Insufficient funds in account " + from.accountNumber());
            return new AccountInfo[]{from, to}; 
        }
    }
}
