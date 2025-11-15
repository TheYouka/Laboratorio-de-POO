public abstract class EmpleadoAV {

    protected String nombre;
    protected int idEmpleado;
    protected double salarioBase;

    // Un constructor para inicializar a los empleados
    public EmpleadoAV(String nombre, int idEmpleado, double salarioBase) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    void mostrarInfo() {
        System.out.printf("Nombre: %s %nId de empleado: %d %nSalario Base: %.2f%n",
                this.nombre, this.idEmpleado, this.salarioBase);
    }

    abstract double salarioFinal();
}