package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioCrearReserva;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
import adn.oscar.reservascanchas.testdatabuilder.ReservaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorReservaTest {

    private final static long ID_ESPERADO = 21L;
    private final static String FECHA_INICIO_RESERVA_TEST = "2021-01-08 17:53";
    private final static String FECHA_FIN_RESERVA_ESPERADO_TEST = "2021-01-08 18:53";
    private final static double VALOR_PAGAR_ESPERADO_TEST = 93500;
    private final static long ID_PRUEBA = 10L;
    private final static String RESERVA_EXCEPTION = "ReservaException";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void crearReservaTest() throws Exception {
        Cancha cancha = new CanchaTestDataBuilder()
                .conId(10L)
                .build();
        Cliente cliente = new ClienteTestDataBuilder()
                .conId(30L)
                .build();
        ComandoReserva comandoReserva = new ReservaTestDataBuilder()
                .conId(0L)
                .conCancha(cancha)
                .conCliente(cliente)
                .conFechaInicioReserva(FECHA_INICIO_RESERVA_TEST)
                .conFechaFinReserva(null)
                .buildComando();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/reservas")
                .content(objectMapper.writeValueAsString(comandoReserva))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(ID_ESPERADO))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaFinReserva").value(FECHA_FIN_RESERVA_ESPERADO_TEST))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorPago").value(VALOR_PAGAR_ESPERADO_TEST));
    }

    @Test
    public void obtenerReservaPorId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/reservas/{id}", ID_PRUEBA)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(ID_PRUEBA))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicioReserva").value("2021-01-21 17:51"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaFinReserva").value("2021-01-21 18:51"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cancha.codigo").value("EDG47F"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cliente.cedula").value("1112585695"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorPago").value(95000));
    }

    @Test
    public void obtenerReservas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/reservas")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].fechaInicioReserva").value("2021-01-18 22:30"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].fechaFinReserva").value("2021-01-18 23:30"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].cancha.codigo").value("C3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].cliente.cedula").value("1115087378"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].valorPago").value(97500));
    }


    @Test
    public void eliminarReservaTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/reservas/{id}", ID_PRUEBA)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(ID_PRUEBA))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicioReserva").value("2021-01-21 17:51"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaFinReserva").value("2021-01-21 18:51"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cancha.codigo").value("EDG47F"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cliente.cedula").value("1112585695"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorPago").value(95000));
    }

    @Test
    public void crearReservaYaExistenteTest() throws Exception {
        Cancha cancha = new CanchaTestDataBuilder()
                .conId(20L)
                .conCodigo("EBD67E")
                .build();
        Cliente cliente = new ClienteTestDataBuilder()
                .conId(30L)
                .conCedula("1115098765")
                .build();
        ComandoReserva comandoReserva = new ReservaTestDataBuilder()
                .conId(0L)
                .conCancha(cancha)
                .conCliente(cliente)
                .conFechaInicioReserva("2021-01-27 14:10")
                .buildComando();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/reservas")
                .content(objectMapper.writeValueAsString(comandoReserva))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombreExcepcion").value(RESERVA_EXCEPTION))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(ServicioCrearReserva.LA_CANCHA_YA_HA_SIDO_RESERVADA_POR_EL_CLIENTE_PARA_LA_MISMA_FECHA));
    }
}
