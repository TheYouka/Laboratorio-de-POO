public class AutoVazquez extends VehiculoBaseA {

    private int numeroPuertas;

    public AutoVazquez(String marca, int anio, int numeroPuertas) {
        super(marca, anio); // Llama al constructor del padre
        this.numeroPuertas = numeroPuertas;
    }

    public String acelerar() {
        return "Auto acelerando a 100 km/h";
    }

    @Override
    public String frenar() {
        return "Auto frenando con ABS";
    }

    @Override
    public String obtenerDescripcion() {
        // Llama al método del padre y le añade info
        return "Auto -> " + super.obtenerDescripcion() + ", Puertas: " + this.numeroPuertas;
    }
}