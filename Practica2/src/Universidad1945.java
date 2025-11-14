

public class Universidad1945 {

    private final int MAX_ESTUDIANTES = 1945; // COMSTANTE NUMERICA CON LOS DIGITOS FINALES DE MI MATRICULA
    EstudianteAV estudiantes[];

    Universidad1945(EstudianteAV estudiantes[]) {
        this.estudiantes = estudiantes;
    }

    // Buscar estudiante por nombre
    public EstudianteAV buscarEstudiante(String nombre) {
        for (EstudianteAV estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        return null; // Si no se encuentra el estudiante
    }

    // Agregar estudiante
    public boolean agregarEstudiante(EstudianteAV nuevoEstudiante) {
        if (estudiantes.length >= MAX_ESTUDIANTES) {
            return false; // No se puede agregar más estudiantes
        }
        EstudianteAV[] nuevosEstudiantes = new EstudianteAV[estudiantes.length + 1];
        System.arraycopy(estudiantes, 0, nuevosEstudiantes, 0, estudiantes.length);
        nuevosEstudiantes[estudiantes.length] = nuevoEstudiante;
        estudiantes = nuevosEstudiantes;
        return true;
    }

    // Mostrar todos los estudiantes
    public void mostrarTodosEstudiantes() {
        for (EstudianteAV estudiante : estudiantes) {
            System.out.println(estudiante.mostrarInfoEstudiante());
        }
    }


}
