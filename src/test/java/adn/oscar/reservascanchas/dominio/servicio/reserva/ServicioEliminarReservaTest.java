package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.excepcion.ReservaException;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;
import adn.oscar.reservascanchas.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioEliminarReservaTest {

    @Mock
    private RepositorioReserva repositorioReserva;

    @InjectMocks
    private ServicioEliminarReserva servicioEliminarReserva;

    @Mock
    private ServicioCrearReserva servicioCrearReserva;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eliminarReservaExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.obtenerPorId(reserva.getId())).thenReturn(reserva);
        when(repositorioReserva.remover(reserva.getId())).thenReturn(reserva);

        // act
        Reserva reservaEliminada = servicioEliminarReserva.ejecutar(reserva.getId());

        // assert
        assertEquals(reserva.getId(), reservaEliminada.getId());
        assertEquals(reserva.getCliente().getCedula(), reservaEliminada.getCliente().getCedula());
        assertEquals(reserva.getCancha().getCodigo(), reservaEliminada.getCancha().getCodigo());
        assertEquals(reserva.getFechaInicioReserva(), reservaEliminada.getFechaInicioReserva());
        assertEquals(reserva.getFechaFinReserva(), reservaEliminada.getFechaFinReserva());
        assertEquals(reserva.getValorPago(), reservaEliminada.getValorPago(), 0);
    }

    @Test
    public void eliminarReservaNoExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.remover(reserva.getId())).thenReturn(null);

        try {
            // act
            servicioEliminarReserva.ejecutar(reserva.getId());
            fail();
        } catch (ReservaException reservaException) {
            // assert
            assertEquals(ServicioEliminarReserva.LA_RESERVA_A_ELIMINAR_NO_EXISTE, reservaException.getMessage());
        }
    }
}