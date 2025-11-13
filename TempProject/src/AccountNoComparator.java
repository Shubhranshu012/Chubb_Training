import java.util.Comparator;

class AccountNoComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        if (a1.accountNo > a2.accountNo)
            return 1;
        else if (a1.accountNo < a2.accountNo)
            return -1;
        else
            return 0;
    }

}