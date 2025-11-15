import java.util.ArrayList;
import java.util.List;

public class Concesionaria1945 {

    private List<VehiculoBaseA> inventario;

    public Concesionaria1945() {
        this.inventario = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoBaseA vehiculo) {
        this.inventario.add(vehiculo);
        System.out.println("Se agregó: " + vehiculo.getMarca());
    }

    public void mostrarInventario() {
        System.out.println("\n--- Inventario de la Concesionaria 1945 ---");
        for (VehiculoBaseA v : inventario) {
            System.out.println(v.obtenerDescripcion());
        }
    }
}