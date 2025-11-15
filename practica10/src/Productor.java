public class Productor implements Runnable {
    private BufferCompartido1945 buffer;
    public Productor(BufferCompartido1945 buffer) { this.buffer = buffer; }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Producirá 10 items
                buffer.producir(i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {}
    }
}