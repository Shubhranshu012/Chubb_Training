
import java.io.*;
import java.util.*;


public class FileHandling2 {
    public static void main(String[] args) {
    	String fileName = "C:\\Users\\manoj\\OneDrive\\Desktop\\Names.txt.txt";

        List<Transfer> transfers = new ArrayList<>();
        double totalPaidByHDFC = 0;

        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) continue; 

                String[] parts = line.split(",");

                if (parts.length != 11) continue; 

                
                String senderName = parts[0];
                String senderCountry = parts[1];
                long senderAccNo = Long.parseLong(parts[2]);
                String senderIfsc = parts[3];
                double senderBalance = Double.parseDouble(parts[4]);
                double transferAmt = Double.parseDouble(parts[5]);
                String transCode = parts[6];

                
                String receiverName = parts[7];
                String receiverCountry = parts[8];
                long receiverAccNo = Long.parseLong(parts[9]);
                String receiverIfsc = parts[10];

                
                Account sender = new Account(senderName, senderAccNo, transCode, senderCountry, senderIfsc, senderBalance);
                Account receiver = new Account(receiverName, receiverAccNo, transCode, receiverCountry, receiverIfsc, 0);

                
                if (transferAmt > 0 && sender.balance >= transferAmt) {
                    sender.balance -= transferAmt;
                    receiver.balance += transferAmt;
                    transfers.add(new Transfer(sender, receiver, transferAmt, transCode));

                    if (sender.ifscCode.startsWith("HDFC"))
                        totalPaidByHDFC += transferAmt;
                } else {
                    System.out.println("Transfer failed for " + sender.accountHolderName+ " to " + receiver.accountHolderName);
                }
            }

            sc.close();

            System.out.println("Successful Transfers:");
            for (Transfer t : transfers) {
                System.out.println(t.sender.accountHolderName + " to " + t.receiver.accountHolderName +" | Amount: " + t.transferAmount);
            }

            System.out.println("\n Total paid from HDFC Bank: " + totalPaidByHDFC);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}