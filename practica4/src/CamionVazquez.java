public class CamionVazquez extends VehiculoBaseA {

    private double capacidadCarga; // en toneladas

    public CamionVazquez(String marca, int anio, double capacidadCarga) {
        super(marca, anio);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String acelerar() {
        return "Camión acelerando lentamente con carga";
    }

    @Override
    public String frenar() {
        return "Camión frenando con frenos de aire";
    }

    @Override
    public String obtenerDescripcion() {
        return "Camión -> " + super.obtenerDescripcion() + ", Carga: " + this.capacidadCarga + "T";
    }
}