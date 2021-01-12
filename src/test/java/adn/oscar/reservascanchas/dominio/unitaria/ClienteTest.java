package adn.oscar.reservascanchas.dominio.unitaria;

import adn.oscar.reservascanchas.dominio.excepcion.ValorInvalidoException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorNumericoException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorObligatorioException;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ClienteTest {

    private static final String NOMBRE = "Lina Marcela Pareja";
    private static final String CORREO = "lmpg@hotmail.com";
    private static final String TELEFONO = "317734012";
    private static final String TELEFONO_ERRONEO = "3A1B7C7S34012";
    private static final String TELEFONO_NEGATIVO = "-3156964454";
    private static final String CEDUlA = "1116084667";
    private static final String CEDUlA_ERRONEO = "11A1B6S0C84667";
    private static final String CEDUlA_NEGATIVO = "-1116084667";

    @Test
    public void crearClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conNombre(NOMBRE)
                .conCorreo(CORREO)
                .conTelefono(TELEFONO)
                .conCedula(CEDUlA);

        // act
        Cliente cliente = clienteTestDataBuilder.build();

        // assert
        assertEquals(NOMBRE, cliente.getNombre());
        assertEquals(CORREO, cliente.getCorreo());
        assertEquals(TELEFONO, cliente.getTelefono());
        assertEquals(CEDUlA, cliente.getCedula());
    }

    @Test
    public void crearClienteSinNombre() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conNombre(null);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cliente.EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearClienteSinTelefono() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conTelefono(null);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cliente.EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearClienteConTelefonoNoNumerico() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conTelefono(TELEFONO_ERRONEO);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorNumericoException valorNumericoException) {
            // assert
            assertEquals(Cliente.EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO, valorNumericoException.getMessage());
        }
    }

    @Test
    public void crearClienteConNumeroTelefonicoNegativo() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conTelefono(TELEFONO_NEGATIVO);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorInvalidoException valorInvalidoException) {
            // assert
            assertEquals(Cliente.EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO, valorInvalidoException.getMessage());
        }
    }

    @Test
    public void crearClienteSinCedula() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conCedula(null);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cliente.EL_NUMERO_DE_CEDULA_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearClienteConCedulaNoNumerico() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conCedula(CEDUlA_ERRONEO);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorNumericoException valorNumericoException) {
            // assert
            assertEquals(Cliente.EL_NUMERO_DE_CEDULA_DEBE_SER_NUMERICO, valorNumericoException.getMessage());
        }
    }

    @Test
    public void crearClienteConNumeroDeCedulaNegativo() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conCedula(CEDUlA_NEGATIVO);

        try {
            // act
            Cliente cliente = clienteTestDataBuilder.build();
            fail();
        } catch (ValorInvalidoException valorInvalidoException) {
            // assert
            assertEquals(Cliente.EL_NUMERO_DE_CEDULA_NO_ES_CORRECTO, valorInvalidoException.getMessage());
        }
    }
}
