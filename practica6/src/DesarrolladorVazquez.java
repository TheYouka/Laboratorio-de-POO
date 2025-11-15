public class DesarrolladorVazquez extends EmpleadoAV implements Bonificar21, Evualuar5 {

    private String lenguajePrincipal;

    public DesarrolladorVazquez(String nombre, int idEmpleado, double salarioBase, String lenguaje) {
        super(nombre, idEmpleado, salarioBase);
        this.lenguajePrincipal = lenguaje;
    }

    @Override
    public double salarioFinal() {
        // Salario = Base + Bono
        return this.salarioBase + this.calcularBono();
    }

    @Override
    public double calcularBono() {
        // Bono por saber Java
        if (this.lenguajePrincipal.equalsIgnoreCase("Java")) {
            return this.salarioBase * 0.15; // Bono del 15%
        }
        return this.salarioBase * 0.05; // Bono normal
    }

    @Override
    public double evaluarDesempeno() {
        System.out.println("Evaluando al desarrollador " + this.nombre);
        return 8.0;
    }
}