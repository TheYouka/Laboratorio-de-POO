import java.util.ArrayList;
import java.util.List;

public class EmpresaTIA1945 {

    private List<EmpleadoAV> listaEmpleados;

    public EmpresaTIA1945() {
        this.listaEmpleados = new ArrayList<>();
    }

    public void contratarEmpleado(EmpleadoAV empleado) {
        this.listaEmpleados.add(empleado);
        System.out.println("Se contrató a: " + empleado.getNombre());
    }

    public void mostrarNomina() {
        System.out.println("\n--- NÓMINA DE EMPRESA TI A1945 ---");
        for (EmpleadoAV emp : this.listaEmpleados) {
            emp.mostrarInfo(); // Llama al método del padre

            System.out.printf("Salario Final (con bonos): %.2f%n", emp.salarioFinal());

            if (emp instanceof Evualuar5) {
                // (Evualuar5) es tu nombre de interfaz
                Evualuar5 ev = (Evualuar5) emp;
                System.out.println("  -> Calificación Desempeño: " + ev.evaluarDesempeno());
            }

            System.out.println("--------------------");
        }
    }
}