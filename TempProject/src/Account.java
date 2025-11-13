import java.util.*;

// Account class implementing Comparable (by accountholdername)
class Account implements Comparable<Account> {
    String accountHolderName;
    long accountNo;
    String transCode;
    String country;
    String ifscCode;
    double balance;

    public Account(String accountHolderName, long accountNo, String transCode,
                   String country, String ifscCode, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        this.transCode = transCode;
        this.country = country;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }

    public int compareTo(Account other) {
        return this.accountHolderName.compareToIgnoreCase(other.accountHolderName);
    }

 
    public String toString() {
        return "Account{" +
                "Name='" + accountHolderName + '\'' +
                ", AccNo=" + accountNo +
                ", Balance=" + balance +
                '}';
    }
}



