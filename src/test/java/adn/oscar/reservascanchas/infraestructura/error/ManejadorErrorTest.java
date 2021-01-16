package adn.oscar.reservascanchas.infraestructura.error;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioCrearCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ManejadorErrorTest {

    private static final HttpStatus STATUS_CODE_OK_VALUE = HttpStatus.OK;
    private static final int STATUS_CODE_OK = 200;
    private static final HttpStatus STATUS_CODE_BAD_REQUEST_VALUE = HttpStatus.BAD_REQUEST;
    private static final int STATUS_CODE_REQUEST_VALUE = 400;
    private static final String NULL_POINTER_EXCEPTION = "NullPointerException";
    private static final String CANCHA_EXCEPTION = "CanchaException";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void httpResponseOk() {
        // arrage
        ResponseEntity<Error> responseEntity;

        // act
        responseEntity = new ResponseEntity<>(HttpStatus.OK);

        // assert
        assertEquals(STATUS_CODE_OK_VALUE, responseEntity.getStatusCode());
        assertEquals(STATUS_CODE_OK, responseEntity.getStatusCodeValue());
    }

    @Test
    public void httpResponseBadRequest() {
        // arrage
        ResponseEntity<Error> responseEntity;

        // act
        responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        // assert
        assertEquals(STATUS_CODE_BAD_REQUEST_VALUE, responseEntity.getStatusCode());
        assertEquals(STATUS_CODE_REQUEST_VALUE, responseEntity.getStatusCodeValue());
    }

    @Test
    public void excepcionCanchaExistente() throws Exception {
        ComandoCancha comandoCancha = new CanchaTestDataBuilder()
                .conCodigo("EDG47F")
                .buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/canchas")
                .content(objectMapper.writeValueAsString(comandoCancha))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombreExcepcion").value(CANCHA_EXCEPTION))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(ServicioCrearCancha.YA_EXISTE_UNA_CANCHA_REGISTRADA_CON_EL_MISMO_CODIGO));
    }


    @Test
    public void nullPointerExceptionTest() throws Exception {
        ComandoCancha comandoCancha = new CanchaTestDataBuilder()
                .conId(null)
                .conCodigo("ACBSD")
                .buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/canchas")
                .content(objectMapper.writeValueAsString(comandoCancha))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombreExcepcion").value(NULL_POINTER_EXCEPTION));
    }
}