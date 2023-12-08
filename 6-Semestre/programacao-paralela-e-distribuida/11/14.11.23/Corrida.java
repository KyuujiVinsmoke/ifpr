import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Classe representando um microsserviço
class MicroService implements Runnable {
    private String serviceName;

    // Construtor que recebe o nome do microsserviço
    public MicroService(String serviceName) {
        this.serviceName = serviceName;
    }

    // Método run() é chamado quando a Thread inicia
    @Override
    public void run() {
        // Simulando a lógica do microsserviço
        System.out.println("Microsserviço " + serviceName + " iniciado.");

        // Lógica do microsserviço
        for (int i = 0; i < 5; i++) {
            System.out.println("Microsserviço " + serviceName + " realizando ação " + i);
            try {
                Thread.sleep(1000); // Simulando uma operação demorada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Microsserviço " + serviceName + " concluído.");
    }
}

// Classe principal
public class Corrida {
    public static void main(String[] args) {
        // Criando um pool de threads para executar os microsserviços
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Criando instâncias dos microsserviços
        MicroService service1 = new MicroService("Serviço1");
        MicroService service2 = new MicroService("Serviço2");
        MicroService service3 = new MicroService("Serviço3");

        // Submetendo os microsserviços para execução no pool de threads
        executorService.submit(service1);
        executorService.submit(service2);
        executorService.submit(service3);

        // Encerrando o pool de threads após a conclusão dos microsserviços
        executorService.shutdown();
    }
}