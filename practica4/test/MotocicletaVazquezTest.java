import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotocicletaVazquezTest {
    @Test
    void testSobrescrituraMoto() {
        VehiculoBaseA moto = new MotocicletaVazquez("Honda", 2024, 600);

        assertEquals("Motocicleta acelerando a 120 km/h", moto.acelerar());
        assertTrue(moto.obtenerDescripcion().contains("CC: 600"));
    }
}