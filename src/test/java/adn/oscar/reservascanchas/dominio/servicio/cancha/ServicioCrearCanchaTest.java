package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.excepcion.CanchaException;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioCrearCanchaTest {

    @Mock
    private RepositorioCancha repositorioCancha;

    @InjectMocks
    private ServicioCrearCancha servicioCrearCancha;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearCanchaTest() {
        // arrange
        Cancha cancha = new CanchaTestDataBuilder().build();
        when(repositorioCancha.agregar(cancha)).thenReturn(cancha);

        // act
        Cancha canchaPersistido = servicioCrearCancha.ejecutar(cancha);

        // assert
        assertEquals(cancha.getCodigo(), canchaPersistido.getCodigo());
        assertEquals(cancha.getTipoCancha(), canchaPersistido.getTipoCancha());
        assertEquals(cancha.getNombre(), canchaPersistido.getNombre());
        assertEquals(cancha.getTelefono(), canchaPersistido.getTelefono());
        assertEquals(cancha.getDireccion(), canchaPersistido.getDireccion());
        assertEquals(cancha.getPrecioReserva(), canchaPersistido.getPrecioReserva(), 0);
    }

    @Test
    public void crearCanchaYaExistenteTest() {
        // arrange
        Cancha cancha = new CanchaTestDataBuilder().build();
        when(repositorioCancha.obtenerPorCodigo(cancha.getCodigo())).thenReturn(cancha);

        try {
            // act
            servicioCrearCancha.ejecutar(cancha);
            fail();
        } catch (CanchaException canchaException) {
            // assert
            assertEquals(ServicioCrearCancha.YA_EXISTE_UNA_CANCHA_REGISTRADA_CON_EL_MISMO_CODIGO,
                    canchaException.getMessage());
        }
    }
}