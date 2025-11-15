import java.util.Comparator;

public class ComparadorLibroPorAutor implements Comparator<Libro2105> {

    @Override
    public int compare(Libro2105 l1, Libro2105 l2) {
        // Ordena los libros por el nombre del autor
        return l1.getAutor().compareTo(l2.getAutor());
    }
}