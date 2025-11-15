import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String DATOS_TXT = "datos_1945.txt";
    private static final String SERIALIZADO_DAT = "backup_2105.dat"; // (Usamos tu cumple)
    private static final String LOG_CSV = "log_Vazquez.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        System.out.println("--- Gestor de Archivos Vazquez1945 ---");

        while (!salir) {
            mostrarMenu();
            int opcion = -1;

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiamos el 'Enter'
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número.");
                sc.nextLine(); // Limpiamos la entrada incorrecta
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Escribe el texto para '" + DATOS_TXT + "': ");
                    String texto = sc.nextLine();
                    GestorArchivosVazquez1945.escribirTexto(DATOS_TXT, texto);
                    break;
                case 2:
                    System.out.println("Contenido de '" + DATOS_TXT + "':");
                    System.out.println(GestorArchivosVazquez1945.leerTexto(DATOS_TXT));
                    break;
                case 3:
                    System.out.print("Nombre de la persona a guardar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad de la persona: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    PersonaASerializable pGuardar = new PersonaASerializable(nombre, edad);
                    GestorArchivosVazquez1945.guardarPersona(pGuardar, SERIALIZADO_DAT);
                    break;
                case 4:
                    System.out.println("Cargando persona de '" + SERIALIZADO_DAT + "'...");
                    PersonaASerializable pCargada = GestorArchivosVazquez1945.cargarPersona(SERIALIZADO_DAT);
                    if (pCargada != null) {
                        System.out.println(pCargada.toString());
                    }
                    break;
                case 5:
                    System.out.print("Mensaje para el log CSV: ");
                    String msg = sc.nextLine();
                    String[] datosLog = {LocalDateTime.now().toString(), "INFO", msg};
                    GestorArchivosVazquez1945.escribirLogCSV(LOG_CSV, datosLog);
                    break;
                case 6:
                    System.out.println("Creando backup de '" + DATOS_TXT + "'...");
                    GestorArchivosVazquez1945.hacerBackup(DATOS_TXT);
                    break;
                case 7:
                    System.out.print("Nombre del directorio a crear: ");
                    String dir = sc.nextLine();
                    GestorArchivosVazquez1945.crearDirectorio(dir);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("-------------------------------------");
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nElige una opción:");
        System.out.println("1. Escribir archivo de texto (datos_1945.txt)");
        System.out.println("2. Leer archivo de texto (datos_1945.txt)");
        System.out.println("3. Guardar objeto Persona (backup_2105.dat)");
        System.out.println("4. Cargar objeto Persona (backup_2105.dat)");
        System.out.println("5. Añadir línea a CSV (log_Vazquez.csv)");
        System.out.println("6. Crear Backup automático (con timestamp)");
        System.out.println("7. Crear directorio");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }
}