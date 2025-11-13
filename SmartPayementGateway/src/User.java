
public class User {
	private String userId;
    private String pass;
    private double Current_balance;
    public User(String u, String p) {
        this.userId = u;
        this.pass = p;
        
        Current_balance=100000;
    }
    
    public double GetBalance() {
    	return this.Current_balance;
    }
    public void Update(double Amount) {
    	this.Current_balance=this.Current_balance-Amount;
    	
    }
}
