package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.excepcion.ClienteException;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioCrearClienteTest {

    @Mock
    RepositorioCliente repositorioCliente;

    @InjectMocks
    ServicioCrearCliente servicioCrearCliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearClienteTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        when(repositorioCliente.agregar(cliente)).thenReturn(cliente);

        // act
        Cliente clientePersistido = servicioCrearCliente.ejecutar(cliente);

        // assert
        assertEquals(cliente.getCedula(), clientePersistido.getCedula());
        assertEquals(cliente.getNombre(), clientePersistido.getNombre());
        assertEquals(cliente.getTelefono(), clientePersistido.getTelefono());
        assertEquals(cliente.getCorreo(), clientePersistido.getCorreo());
    }

    @Test
    public void crearClienteYaExistente() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        when(repositorioCliente.obtenerPorCedula(cliente.getCedula())).thenReturn(cliente);

        try {
            // act
            servicioCrearCliente.ejecutar(cliente);
        } catch (ClienteException clienteException) {
            // assert
            assertEquals(ServicioCrearCliente.YA_EXISTE_UN_CLIENTE_REGISTRADO_CON_LA_MISMA_CEDULA,
                    clienteException.getMessage());
        }
    }
}
