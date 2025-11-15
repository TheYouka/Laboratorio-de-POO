import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections; // Importamos Collections

public class BibliotecaA1945 {

    private ArrayList<Libro2105> librosDisponibles;
    private LinkedList<String> colaReservas;
    private HashMap<String, String> usuariosRegistrados;
    private HashSet<String> categoriasUnicas;

    public BibliotecaA1945() {
        this.librosDisponibles = new ArrayList<>();
        this.colaReservas = new LinkedList<>();
        this.usuariosRegistrados = new HashMap<>();
        this.categoriasUnicas = new HashSet<>();
    }


    public void agregarLibro(Libro2105 libro) {
        this.librosDisponibles.add(libro);
        this.categoriasUnicas.add(libro.getCategoria());
        System.out.println("Libro '" + libro.getTitulo() + "' agregado.");
    }

    public void registrarUsuario(String matricula, String nombre) {
        if (this.usuariosRegistrados.containsKey(matricula)) {
            System.out.println("Error: El usuario " + matricula + " ya existe.");
        } else {
            this.usuariosRegistrados.put(matricula, nombre);
            System.out.println("Usuario '" + nombre + "' registrado.");
        }
    }

    public Libro2105 buscarLibroPorIsbn(String isbn) {
        return this.librosDisponibles.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public void prestarLibro(String isbn, String matricula) {
        Libro2105 libro = buscarLibroPorIsbn(isbn);
        String usuario = this.usuariosRegistrados.get(matricula);

        if (libro == null) {
            System.out.println("Error: El libro con ISBN " + isbn + " no existe o no está disponible.");
            return;
        }
        if (usuario == null) {
            System.out.println("Error: El usuario con matrícula " + matricula + " no existe.");
            return;
        }

        this.librosDisponibles.remove(libro); // (U) Quitamos de disponibles
        this.colaReservas.addLast(libro.getTitulo() + " reservado por " + usuario);
        System.out.println("Éxito: Libro '" + libro.getTitulo() + "' prestado a " + usuario);
    }


    public void mostrarLibrosDisponibles() {
        System.out.println("\n--- Libros Disponibles (usando Iterador) ---");
        if (this.librosDisponibles.isEmpty()) {
            System.out.println("(No hay libros disponibles)");
            return;
        }
        Iterator<Libro2105> it = this.librosDisponibles.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void mostrarUsuarios() {
        System.out.println("\n--- Usuarios Registrados (HashMap) ---");
        if (this.usuariosRegistrados.isEmpty()) {
            System.out.println("(No hay usuarios registrados)");
            return;
        }
        this.usuariosRegistrados.forEach((matricula, nombre) -> {
            System.out.println("Matrícula: " + matricula + " -> Nombre: " + nombre);
        });
    }

    public void mostrarCategorias() {
        System.out.println("\n--- Categorías Únicas (HashSet) ---");
        System.out.println(this.categoriasUnicas);
    }

    public void mostrarColaReservas() {
        System.out.println("\n--- Cola de Reservas (LinkedList) ---");
        System.out.println(this.colaReservas);
    }

    public void ordenarLibrosPorTitulo() {
        System.out.println("\n--- Ordenando por Título (Comparable) ---");
        Collections.sort(this.librosDisponibles);
        mostrarLibrosDisponibles();
    }

    public void ordenarLibrosPorAutor() {
        System.out.println("\n--- Ordenando por Autor (Comparator) ---");
        this.librosDisponibles.sort(new ComparadorLibroPorAutor());
        mostrarLibrosDisponibles();
    }

    public void analizarTiempoBusqueda() {
        System.out.println("\n--- 7. Analizando Tiempos de Operación ---");
        // 1. Llenamos la lista con 50,000 libros para que el tiempo sea medible
        for (int i = 0; i < 50000; i++) {
            this.librosDisponibles.add(new Libro2105("Libro " + i, "Autor", 10, "ISBN-" + i, "Test"));
        }
        // El libro que buscaremos (el último)
        String isbnBuscar = "ISBN-49999";

        System.out.println("Buscando 1 libro en un ArrayList de 50,000 con un Stream...");

        long inicio = System.nanoTime(); // Inicia cronómetro

        buscarLibroPorIsbn(isbnBuscar); // La operación a medir

        long fin = System.nanoTime(); // Para cronómetro

        double tiempoMs = (fin - inicio) / 1_000_000.0;
        System.out.printf("Tiempo de búsqueda (Stream): %.4f milisegundos.%n", tiempoMs);

        this.librosDisponibles.clear();
    }
}