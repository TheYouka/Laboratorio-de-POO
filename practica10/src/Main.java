import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    // 5. Programa principal
    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- 1. Demo Simulador de Banco (synchronized) ---");

        CuentaCompartida cuenta = new CuentaCompartida();

        CajeroThread21 cajero1 = new CajeroThread21(cuenta, "Cajero-Deposita");
        Thread cliente1 = new Thread(new ClienteRunnable5(cuenta), "Cliente-Retira");

        cajero1.start();
        cliente1.start();

        // Se espera a que los hilos terminen
        cajero1.join();
        cliente1.join();

        System.out.println("SALDO FINAL (Debe ser 0.0): " + cuenta.getSaldo());
        System.out.println("-------------------------------------------------");


        System.out.println("\n--- 2. Demo Productor-Consumidor (wait/notify) ---");
        System.out.println("--- 4.3 Usando un ExecutorService ---"); //

        BufferCompartido1945 buffer = new BufferCompartido1945();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Se envían las tareas (Productor y Consumidor) al pool
        executor.submit(new Productor(buffer));
        executor.submit(new Consumidor(buffer));

        // Se apaga el pool (no acepta más tareas)
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("¡Productor y Consumidor terminaron!");
    }
}