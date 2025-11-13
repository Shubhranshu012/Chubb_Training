import java.util.concurrent.CompletableFuture;

public class AsyncApiService {

    public CompletableFuture<String> simulateApiCall(String data) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1500);

            String result = "API Response: " + data + " processed successfully!";

            return result; 
        });

    return future;   
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
