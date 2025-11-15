public class Consumidor implements Runnable {
    private BufferCompartido1945 buffer;
    public Consumidor(BufferCompartido1945 buffer) { this.buffer = buffer; }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Consumirá 10 items
                buffer.consumir();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}
    }
}