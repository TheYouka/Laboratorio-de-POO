import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // (El archivo 'log_banco_av.txt' se creará solo)
        try (LoggerBanco logger = new LoggerBanco("log_banco_av.txt")) {

            SistemaBancoAV banco = new SistemaBancoAV();

            // Intento 1: Retiro Exitoso
            intentarRetiro(banco, logger, "Alberto1945", 500.0);

            // Intento 2: Error de Saldo Insuficiente
            intentarRetiro(banco, logger, "Alberto1945", 3000.0);

            // Intento 3: Error de Usuario No Encontrado
            intentarRetiro(banco, logger, "UsuarioFalso", 100.0);

        } catch (IOException e) {
            // Este catch es para el Logger (si no puede escribir el archivo)
            System.out.println("Error grave al escribir el log: " + e.getMessage());
        }
    }

    public static void intentarRetiro(SistemaBancoAV banco, LoggerBanco logger, String id, double monto) throws IOException {
        System.out.println("\nIntentando retirar " + monto + " de " + id);
        try {

            banco.retirarDinero(id, monto);
            logger.log("ÉXITO: Retiro de " + monto + " por " + id);

        } catch (Saldo5InsuficienteException e) {
            // Atrapamos nuestra alarma de saldo
            System.out.println("Error detectado: " + e.getMessage());
            logger.log("FALLA (Saldo): " + e.getMessage());

        } catch (Usuario1945NoEncontradoException e) {
            // Atrapamos nuestra alarma de usuario
            System.out.println("Error detectado: " + e.getMessage());
            logger.log("FALLA (Usuario): " + e.getMessage());

        } catch (ExceptionVazquezBase e) {
            // Atrapamos cualquier otra alarma "Vazquez"
            System.out.println("Otro error del banco: " + e.getMessage());
            logger.log("FALLA (General): " + e.getMessage());
        }
    }
}