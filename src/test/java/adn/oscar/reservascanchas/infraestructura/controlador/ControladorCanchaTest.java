package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.codigo").value(comandoCancha.getCodigo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(comandoCancha.getNombre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.direccion").value(comandoCancha.getDireccion()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value(comandoCancha.getTelefono()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tipoCancha").value(comandoCancha.getTipoCancha().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioReserva").value(comandoCancha.getPrecioReserva()));
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


    @Test
    public void obtenerCanchas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/canchas")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].codigo").value("C3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].nombre").value("San Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].direccion").value("Calle 15 # 4 - 64"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].telefono").value("3165555555"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].tipoCancha").value("FUTBOL_NUEVE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].precioReserva").value(97500));
    }

    @Test
    public void actualizarCanchaTest() throws Exception {
        ComandoCancha comandoCancha = new CanchaTestDataBuilder()
                .conNombre("Nombre modificado")
                .conDireccion("Direccion modificado")
                .conId(20L)
                .conTelefono("2362814")
                .conPrecioReserva(157800)
                .conCodigo("EBD67E")
                .buildComando();

        mockMvc.perform(MockMvcRequestBuilders
                .put("/canchas")
                .content(objectMapper.writeValueAsString(comandoCancha))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(comandoCancha.getNombre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.direccion").value(comandoCancha.getDireccion()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value(comandoCancha.getTelefono()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioReserva").value(comandoCancha.getPrecioReserva()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(comandoCancha.getId()));
    }
}
