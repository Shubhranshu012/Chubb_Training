
public class CompoundIntrest {

    public double principal;
    public double rate;
    public int time;
    
    public CompoundIntrest(double principal, double rate, int time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

   
    public double interest() {
        return principal * (Math.pow((1 + rate / 100), time) - 1);
    }


    public double total() {
        return principal * Math.pow((1 + rate / 100), time);
    }

 
    public double emi() {
        return total()/(time*12);
    }


}
