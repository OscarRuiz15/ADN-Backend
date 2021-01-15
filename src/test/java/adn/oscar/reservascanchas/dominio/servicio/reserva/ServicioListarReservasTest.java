package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;
import adn.oscar.reservascanchas.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioListarReservasTest {

    @Mock
    private RepositorioReserva repositorioReserva;

    @InjectMocks
    private ServicioListarReservas servicioListarReservas;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listarCanchasTest() {
        // arrange
        Reserva reservaTest = new ReservaTestDataBuilder().build();
        when(repositorioReserva.listaReservas()).thenReturn(
                new ArrayList<>(Collections.singletonList(
                        reservaTest
                )));

        // act
        List<Reserva> reservas = this.servicioListarReservas.ejecutar();

        // assert
        assertEquals(reservas.get(0).getId(), reservaTest.getId());
        assertEquals(reservas.get(0).getValorPago(), reservaTest.getValorPago(), 0);
        assertEquals(reservas.get(0).getFechaFinReserva(), reservaTest.getFechaFinReserva());
        assertEquals(reservas.get(0).getFechaInicioReserva(), reservaTest.getFechaInicioReserva());
        assertEquals(reservas.get(0).getCancha().getCodigo(), reservaTest.getCancha().getCodigo());
        assertEquals(reservas.get(0).getCliente().getCedula(), reservaTest.getCliente().getCedula());
    }
}