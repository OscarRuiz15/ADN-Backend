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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioCrearReservaTest {

    private static final String FECHA_RESERVA_FIN_DE_SEMANA = "2021-01-16 09:00";
    private static final String FECHA_RESERVA_ENTRE_SEMANA = "2021-01-13 15:00";
    private static final double PRECIO_RESERVA_FIN_DE_SEMANA = 93500;
    private static final double VALOR_PAGAR_FIN_DE_SEMANA = 102850;
    private static final double PRECIO_RESERVA_ENTRE_SEMANA = 85000;
    private static final String FORMATO_FECHA = "yyyy-MM-dd H:m";
    private static final String FECHA_SIN_DISPONIBILIDAD = "2021-01-13 09:30";

    @Mock
    private RepositorioReserva repositorioReserva;

    @InjectMocks
    private ServicioCrearReserva servicioCrearReserva;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearReservaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.agregar(reserva)).thenReturn(reserva);

        // act
        Reserva reservaPersistido = servicioCrearReserva.ejecutar(reserva);

        // assert
        assertEquals(reserva.getCancha(), reservaPersistido.getCancha());
        assertEquals(reserva.getCliente(), reservaPersistido.getCliente());
        assertEquals(reserva.getFechaInicioReserva(), reservaPersistido.getFechaInicioReserva());
        assertEquals(reserva.getFechaFinReserva(), reservaPersistido.getFechaFinReserva());
        assertEquals(reserva.getValorPago(), reservaPersistido.getValorPago(), 0);
    }

    @Test
    public void crearReservaYaExistente() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        when(repositorioReserva.obtenerPorCodigoCedulaYFecha(reserva.getCancha().getCodigo(),
                reserva.getCliente().getCedula(), reserva.getFechaInicioReserva())).thenReturn(reserva);

        try {
            // act
            servicioCrearReserva.ejecutar(reserva);
            fail();
        } catch (ReservaException reservaException) {
            // assert
            assertEquals(ServicioCrearReserva.LA_CANCHA_YA_HA_SIDO_RESERVADA_POR_EL_CLIENTE_PARA_LA_MISMA_FECHA,
                    reservaException.getMessage());
        }
    }

    @Test
    public void canchaAReservarYaOcupadaTest() {
        // arrange
        Reserva reservaTest = new ReservaTestDataBuilder().build();
        when(repositorioReserva.verificarDisponibilidadCancha(reservaTest.getCancha().getCodigo(),
                reservaTest.getFechaInicioReserva())).thenReturn(reservaTest);

        try {
            // act
            servicioCrearReserva.ejecutar(reservaTest);
            fail();
        } catch (ReservaException reservaException) {
            // assert
            assertEquals(ServicioCrearReserva.LA_CANCHA_NO_ESTA_DISPONIBLE_PARA_LA_FECHA_ELEGIDA_YA_ESTA_RESERVADA,
                    reservaException.getMessage());
        }
    }

    @Test
    public void crearReservaDiaNoHabilTest() {
        // arrange
        DateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
        String FECHA_NO_HABIL = dateFormat.format(new Date());
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicioReserva(FECHA_NO_HABIL)
                .build();

        try {
            // act
            servicioCrearReserva.ejecutar(reserva);
            fail();
        } catch (ReservaException reservaException) {
            // assert
            assertEquals(ServicioCrearReserva.NO_SE_PUEDE_REALIZAR_RESERVACIONES_PARA_EL_DIA_ACTUAL, reservaException.getMessage());
        }
    }

    @Test
    public void crearReservaFinDeSemanaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicioReserva(FECHA_RESERVA_FIN_DE_SEMANA)
                .build();
        when(repositorioReserva.agregar(reserva)).thenReturn(reserva);

        // act
        Reserva reservaPersistido = servicioCrearReserva.ejecutar(reserva);

        // assert
        assertEquals(PRECIO_RESERVA_FIN_DE_SEMANA, reservaPersistido.getValorPago(), 0);
    }

    @Test
    public void crearReservaEntreSemanaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaInicioReserva(FECHA_RESERVA_ENTRE_SEMANA)
                .build();
        when(repositorioReserva.agregar(reserva)).thenReturn(reserva);

        // act
        Reserva reservaPersistido = servicioCrearReserva.ejecutar(reserva);

        // assert
        assertEquals(PRECIO_RESERVA_ENTRE_SEMANA, reservaPersistido.getValorPago(), 0);
    }

    @Test
    public void calcularValorPagoFinDeSemanaTest() throws ParseException {
        // arrange
        Date fecha = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_RESERVA_FIN_DE_SEMANA);

        // act
        double valorPago = servicioCrearReserva.calcularValorPago(fecha, PRECIO_RESERVA_FIN_DE_SEMANA);

        // assert
        assertEquals(valorPago, VALOR_PAGAR_FIN_DE_SEMANA, 0);
    }

    @Test
    public void calcularValorPagoEntreSemanaTest() throws ParseException {
        // arrange
        Date fecha = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_RESERVA_ENTRE_SEMANA);

        // act
        double valorPago = servicioCrearReserva.calcularValorPago(fecha, PRECIO_RESERVA_ENTRE_SEMANA);

        // assert
        assertEquals(valorPago, PRECIO_RESERVA_ENTRE_SEMANA, 0);
    }
}