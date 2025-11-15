public class VendedorVazquez extends EmpleadoAV implements Bonificar21, Promovible1945 {

    private double totalVentas;
    private double tasaComision; // ej: 0.05 para 5%

    public VendedorVazquez(String nombre, int idEmpleado, double salarioBase, double tasaComision) {
        super(nombre, idEmpleado, salarioBase);
        this.tasaComision = tasaComision;
        this.totalVentas = 0.0;
    }

    public void registrarVenta(double monto) {
        this.totalVentas += monto;
    }

    @Override
    public double salarioFinal() {
        // Salario = Base + Bono (comisiones)
        return this.salarioBase + this.calcularBono();
    }

    @Override
    public double calcularBono() {
        // El bono es su comisión sobre ventas
        return this.totalVentas * this.tasaComision;
    }

    @Override
    public boolean elegiblePromocion() {
        // Si vendió más de 50,000
        return this.totalVentas > 50000;
    }
}