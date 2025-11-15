import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 5. Programa principal con menú interactivo
        Scanner sc = new Scanner(System.in);
        BibliotecaA1945 biblioteca = new BibliotecaA1945();
        boolean salir = false;

        biblioteca.registrarUsuario("2091945", "Alberto Vazquez");

        System.out.println("¡Bienvenido a la BibliotecaA1945!");

        while (!salir) {
            mostrarMenu();
            int opcion = -1;

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiamos el 'Enter'
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número.");
                sc.nextLine(); // Limpiamos la entrada incorrecta
                continue; // 
            }

            switch (opcion) {
                case 1:
                    agregarLibro(sc, biblioteca);
                    break;
                case 2:
                    registrarUsuario(sc, biblioteca);
                    break;
                case 3:
                    prestarLibro(sc, biblioteca);
                    break;
                case 4:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 5:
                    biblioteca.mostrarUsuarios();
                    break;
                case 6:
                    biblioteca.mostrarCategorias();
                    break;
                case 7:
                    biblioteca.mostrarColaReservas();
                    break;
                case 8: // Ordenar (Comparable)
                    biblioteca.ordenarLibrosPorTitulo();
                    break;
                case 9: // Ordenar (Comparator)
                    biblioteca.ordenarLibrosPorAutor();
                    break;
                case 10: // Punto 7 (Análisis de Tiempo)
                    biblioteca.analizarTiempoBusqueda();
                    break;
                case 0:
                    System.out.printf("Saliendo del programa. ¡Hasta luego!%n");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ BIBLIOTECA ---");
        System.out.println("1. Agregar nuevo libro");
        System.out.println("2. Registrar nuevo usuario");
        System.out.println("3. Prestar libro (CRUD)");
        System.out.println("4. Mostrar libros disponibles (Iterador)");
        System.out.println("5. Mostrar usuarios (HashMap)");
        System.out.println("6. Mostrar categorías (HashSet)");
        System.out.println("7. Mostrar cola de reservas (LinkedList)");
        System.out.println("8. Ordenar libros por Título (Comparable)");
        System.out.println("9. Ordenar libros por Autor (Comparator)");
        System.out.println("10. Analizar tiempo de búsqueda (Punto 7)");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarLibro(Scanner sc, BibliotecaA1945 bib) {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Categoría: ");
        String cat = sc.nextLine();
        System.out.print("Páginas: ");
        int pag = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        bib.agregarLibro(new Libro2105(titulo, autor, pag, isbn, cat));
    }

    private static void registrarUsuario(Scanner sc, BibliotecaA1945 bib) {
        System.out.print("Matrícula (personalizada): ");
        String mat = sc.nextLine();
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        bib.registrarUsuario(mat, nom);
    }

    private static void prestarLibro(Scanner sc, BibliotecaA1945 bib) {
        System.out.print("ISBN del libro a prestar: ");
        String isbn = sc.nextLine();
        System.out.print("Matrícula del usuario: ");
        String mat = sc.nextLine();
        bib.prestarLibro(isbn, mat);
    }
}