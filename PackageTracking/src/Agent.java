import Exception_pkg.OverloadException;
import java.util.*;
class Agent {
    private String name;
    private String city;
    private int maxLoad;
    private List<Package> assignedPackages = new ArrayList<>();

    public Agent(String name, String city, int maxLoad) {
        this.name = name;
        this.city = city;
        this.maxLoad = maxLoad;
    }

    public String getCity() { return city; }
    public List<Package> getAssignedPackages() { return assignedPackages; }

    public void assignPackage(Package pkg) throws OverloadException {
        if (assignedPackages.size() >= maxLoad) {
            throw new OverloadException("Agent " + name + " cannot take more packages.");
        }
        assignedPackages.add(pkg);
    }

    
    public String getName() {
        return name;
    }
}