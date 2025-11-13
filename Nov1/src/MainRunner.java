
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainRunner {
	
	
    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    
    
    public void startProcessing() {
        
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    Order order = orderQueue.poll();
                    if (order != null) {
                        processOrder(order);
                    }
                }
            });
        }
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    private void processOrder(Order order) {
        
        System.out.println("Processing order: " + order.getId() + " by " + Thread.currentThread().getName());
        
    }
    
 public static void main(String[] args) {
        MainRunner system = new MainRunner();

        system.startProcessing();

        
        for (int i = 0; i < 20; i++) {
            system.addOrder(new Order());
        }
        var x=100;
        System.out.println(x);
    
        system.executor.shutdown();
        
        List<String> lt=new ArrayList<>();
        lt.add("Hello");
        lt.add("Nerrfwe");
       
    }
}
