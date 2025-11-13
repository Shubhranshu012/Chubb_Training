public class Sale {
    private final String region;
    private final String product;
    private final double revenue;

    public Sale(String region, String product, double revenue) {
        this.region = region;
        this.product = product;
        this.revenue = revenue;
    }

    public String getRegion() { return region; }
    public String getProduct() { return product; }
    public double getRevenue() { return revenue; }
}