public class VehiculoBaseA {
    protected String marca;
    protected int anio;

    public VehiculoBaseA(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }


    public String acelerar() {
        return "Vehículo acelerando";
    }

    public String frenar() {
        return "Vehículo frenando";
    }

    public String obtenerDescripcion() {
        return "Marca: " + this.marca + ", Año: " + this.anio;
    }
}