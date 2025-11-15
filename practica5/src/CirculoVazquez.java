public class CirculoVazquez extends Figura21 implements  CalculableA{

    double radio;

    CirculoVazquez(double r, String c){
        this.radio = r;
        this.color = c;
        this.nombre = "Círculo";
    };

    CirculoVazquez(double r){
        this.radio = r;
        this.color = "blanco";
        this.nombre = "Círculo";
    };

    CirculoVazquez(){
        this.radio = 1.0;
        this.color = "blanco";
        this.nombre = "Círculo";
    };

    @Override
    public double getArea(){
        return Math.PI * Math.pow(this.radio, 2);
    };

    @Override
    public double getPerimetro(){
        return 2 * Math.PI * this.radio;
    };

}
