import java.util.*;

public class SmartPaymentGateway {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        

        Login login = new Login(userId, password);
        if (!login.authenticate()) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Login Successful!\n");
        User curr=new User(userId,password);
        

        System.out.print("Enter recipient name: ");
        String recipient = sc.nextLine();
        try {
        	ToBeSent t1 = new ToBeSent("Charlie");
            t1.check();
        }
        catch(NotFoundException e){
        	System.err.println("Wrong Recipient: ");
        	return ;
        }

        System.out.print("Enter payment method (CreditCard / UPI / Wallet / NetBanking): ");
        String method = sc.nextLine();

        System.out.print("Enter amount to send: ₹");
        double amount = sc.nextDouble();
        sc.nextLine(); 

        Payment payment = null;

        try {
            switch (method.toLowerCase()) {
                case "creditcard":
                    System.out.print("Enter Card Number: ");
                    String cardNumber = sc.nextLine();
                    System.out.print("Enter CVV: ");
                    String cvv = sc.nextLine();
                    payment = new CreditCardPayment(amount, recipient, cardNumber, cvv,curr);
                    break;
                case "upi":
                    payment = new UPIPayment(amount, recipient, curr);
                    break;
                case "wallet":
                    payment = new WalletPayment(amount, recipient, curr);
                    break;
                case "netbanking":
                    payment = new NetBankingPayment(amount, recipient,curr);
                    break;
                default:
                    System.out.println("❌ Invalid payment method.");
                    return;
            }

            payment.processPayment();

        } catch (TransactionFailedException e) {
            System.err.println("Transaction Failed: " + e.getCause().getMessage());
        }

        System.out.println("End of Transaction");
        sc.close();
    }
}