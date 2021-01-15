package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioListarClientesTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioListarClientes servicioListarClientes;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listarCanchasTest() {
        // arrange
        Cliente clienteTest = new ClienteTestDataBuilder().build();
        when(repositorioCliente.listaClientes()).thenReturn(
                new ArrayList<>(Collections.singletonList(
                        clienteTest
                )));

        // act
        List<Cliente> clientes = this.servicioListarClientes.ejecutar();

        // assert
        assertEquals(clientes.get(0).getId(), clienteTest.getId());
        assertEquals(clientes.get(0).getCorreo(), clienteTest.getCorreo());
        assertEquals(clientes.get(0).getTelefono(), clienteTest.getTelefono());
        assertEquals(clientes.get(0).getNombre(), clienteTest.getNombre());
        assertEquals(clientes.get(0).getCedula(), clienteTest.getCedula());
    }
}