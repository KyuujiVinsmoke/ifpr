import java.util.concurrent.*;

public class PromiseResolveExemplo {
    public static void main(String[] args) {
        CompletableFuture<String> promise = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                promise.complete("Tarefa concluída!");
            } catch (InterruptedException e) {
                promise.completeExceptionally(e);
            }
        });

        thread.start();

        promise.thenAccept(result -> {
            System.out.println("Promise resultado: " + result);
        });

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}