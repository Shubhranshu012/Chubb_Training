import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainRunner {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Ravi", 103, "TXN01", "India", "IFSC001", 45000));
        accounts.add(new Account("Anita", 101, "TXN02", "India", "IFSC002", 55000));
        accounts.add(new Account("Vijay", 102, "TXN03", "USA", "IFSC003", 25000));

        System.out.println("Original List:");
        accounts.forEach(System.out::println);

        // Sort by Account No
        Collections.sort(accounts, new AccountNoComparator());
        System.out.println("\nSorted by Account Number:");
        accounts.forEach(System.out::println);

        // Sort by Balance
        Collections.sort(accounts, new BalanceComparator());
        System.out.println("\nSorted by Balance:");
        accounts.forEach(System.out::println);

        // Sort by Account Holder Name (Comparable)
        Collections.sort(accounts);
        System.out.println("\nSorted by Account Holder Name (Comparable):");
        accounts.forEach(System.out::println);
    }
}
