package adn.oscar.reservascanchas.infraestructura;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
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
public class ControladorClienteTest {

    private final static String CEDULA_PRUEBA = "1112585695";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void crearClienteTest() throws Exception {
        ComandoCliente comandoCliente = new ClienteTestDataBuilder().buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/clientes")
                .content(objectMapper.writeValueAsString(comandoCliente))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Oscar Alexander Ruiz Palacio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("oarp1996@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value("3158895616"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cedula").value("1115087378"));
    }

    @Test
    public void obtenerClientePorCedula() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/clientes/{cedula}", CEDULA_PRUEBA)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Carlos Andres Ruiz Palacio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("caruizp@hotmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value("3177340123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cedula").value("1112585695"));
    }
}
