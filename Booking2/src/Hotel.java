public class Hotel {
    private String name;
    static private int totalRooms;
    private int availableRooms;

    public Hotel(String name, int totalRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
    }

    
    public boolean bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
            System.out.println("\nRoom booked Available rooms: " + availableRooms+"\n");
            return true;
        } else {
            System.out.println("\nNo rooms available to book.");
            return false;
        }
    }

    
    public boolean releaseRoom() {
        if (availableRooms < totalRooms) {
            availableRooms++;
            System.out.println("Room released Available rooms: " + availableRooms);
            return true;
        } else {
            System.out.println("All rooms are already free.");
            return false;
        }
    }

    
    public int getAvailableRooms() {
        return availableRooms;
    }
}
