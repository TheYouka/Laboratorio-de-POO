// (Hereda de EmpleadoAV e implementa TODAS las habilidades)
public class GerenteVazquez extends EmpleadoAV implements Bonificar21, Evualuar5, Promovible1945 {

    private double bonoGerencial;

    public GerenteVazquez(String nombre, int idEmpleado, double salarioBase, double bonoGerencial) {
        super(nombre, idEmpleado, salarioBase);
        this.bonoGerencial = bonoGerencial;
    }

    @Override
    public double salarioFinal() {
        // Salario = Base + Bono Gerencial + Bono (de la interfaz)
        return this.salarioBase + this.bonoGerencial + this.calcularBono();
    }

    @Override
    public double calcularBono() {
        // Los gerentes tienen un bono fijo del 20%
        return this.salarioBase * 0.20;
    }

    @Override
    public double evaluarDesempeno() {
        // Evaluación de 0 a 10
        System.out.println("Evaluando al gerente " + this.nombre);
        return 9.5; // Los gerentes siempre salen bien evaluados 😅
    }

    @Override
    public boolean elegiblePromocion() {
        // Un gerente ya está en el tope
        return false;
    }
}