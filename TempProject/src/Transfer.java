
public class Transfer {
    Account sender;
    Account receiver;
    double transferAmount;
    String transType;

    public Transfer(Account sender, Account receiver, double transferAmount, String transType) {
        this.sender = sender;
        this.receiver = receiver;
        this.transferAmount = transferAmount;
        this.transType = transType;
    }
}