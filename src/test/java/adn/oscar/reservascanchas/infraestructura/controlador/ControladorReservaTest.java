package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
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

    private final static long ID_ESPERADO = 11L;
    private final static String FECHA_INICIO_RESERVA_TEST = "2021-01-15 17:53";
    private final static String FECHA_FIN_RESERVA_ESPERADO_TEST = "2021-01-15 18:53";
    private final static double VALOR_PAGAR_ESPERADO_TEST = 93500;
    private final static long ID_PRUEBA = 10L;

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
}