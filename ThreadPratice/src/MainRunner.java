import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRunner {
    public static void main(String[] arg) {
    	/*
        Counter counter = new Counter(0);

        Thread t1 = new Thread(new Thread1(counter, "A"));
        Thread t2 = new Thread(new Thread1(counter, "B"));
        Thread t3 = new Thread(new Thread1(counter, "C"));
        Thread t4 = new Thread(new Thread1(counter, "D"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("Main thread finished starting worker threads.");
        */
    	
    	
    	
    	/*
    	Account account = new Account(100);

        Thread t1 = new Thread(() -> account.withdraw("Alice", 70));
        Thread t2 = new Thread(() -> account.withdraw("Bob", 50));

        t1.start();
        t2.start();*/
    	
    	
    	
    	/*
    	Room room = new Room(101);
        Payment pay1 = new Payment(1000);
        Payment pay2 = new Payment(1000);

        Thread t1 = new Thread(new BookingService(room, pay1, 500, "User1"));
        Thread t2 = new Thread(new BookingService(room, pay2, 500, "User2"));

        t1.start();
        t2.start();
        

		*/
    	ExecutorService pool = Executors.newFixedThreadPool(3);
    	Counter ct=  new Counter(0);
    	pool.submit(() -> ct.incr());
        pool.submit(() -> ct.incr());
        pool.submit(() -> ct.incr());
        pool.submit(() -> ct.incr());

    }
}