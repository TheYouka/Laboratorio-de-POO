public class TrianguloVazquez extends Figura21 implements CalculableA {

    double base;
    double altura;

    TrianguloVazquez(double b, double h, String c) {
        this.base = b;
        this.altura = h;
        this.color = c;
        this.nombre = "Triángulo";
    }

    TrianguloVazquez(double b, double h) {
        this.base = b;
        this.altura = h;
        this.color = "blanco";
        this.nombre = "Triángulo";
    }

    TrianguloVazquez() {
        this.base = 1.0;
        this.altura = 1.0;
        this.color = "blanco";
        this.nombre = "Triángulo";
    }

    @Override
    public double getArea() {
        return (this.base * this.altura) / 2;
    }

    @Override
    public double getPerimetro() {
        // Asumiendo un triángulo equilátero para simplificar
        return 3 * this.base;
    }

}
