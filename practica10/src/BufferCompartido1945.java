import java.util.LinkedList;

public class BufferCompartido1945 {

    // Tamaño basado en la matrícula (1945)
    private final int LIMITE = 4; // (Usando un dígito)
    private LinkedList<Integer> buffer = new LinkedList<>();

    public synchronized void producir(int producto) throws InterruptedException {
        // Si el buffer está lleno, el productor se duerme
        while (buffer.size() == LIMITE) {
            System.out.println("Productor : Buffer lleno, voy a dormir...  (wait)");
            wait();
        }

        buffer.add(producto);
        System.out.println("Productor : Metí el producto " + producto);

        // Despierta a los consumidores dormidos
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        // Si el buffer está vacío, el consumidor se duerme
        while (buffer.isEmpty()) {
            System.out.println("Consumidor : Buffer vacío, voy a dormir...  (wait)");
            wait();
        }

        int producto = buffer.poll();
        System.out.println("Consumidor : Saqué el producto " + producto);

        // Despierta a los productores dormidos
        notifyAll();
        return producto;
    }
}