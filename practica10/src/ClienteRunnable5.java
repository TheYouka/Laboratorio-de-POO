public class ClienteRunnable5 implements Runnable {

    private CuentaCompartida cuenta;

    public ClienteRunnable5(CuentaCompartida cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        // Hará 5 retiros de 100
        for (int i = 0; i < 5; i++) {
            cuenta.operar(-100.0, Thread.currentThread().getName());
        }
    }
}