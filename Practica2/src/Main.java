public class Main {
    public static void main(String[] args) {

        // Creamos objetos de tipo EstudianteAV
        EstudianteAV e1 = new EstudianteAV("Ana", "2034000", "20", "Ingeniería", 3);
        EstudianteAV e2 = new EstudianteAV("Luis", "2000001", "21", "Medicina", 5);
        EstudianteAV e3 = new EstudianteAV("María", "2000000", "19", "Derecho", 1);
        EstudianteAV e4 = new EstudianteAV("Alberto", "2091945", "19", "Ciencias Computacionales", 5);

        // Universidad
        // El arreglo debe ser de tipo EstudianteAV
        EstudianteAV[] estudiantesIniciales = {e1, e2, e3};
        // Creamos un objeto de tipo Universidad1945
        Universidad1945 universidad = new Universidad1945(estudiantesIniciales);

        // Mostrar todos los estudiantes iniciales
        System.out.println("Estudiantes iniciales:");
        universidad.mostrarTodosEstudiantes();

        // Agregar un nuevo estudiante
        System.out.println("\nAgregando un nuevo estudiante:");
        if (universidad.agregarEstudiante(e4)) {
            System.out.println("Estudiante agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el estudiante.");
        }

        // Mostrar todos los estudiantes después de agregar
        System.out.println("\nEstudiantes después de agregar:");
        universidad.mostrarTodosEstudiantes();

        // Buscar un estudiante por nombre
        System.out.println("\nBuscando estudiante con nombre 'Luis':");
        // La variable "buscado" debe ser de tipo EstudianteAV
        EstudianteAV buscado = universidad.buscarEstudiante("Luis");
        if (buscado != null) {
            System.out.println("Estudiante encontrado:\n" + buscado.mostrarInfoEstudiante());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}