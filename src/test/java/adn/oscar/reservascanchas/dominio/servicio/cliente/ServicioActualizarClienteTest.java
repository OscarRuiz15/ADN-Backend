package adn.oscar.reservascanchas.dominio.servicio.cliente;

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

public class ServicioActualizarClienteTest {

    private static final String NOMBRE_ACTUALIZADO = "Pedro Vargas";
    private static final String TELEFONO_ACTUALIZADO = "3152355523";
    private static final String CORREO_ACTUALIZADO = "no-registra@hotmail.com";

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioActualizarCliente servicioActualizarCliente;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void actualizarUsuarioTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        when(repositorioCliente.actualizar(cliente)).thenReturn(
                new ClienteTestDataBuilder()
                        .conNombre(NOMBRE_ACTUALIZADO)
                        .conTelefono(TELEFONO_ACTUALIZADO)
                        .conCorreo(CORREO_ACTUALIZADO)
                        .build()
        );

        // act
        Cliente clienteActualizado = this.servicioActualizarCliente.ejecutar(cliente);

        // assert
        assertEquals(cliente.getId(), clienteActualizado.getId());
        assertEquals(cliente.getCedula(), clienteActualizado.getCedula());
        assertEquals(NOMBRE_ACTUALIZADO, clienteActualizado.getNombre());
        assertEquals(TELEFONO_ACTUALIZADO, clienteActualizado.getTelefono());
        assertEquals(CORREO_ACTUALIZADO, clienteActualizado.getCorreo());
    }
}