import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorArchivosVazquez1945 {

    public static void escribirTexto(String nombreArchivo, String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
            System.out.println("Éxito: Archivo '" + nombreArchivo + "' escrito.");
        } catch (IOException e) {
            System.err.println("Error al escribir texto: " + e.getMessage());
        }
    }

    public static String leerTexto(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (FileNotFoundException e) {
            return "Error: El archivo '" + nombreArchivo + "' no existe.";
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
        return contenido.toString();
    }

    public static void crearDirectorio(String ruta) {
        File dir = new File(ruta);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Éxito: Directorio '" + ruta + "' creado.");
            } else {
                System.err.println("Error al crear directorio.");
            }
        } else {
            System.out.println("Info: El directorio '" + ruta + "' ya existe.");
        }
    }

    public static void guardarPersona(PersonaASerializable persona, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(persona);
            System.out.println("Éxito: Objeto guardado (Serializado) en '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }
    }

    public static PersonaASerializable cargarPersona(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            PersonaASerializable persona = (PersonaASerializable) ois.readObject();
            System.out.println("Éxito: Objeto cargado (Deserializado).");
            return persona;
        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo '" + nombreArchivo + "' no existe.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
        }
        return null;
    }

    public static void escribirLogCSV(String nombreArchivo, String[] datos) {
        try (FileWriter fw = new FileWriter(nombreArchivo, true); // true = modo 'append'
             PrintWriter pw = new PrintWriter(fw)) {

            String lineaCSV = String.join(",", datos); // Une los datos con comas
            pw.println(lineaCSV);
            System.out.println("Éxito: Línea agregada a '" + nombreArchivo + "'.");

        } catch (IOException e) {
            System.err.println("Error al escribir CSV: " + e.getMessage());
        }
    }

    public static void hacerBackup(String archivoOrigen) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String archivoDestino = "backup_auto_" + timestamp + ".txt";

        try {
            Files.copy(Paths.get(archivoOrigen), Paths.get(archivoDestino), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Éxito: Backup automático creado en '" + archivoDestino + "'.");
        } catch (IOException e) {
            System.err.println("Error al crear backup: " + e.getMessage());
        }
    }
}