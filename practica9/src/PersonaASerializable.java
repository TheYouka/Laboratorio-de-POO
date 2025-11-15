import java.io.Serializable;

public class PersonaASerializable implements Serializable {

    // (serialVersionUID es una buena práctica para la serialización)
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;

    public PersonaASerializable(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona {nombre='" + nombre + "', edad=" + edad + "}";
    }
}