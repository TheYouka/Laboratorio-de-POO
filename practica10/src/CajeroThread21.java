public class CajeroThread21 extends Thread {

    private CuentaCompartida cuenta;

    public CajeroThread21(CuentaCompartida cuenta, String nombre) {
        super(nombre); // Da un nombre al hilo
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        // Hará 5 depósitos de 100
        for (int i = 0; i < 5; i++) {
            cuenta.operar(100.0, this.getName());
        }
    }
}