package adn.oscar.reservascanchas.infraestructura;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.dominio.TipoCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
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
public class ControladorCanchaTest {

    private final static String CODIGO_PRUEBA = "EDG47F";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void crearCanchaTest() throws Exception {
        ComandoCancha comandoCancha = new CanchaTestDataBuilder().buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/canchas")
                .content(objectMapper.writeValueAsString(comandoCancha))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo").value("19960815"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("EL TEMPLO"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.direccion").value("Calle 29 # 11 - 123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value("3157595261"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tipoCancha").value(TipoCancha.FUTBOL_DIEZ.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioReserva").value(85000));
    }

    @Test
    public void obtenerCanchaPorCodigo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/canchas/{codigo}", CODIGO_PRUEBA)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo").value(CODIGO_PRUEBA))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Fulbol Palacio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.direccion").value("Carrera 26 # 11 - 136"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value("3183993173"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tipoCancha").value(TipoCancha.FUTBOL_SEIS.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioReserva").value(95000));
    }
}
