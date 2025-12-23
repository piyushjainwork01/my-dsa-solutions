package interview;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(2000);
                    return "Fetched User Data";
                }, executor);

        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "Fetched Transactions";
                }, executor);
        CompletableFuture<Void> combined =
                CompletableFuture.allOf(f1, f2);
        combined.join();

        System.out.println(f1.join());
        System.out.println(f2.join());

        executor.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {
        }
    }

}
