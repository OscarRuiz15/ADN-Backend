package adn.oscar.reservascanchas.infraestructura.controlador;

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
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(comandoCliente.getNombre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.correo").value(comandoCliente.getCorreo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value(comandoCliente.getTelefono()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cedula").value(comandoCliente.getCedula()));
    }

    @Test
    public void obtenerClientePorCedula() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/clientes/{cedula}", CEDULA_PRUEBA)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Carlos Andres Ruiz Palacio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.correo").value("caruizp@hotmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value("3177340123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cedula").value("1112585695"));
    }

    @Test
    public void obtenerClientes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/clientes")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].nombre").value("Pedro Ignacio Ruiz"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].correo").value("pedroruiz@hotmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].telefono").value("3194827423"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].cedula").value("1114829483"));
    }
}
