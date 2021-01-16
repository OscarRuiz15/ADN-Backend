package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;
import adn.oscar.reservascanchas.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ServicioObtenerReservaTest {

    @Mock
    private RepositorioReserva repositorioReserva;

    @InjectMocks
    private ServicioObtenerReserva servicioObtenerReserva;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtenerReservaExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.obtenerPorId(reserva.getId())).thenReturn(reserva);

        // act
        boolean existe = servicioObtenerReserva.ejecutar(reserva.getId()) != null;

        // assert
        assertTrue(existe);
    }

    @Test
    public void obtenerReservaNoExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.obtenerPorId(reserva.getId())).thenReturn(null);

        // act
        boolean existe = servicioObtenerReserva.ejecutar(reserva.getId()) != null;

        // assert
        assertFalse(existe);
    }

    @Test
    public void obtenerReservaPorCodigoCedulaFechaExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.agregar(reserva)).thenReturn(reserva);
        when(repositorioReserva.obtenerPorCodigoCedulaYFecha(reserva.getCancha().getCodigo(),
                reserva.getCliente().getCedula(), reserva.getFechaInicioReserva())).thenReturn(reserva);

        // act
        boolean existe = servicioObtenerReserva.ejecutar(reserva.getId()) != null;

        // assert
        assertFalse(existe);
    }

    @Test
    public void obtenerReservaPorCodigoCedulaFechaNoExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.obtenerPorCodigoCedulaYFecha(reserva.getCancha().getCodigo(),
                reserva.getCliente().getCedula(), reserva.getFechaInicioReserva())).thenReturn(null);

        // act
        Reserva reservaPersistida = servicioObtenerReserva.ejecutar(reserva.getId());

        // assert
        assertNull(reservaPersistida);
    }
}
