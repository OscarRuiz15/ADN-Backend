package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ServicioObtenerClienteTest {

    @Mock
    RepositorioCliente repositorioCliente;

    @InjectMocks
    ServicioCrearCliente servicioCrearCliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void clienteYaExiste() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        when(repositorioCliente.obtenerPorCedula(cliente.getCedula())).thenReturn(cliente);

        // act
        boolean existe = servicioCrearCliente.yaExisteCliente(cliente.getCedula());

        // assert
        assertTrue(existe);
    }

    @Test
    public void clienteNoExiste() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        when(repositorioCliente.obtenerPorCedula(cliente.getCedula())).thenReturn(null);

        // act
        boolean existe = servicioCrearCliente.yaExisteCliente(cliente.getCedula());

        // assert
        assertFalse(existe);
    }
}
