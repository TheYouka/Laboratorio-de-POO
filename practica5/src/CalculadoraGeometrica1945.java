public class CalculadoraGeometrica1945 {

    // Sumar areas
    static public double sumarAreas(CalculableA[] figuras) {
        double suma = 0.0;
        for (CalculableA figura : figuras) {
            suma += figura.getArea();
        }
        return suma;
    }

    // SUmar perimetros
    static public double sumarPerimetros(CalculableA[] figuras) {
        double suma = 0.0;
        for (CalculableA figura : figuras) {
            suma += figura.getPerimetro();
        }
        return suma;
    }

    // Mayor area
    static public double mayorArea(CalculableA[] figuras) {
        double mayor = 0.0;
        for (CalculableA figura : figuras) {
            if (figura.getArea() > mayor) {
                mayor = figura.getArea();
            }
        }
        return mayor;
    }
}