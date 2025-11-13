import Exception_pkg.InvalidPackageException;

class Package {
    private String id;
    private String destinationCity;
    private String priority; 
    
    
    public Package(String id, String destinationCity, String priority) throws InvalidPackageException {
        if (id == null || destinationCity == null || priority == null ||
            (!priority.equals("HIGH") && !priority.equals("MEDIUM") && !priority.equals("LOW"))) {
            throw new InvalidPackageException("Invalid package data");
        }
        this.id = id;
        this.destinationCity = destinationCity;
        this.priority = priority;
    }

    public String getId() { return id; }
    public String getDestinationCity() { return destinationCity; }
    public String getPriority() { return priority; }

    
    public String toString() {
        return id;
    }
}