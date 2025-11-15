import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaBancoAVTest {

    private SistemaBancoAV banco;

    @BeforeEach
    void setUp() {
        banco = new SistemaBancoAV();
    }

    @Test
    @DisplayName("Lanza Saldo5InsuficienteException si no hay fondos")
    void testRetiroFallaPorSaldo() {
        assertThrows(Saldo5InsuficienteException.class, () -> {
            banco.retirarDinero("Alberto1945", 5000.0);
        });
    }

    @Test
    @DisplayName("Lanza Usuario1945NoEncontradoException si no existe")
    void testRetiroFallaPorUsuario() {
        assertThrows(Usuario1945NoEncontradoException.class, () -> {
            banco.retirarDinero("UsuarioFalso", 100.0);
        });
    }

    @Test
    @DisplayName("Retiro exitoso funciona bien")
    void testRetiroExitoso() {
        // assertDoesNotThrow checa que la alarma NO suene
        assertDoesNotThrow(() -> {
            banco.retirarDinero("Alberto1945", 100.0);
        });

        // Y checamos que el saldo se haya restado
        assertEquals(1900.0, banco.getSaldo("Alberto1945"));
    }
}