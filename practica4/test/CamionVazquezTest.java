import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CamionVazquezTest {
    @Test
    void testSobrescrituraCamion() {
        VehiculoBaseA camion = new CamionVazquez("Volvo", 2020, 10.5);

        assertEquals("Camión acelerando lentamente con carga", camion.acelerar());
        assertTrue(camion.obtenerDescripcion().contains("Carga: 10.5T"));
    }
}