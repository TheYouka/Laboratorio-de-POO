import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear cuentas bancarias (usando la clase correcta)
        CuentaBancaria1945 cuenta1 = new CuentaBancaria1945("123456", 1000.0, 1234, "Juan Perez");
        CuentaBancaria1945 cuenta2 = new CuentaBancaria1945("654321", 2500.0, 5678, "Maria Lopez");

        // Crear clientes (usando la clase correcta)
        ClienteVazquez cliente1 = new ClienteVazquez("Juan Perez", "C001", cuenta1);
        ClienteVazquez cliente2 = new ClienteVazquez("Maria Lopez", "C002", cuenta2);

        // Lista de clientes
        List<ClienteVazquez> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        // Mostrar información de los clientes
        for (ClienteVazquez cliente : clientes) {
            System.out.println(cliente.obtenerInformacion());
            System.out.println("----------");
        }

        // Realizar operaciones
        System.out.println("\nRealizando operaciones...");
        cliente1.realizarDeposito(500.0);

        // Intento de retiro exitoso (300 < 1945)
        boolean retiro1 = cliente2.realizarRetiro(300.0);
        System.out.println("Retiro 1 (300.0) de Maria: " + (retiro1 ? "Exitoso" : "Fallido"));

        // Intento de retiro fallido (2000 > 1945)
        boolean retiro2 = cliente2.realizarRetiro(2000.0);
        System.out.println("Retiro 2 (2000.0) de Maria: " + (retiro2 ? "Exitoso" : "Fallido (Supera límite 1945)"));


        // Mostrar saldos después de las operaciones
        System.out.println("\nSaldos finales:");
        System.out.println("Saldo de " + cliente1.numeroCliente + ": " + cliente1.consultarSaldo());
        System.out.println("Saldo de " + cliente2.numeroCliente + ": " + cliente2.consultarSaldo());
    }
}