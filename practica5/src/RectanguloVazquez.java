public class RectanguloVazquez extends Figura21 implements CalculableA {

    double base;
    double altura;

    RectanguloVazquez(double b, double a, String c) {
        this.base = b;
        this.altura = a;
        this.color = c;
        this.nombre = "Rectángulo";
    }

    RectanguloVazquez(double b, double a) {
        this.base = b;
        this.altura = a;
        this.color = "blanco";
        this.nombre = "Rectángulo";
    }

    RectanguloVazquez() {
        this.base = 1.0;
        this.altura = 1.0;
        this.color = "blanco";
        this.nombre = "Rectángulo";
    }

    @Override
    public double getArea() {
        return this.base * this.altura;
    }

    @Override
    public double getPerimetro() {
        return 2 * (this.base + this.altura);
    }

}
