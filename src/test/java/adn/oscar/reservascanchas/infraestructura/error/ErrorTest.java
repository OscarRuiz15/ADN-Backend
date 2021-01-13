package adn.oscar.reservascanchas.infraestructura.error;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorTest {

    private static final String NOMBRE_ERROR = "ErrorTest";
    private static final String MENSAJE_ERROR = "Este es una prueba de error";

    @Test
    public void errorTest() {
        // arrange
        Error error;

        // act
        error = new Error(NOMBRE_ERROR, MENSAJE_ERROR);

        // assert
        assertEquals(error.getMensaje(), MENSAJE_ERROR);
        assertEquals(error.getNombreExcepcion(), NOMBRE_ERROR);
    }
}