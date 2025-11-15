public class Main {
    public static void main(String[] args) {

        // Usamos la interfaz CalculableA como tipo de dato (Polimorfismo)
        CalculableA[] misFiguras = new CalculableA[4];

        // Llenamos el arreglo con objetos de las clases concretas
        misFiguras[0] = new CirculoVazquez(5.0, "Rojo"); // radio 5
        misFiguras[1] = new RectanguloVazquez(4.0, 6.0, "Azul"); // 4x6
        misFiguras[2] = new TrianguloVazquez(3.0, 4.0, "Verde"); // base 3, altura 4
        misFiguras[3] = new CirculoVazquez(1.0); // Círculo blanco

        System.out.println("--- Procesando Figuras Polimórficas ---");

        // Clase CalculadoraGeometrica que use polimorfismo
        // Usamos los métodos estáticos de tu calculadora
        System.out.printf("Suma total de Áreas: %.2f%n",
                CalculadoraGeometrica1945.sumarAreas(misFiguras));

        System.out.printf("Suma total de Perímetros: %.2f%n",
                CalculadoraGeometrica1945.sumarPerimetros(misFiguras));

        System.out.printf("El Área más grande es: %.2f%n",
                CalculadoraGeometrica1945.mayorArea(misFiguras));

        System.out.println("\n--- 5. Demostración de instanceof y Casting ---");

        // Recorremos el arreglo para inspeccionar cada objeto
        for (CalculableA figura : misFiguras) {

            // Primero, imprimimos info general (usando el polimorfismo)
            System.out.println("Figura: " + figura.getClass().getSimpleName());

            // Usamos 'instanceof' para "preguntar" de qué tipo es
            if (figura instanceof CirculoVazquez) {
                // Si SÍ es un Círculo, podemos hacer un 'casting'
                CirculoVazquez circulo = (CirculoVazquez) figura;

                // Ahora podemos usar métodos que SÓLO tiene el círculo
                System.out.println("  -> Es un Círculo! Su radio es: " + circulo.radio);

            } else if (figura instanceof RectanguloVazquez) {
                // Si SÍ es un Rectángulo
                RectanguloVazquez rect = (RectanguloVazquez) figura;
                System.out.println("  -> Es un Rectángulo! Su base es: " + rect.base);

            } else if (figura instanceof TrianguloVazquez) {
                // Si SÍ es un Triángulo
                TrianguloVazquez tri = (TrianguloVazquez) figura;
                System.out.println("  -> Es un Triángulo! Su altura es: " + tri.altura);
            }
        }
    }
}