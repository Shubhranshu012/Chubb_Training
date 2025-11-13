
class BookingService implements Runnable {
    private Room room;
    private Payment payment;
    private double amount;
    private String user;

    public BookingService(Room room, Payment payment, double amount, String user) {
        this.room = room;
        this.payment = payment;
        this.amount = amount;
        this.user = user;
    }

    
    public void run() {
        
        if (user.equals("User1")) {
            synchronized (room) {
                System.out.println(user + " locked room " + room.getRoomId());
                
                synchronized (payment) {
                    System.out.println(user + " locked payment and booked room.");
                    if (!room.isBooked() && payment.pay(amount)) {
                        room.book();
                        System.out.println(user + " successfully booked room!");
                    } else {
                        System.out.println(user + " failed to book room.");
                    }
                }
            }
        } else {
            synchronized (payment) {
                System.out.println(user + " locked payment first.");

                synchronized (room) {
                    System.out.println(user + " locked room " + room.getRoomId());
                    if (!room.isBooked() && payment.pay(amount)) {
                        room.book();
                        System.out.println(user + " successfully booked room!");
                    } else {
                        System.out.println(user + " failed to book room.");
                    }
                }
            }
        }
    }
}
