public class SimpleIntrest {
    public int principle;
    public double r;
    public int time;

    public SimpleIntrest(int x, double y, int z) {
        this.principle = x;
        this.r = y;
        this.time = z;
    }

    public double intrest() {
        return (this.principle * this.r * this.time) / 100;
    }

    public double total() {
        return intrest() + principle;
    }

    public double emi() {
        double total = total();
        return total / (12 * time);  
    }
}
