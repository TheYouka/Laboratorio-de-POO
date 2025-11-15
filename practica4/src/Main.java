public class Main {
    public static void main(String[] args) {

        Concesionaria1945 miConcesionaria = new Concesionaria1945();

        AutoVazquez auto = new AutoVazquez("Nissan", 2023, 4);
        MotocicletaVazquez moto = new MotocicletaVazquez("Honda", 2024, 600);
        CamionVazquez camion = new CamionVazquez("Volvo", 2020, 10.5);

        // Los tratamos a todos como si fueran "VehiculoBaseA"
        System.out.println("Agregando vehículos...");
        miConcesionaria.agregarVehiculo(auto);
        miConcesionaria.agregarVehiculo(moto);
        miConcesionaria.agregarVehiculo(camion);

        // La concesionaria los muestra, cada uno con su info
        miConcesionaria.mostrarInventario();

        // También podemos probar los métodos sobrescritos
        System.out.println("\n--- Probando aceleración polimórfica ---");

        VehiculoBaseA[] patio = {auto, moto, camion};

        for (VehiculoBaseA vehiculo : patio) {
            System.out.println(vehiculo.getMarca() + ": " + vehiculo.acelerar());
        }
    }
}