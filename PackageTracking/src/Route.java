class Route {
    private String sourceCity;
    private String destinationCity;

    public Route(String sourceCity, String destinationCity) {
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
    }

    public String getSourceCity() { return sourceCity; }
    public String getDestinationCity() { return destinationCity; }
}