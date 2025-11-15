import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

// Implementa AutoCloseable para que try-with-resources funcione
public class LoggerBanco implements AutoCloseable {

    private FileWriter writer;

    public LoggerBanco(String nombreArchivo) throws IOException {
        this.writer = new FileWriter(nombreArchivo, true); // true para que añada al final
        log("--- Log iniciado por Alberto Vazquez (1945) ---");
    }

    public void log(String mensaje) throws IOException {
        String timestamp = LocalDateTime.now().toString();
        this.writer.write(timestamp + " | " + mensaje + "\n");
    }

    @Override
    public void close() throws IOException {
        log("--- Log finalizado ---");
        this.writer.close();
        System.out.println("(Logger cerrado automáticamente)");
    }
}