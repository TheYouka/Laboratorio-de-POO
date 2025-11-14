// El archivo debe llamarse EstudianteAV.java
public class EstudianteAV {

    private String nombre;
    private String matricula;
    private int edad;
    private String carrera;
    private int semestreActual;

    // Constructor 1
    EstudianteAV(String nombre, String matricula, String edad)
    {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = Integer.parseInt(edad);
        this.carrera = "NULL";
        this.semestreActual = 1; // Asumimos que es de nuevo ingreso;
    }

    // Constructor 2
    EstudianteAV(String nombre, String matricula, String edad, String carrera, int semestreActual) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = Integer.parseInt(edad);
        this.carrera = carrera;
        this.semestreActual = semestreActual;

    }

    // COnstructor 3
    EstudianteAV(String nombre, String matricula, int edad, String carrera){
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
        this.semestreActual = 1; // Asumimos que es de nuevo ingreso;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public int getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    // Mostrar información general del estudiante
    public String mostrarInfoEstudiante() {
        return "Nombre: " + nombre + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Edad: " + edad + "\n" +
                "Carrera: " + carrera + "\n" +
                "Semestre Actual: " + semestreActual + "\n";
    }
}