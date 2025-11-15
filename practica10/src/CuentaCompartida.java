public class CuentaCompartida {

    private double saldo = 0.0;

    /**
     * Método 'synchronized' para evitar Condiciones de Carrera.
     * Solo un hilo puede entrar aquí a la vez.
     */
    public synchronized void operar(double monto, String nombreHilo) {
        System.out.println("->" + nombreHilo + " va a operar... Saldo actual: " + saldo);

        double nuevoSaldo = this.saldo + monto;

        try {
            Thread.sleep(10); // Simula distracción
        } catch (InterruptedException e) {}

        this.saldo = nuevoSaldo;

        System.out.println("   " + nombreHilo + " operó " + monto + ". Saldo nuevo: " + this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}