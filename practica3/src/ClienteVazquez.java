
public class ClienteVazquez {

    private String nombre;
    protected String numeroCliente;
    // Composición con la clase actualizada
    private CuentaBancaria1945 cuentaBancaria;

    ClienteVazquez(String nombre, String numeroCliente, CuentaBancaria1945 cuentaBancaria) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.cuentaBancaria = cuentaBancaria;
    }

    // Obtener información del cliente
    public String obtenerInformacion() {
        return String.format("Cliente: %s%nNúmero de Cliente: %s%n%s",
                nombre, numeroCliente, cuentaBancaria.toString());
    }

    // Actualizar el nombre del cliente
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    // Consultar saldo
    public double consultarSaldo() {
        return cuentaBancaria.getSaldo();
    }

    // Realizar depósito
    public boolean realizarDeposito(double cantidad) {
        return cuentaBancaria.depositarDinero(cantidad);
    }

    // Realizar retiro
    public boolean realizarRetiro(double cantidad) {
        return cuentaBancaria.retirarDinero(cantidad);
    }

    // Getter para la cuenta (útil para pruebas)
    public CuentaBancaria1945 getCuentaBancaria() {
        return cuentaBancaria;
    }
}