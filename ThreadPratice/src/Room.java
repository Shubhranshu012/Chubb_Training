class Room {
    private final int roomId;
    private boolean isBooked = false;

    public Room(int roomId) {
        this.roomId = roomId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        isBooked = true;
    }

    public int getRoomId() {
        return roomId;
    }
}