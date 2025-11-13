public class Car {
    public String variant;
    public String color;
    public int price;

    Car(String name, String color) {
        this.variant = name;
        this.color = color;

        switch (variant.toLowerCase()) {
            case "beta":
                this.price = 800000;
                break;
            case "alfa":
                this.price = 1000000;
                break;
            default:
                this.price = 1200000; 
                break;
        }
    }

    public int getPrice() {
    	return this.price;
    }


}
