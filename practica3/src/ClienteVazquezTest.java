import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteVazquezTest {

    private ClienteVazquez cliente;
    private CuentaBancaria1945 cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new CuentaBancaria1945("C-100", 500, 1111, "Cliente de Prueba");
        cliente = new ClienteVazquez("Cliente de Prueba", "C100", cuenta);
    }

    @Test
    @DisplayName("Cliente puede consultar saldo (Composición)")
    void testConsultarSaldo() {
        assertEquals(500.0, cliente.consultarSaldo());
    }

    @Test
    @DisplayName("Cliente puede depositar (Composición)")
    void testRealizarDeposito() {
        cliente.realizarDeposito(100.0);
        assertEquals(600.0, cliente.consultarSaldo());
    }

    @Test
    @DisplayName("Cliente puede retirar (Composición)")
    void testRealizarRetiro() {
        cliente.realizarRetiro(100.0);
        assertEquals(400.0, cliente.consultarSaldo());
    }

    @Test
    @DisplayName("obtenerInformacion() funciona")
    void testObtenerInformacion() {
        String info = cliente.obtenerInformacion();
        assertTrue(info.contains("Cliente: Cliente de Prueba"));
        assertTrue(info.contains("Número de Cliente: C100"));
        assertTrue(info.contains("Saldo: 500.00"));
    }
}