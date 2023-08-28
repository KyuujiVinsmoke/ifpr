import java.util.concurrent.*;

public class WikiMultiThreadsExemplo {
    public static void main(String[] args) {
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            int finalI = i;
            executor.submit(() -> {
                System.out.println("Thread " + finalI + " executando.");
                // Simulação de processamento
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + finalI + " concluída.");
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas as threads concluídas.");
    }
}