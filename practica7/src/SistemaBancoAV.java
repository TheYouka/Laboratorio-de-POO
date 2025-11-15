import java.util.HashMap;

public class SistemaBancoAV {

    // Un mapa simple para simular [ID_Usuario, Saldo]
    private HashMap<String, Double> cuentas;

    public SistemaBancoAV() {
        this.cuentas = new HashMap<>();
        this.cuentas.put("Alberto1945", 2000.0);
    }

    public void retirarDinero(String idUsuario, double monto)
            throws Saldo5InsuficienteException, Usuario1945NoEncontradoException {

        // Primero, validamos si el usuario existe
        if (!this.cuentas.containsKey(idUsuario)) {
            // ¡Lanzamos nuestra alarma de usuario!
            throw new Usuario1945NoEncontradoException("El usuario " + idUsuario + " no existe.");
        }

        double saldoActual = this.cuentas.get(idUsuario);

        // Segundo, validamos si tiene saldo
        if (monto > saldoActual) {
            // ¡Lanzamos nuestra alarma de saldo!
            throw new Saldo5InsuficienteException("Saldo insuficiente. Tienes " + saldoActual + " e intentas retirar " + monto);
        }

        // Si todo bien, restamos
        this.cuentas.put(idUsuario, saldoActual - monto);
        System.out.println("Retiro exitoso de " + monto + " para " + idUsuario);
    }

    public double getSaldo(String idUsuario) {
        return this.cuentas.getOrDefault(idUsuario, 0.0);
    }
}