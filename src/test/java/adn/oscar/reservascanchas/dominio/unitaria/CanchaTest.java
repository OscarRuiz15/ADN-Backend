package adn.oscar.reservascanchas.dominio.unitaria;

import adn.oscar.reservascanchas.dominio.excepcion.ValorInvalidoException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorNumericoException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorObligatorioException;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CanchaTest {

    private static final String NOMBRE = "Plaza Sport";
    private static final String CODIGO = "BUGA0001";
    private static final TipoCancha TIPO_CANCHA = TipoCancha.FUTBOL_ONCE;
    private static final String DIRECCION = "Calle 15s # 3 - 45";
    private static final String TELEFONO = "2361616";
    private static final String TELEFONO_ERRONEO = "A315B759C5261";
    private static final String NUMERO_TELEFONO_NEGATIVO = "-3162830130";
    private static final double PRECIO_RESERVA = 75000;
    private static final double PRECIO_RESERVA_ERRONEO = -75000;
    private static final double PRECIO_RESERVA_DEBAJO_DEL_MINIMO = 35000;
    private static final String PARAMETRO_VACIO = "";


    @Test
    public void crearCanchaTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conNombre(NOMBRE)
                .conCodigo(CODIGO)
                .conTipoCancha(TIPO_CANCHA)
                .conDireccion(DIRECCION)
                .conTelefono(TELEFONO)
                .conPrecioReserva(PRECIO_RESERVA);

        // act
        Cancha cancha = canchaTestDataBuilder.build();

        // assert
        assertEquals(NOMBRE, cancha.getNombre());
        assertEquals(CODIGO, cancha.getCodigo());
        assertEquals(TIPO_CANCHA, cancha.getTipoCancha());
        assertEquals(DIRECCION, cancha.getDireccion());
        assertEquals(TELEFONO, cancha.getTelefono());
        assertEquals(PRECIO_RESERVA, cancha.getPrecioReserva(), 0);
    }

    @Test
    public void crearCanchaSinCodigoTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conCodigo(PARAMETRO_VACIO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cancha.EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearCanchaSinNombreTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conNombre(PARAMETRO_VACIO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cancha.EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearCanchaSinDireccionTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conDireccion(PARAMETRO_VACIO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cancha.LA_DIRECCION_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearCanchaSinTelefonoTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conTelefono(PARAMETRO_VACIO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cancha.EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearCanchaConTelefonoNoNumerico() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conTelefono(TELEFONO_ERRONEO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorNumericoException valorNumericoException) {
            // assert
            assertEquals(Cancha.EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO, valorNumericoException.getMessage());
        }
    }

    @Test
    public void crearCanchaConNumeroTelefonicoNegativo() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conTelefono(NUMERO_TELEFONO_NEGATIVO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorInvalidoException valorInvalidoException) {
            // assert
            assertEquals(Cancha.EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO, valorInvalidoException.getMessage());
        }
    }

    @Test
    public void crearCanchaSinPrecioDeReservaTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conPrecioReserva(0);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorObligatorioException valorObligatorioException) {
            // assert
            assertEquals(Cancha.EL_PRECIO_A_COBRAR_POR_RESERVA_ES_OBLIGATORIO, valorObligatorioException.getMessage());
        }
    }

    @Test
    public void crearCanchaConPrecioDeReservaNegativoTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conPrecioReserva(PRECIO_RESERVA_ERRONEO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorInvalidoException valorInvalidoException) {
            // assert
            assertEquals(Cancha.EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO, valorInvalidoException.getMessage());
        }
    }

    @Test
    public void crearCanchaConPrecioDeReservaMenorAlMinimoTest() {
        // arrange
        CanchaTestDataBuilder canchaTestDataBuilder = new CanchaTestDataBuilder()
                .conPrecioReserva(PRECIO_RESERVA_DEBAJO_DEL_MINIMO);

        try {
            // act
            Cancha cancha = canchaTestDataBuilder.build();
            fail();
        } catch (ValorInvalidoException valorInvalidoException) {
            // assert
            assertEquals(Cancha.EL_PRECIO_MINIMO_DE_RESERVA_ES_CINCUENTAMIL, valorInvalidoException.getMessage());
        }
    }
}
