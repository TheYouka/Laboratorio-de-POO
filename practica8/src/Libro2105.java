public class Libro2105 implements Comparable<Libro2105> {

    private String titulo;
    private String autor;
    private int paginas;
    private String isbn;
    private String categoria;

    Libro2105(String titulo, String autor, int paginas, String isbn, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    // Getters (necesarios para que funcionen las otras clases)
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        // Para que se imprima bonito
        return String.format("Libro: %s (Autor: %s, ISBN: %s)", titulo, autor, isbn);
    }

    // (Define el "orden natural" de los libros: por título)
    @Override
    public int compareTo(Libro2105 otroLibro) {
        return this.titulo.compareTo(otroLibro.getTitulo());
    }
}