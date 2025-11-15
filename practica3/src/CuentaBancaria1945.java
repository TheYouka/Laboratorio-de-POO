public class CuentaBancaria1945 {

    private String numeroDeCuenta;
    private double saldo;
    private int nip;
    private String nombreDelTitular;

    private final double LIMITE_RETIRO_DIARIO = 1945.0;

    CuentaBancaria1945(String numeroDeCuenta, double saldo, int nip, String nombreDelTitular) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
        // Usamos el setter para validar el NIP inicial
        this.setNip(nip);
        this.nombreDelTitular = nombreDelTitular;
    }

    // Getters

    public double getSaldo() {
        return saldo;
    }

    public int getNip() {
        return nip;
    }

    public String getNombreDelTitular() {
        return nombreDelTitular;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    // Setters con validación

    /**
     * Establece un nuevo NIP si es de 4 dígitos.
     */
    public void setNip(int nip) {
        // Validación: Asegura que el NIP tenga 4 dígitos
        if (nip >= 1000 && nip <= 9999) {
            this.nip = nip;
        }
        // Opcional: Podríamos poner un 'else' e imprimir un error
    }

    public void setNombreDelTitular(String nombreDelTitular) {
        // Validación: Asegura que el nombre no sea nulo o vacío
        if (nombreDelTitular != null && !nombreDelTitular.trim().isEmpty()) {
            this.nombreDelTitular = nombreDelTitular;
        }
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }


    public boolean retirarDinero(double cantidad) {
        // Validación usando la matrícula (1945)
        if (cantidad > 0 && cantidad <= saldo && cantidad <= LIMITE_RETIRO_DIARIO) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    // Depositar dinero
    public boolean depositarDinero(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Cuenta: %s%nTitular: %s%nSaldo: %.2f",
                numeroDeCuenta, nombreDelTitular, saldo);

    }
}