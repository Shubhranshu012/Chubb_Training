public class MainClass {
    public static void main(String[] args) {
        try {
            DeliveryManagementSystem dms = new DeliveryManagementSystem(3);

            
            dms.addAgent(new Agent("Alice", "New York", 3));
            dms.addAgent(new Agent("Bob", "New York", 3));
            dms.addAgent(new Agent("Charlie", "Los Angeles", 2));

            
            dms.addPackage(new Package("PKG1", "New York", "HIGH"));
            dms.addPackage(new Package("PKG2", "New York", "LOW"));
            dms.addPackage(new Package("PKG3", "Los Angeles", "HIGH"));
            dms.addPackage(new Package("PKG4", "New York", "MEDIUM"));

            
            dms.assignPackages();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}