public class MotocicletaVazquez extends VehiculoBaseA {
    private int cilindrada;

    public MotocicletaVazquez(String marca, int anio, int cilindrada) {
        super(marca, anio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String acelerar() {
        return "Motocicleta acelerando a 120 km/h";
    }

    @Override
    public String frenar() {
        return "Motocicleta frenando";
    }

    @Override
    public String obtenerDescripcion() {
        return "Moto -> " + super.obtenerDescripcion() + ", CC: " + this.cilindrada;
    }
}