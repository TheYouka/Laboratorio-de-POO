
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaBancaria1945Test {

    private CuentaBancaria1945 cuenta;

    @BeforeEach
    void setUp() {
        // Creamos una cuenta nueva antes de CADA prueba
        cuenta = new CuentaBancaria1945("123", 2000.0, 1234, "Test User");
    }

    @Test
    @DisplayName("Depositar cantidad positiva funciona")
    void testDepositarDineroExitoso() {
        assertTrue(cuenta.depositarDinero(500.0));
        assertEquals(2500.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Depositar cantidad negativa falla")
    void testDepositarDineroNegativo() {
        assertFalse(cuenta.depositarDinero(-100.0));
        assertEquals(2000.0, cuenta.getSaldo()); // El saldo no debe cambiar
    }

    @Test
    @DisplayName("Retirar exitosamente (dentro del límite)")
    void testRetirarDineroExitoso() {
        assertTrue(cuenta.retirarDinero(1000.0)); // 1000 <= 1945
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Retirar falla (saldo insuficiente)")
    void testRetirarDineroSaldoInsuficiente() {
        assertFalse(cuenta.retirarDinero(3000.0)); // 3000 > 2000
        assertEquals(2000.0, cuenta.getSaldo()); // El saldo no cambia
    }

    @Test
    @DisplayName("Retirar falla (supera límite diario 1945)")
    void testRetirarDineroSuperaLimiteMatricula() {
        // Tenemos 2000 de saldo, pero el límite es 1945
        assertFalse(cuenta.retirarDinero(1946.0));
        assertEquals(2000.0, cuenta.getSaldo()); // El saldo no cambia
    }

    @Test
    @DisplayName("Setter de NIP valida 4 dígitos")
    void testSetNipValidacion() {
        cuenta.setNip(999); // Intento fallido (3 dígitos)
        assertEquals(1234, cuenta.getNip()); // Debe conservar el NIP original

        cuenta.setNip(10000); // Intento fallido (5 dígitos)
        assertEquals(1234, cuenta.getNip());

        cuenta.setNip(5678); // Intento exitoso
        assertEquals(5678, cuenta.getNip());
    }
}