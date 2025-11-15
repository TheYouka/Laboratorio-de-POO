import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutoVazquezTest {
    @Test
    void testSobrescrituraAuto() {
        VehiculoBaseA auto = new AutoVazquez("Nissan", 2023, 4);

        assertEquals("Auto acelerando a 100 km/h", auto.acelerar());
        assertEquals("Auto frenando con ABS", auto.frenar());
        assertTrue(auto.obtenerDescripcion().contains("Puertas: 4"));
    }
}