package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioActualizarCanchaTest {

    private static final String NOMBRE_ACTUALIZADO = "Nombre modificado";
    private static final String DIRECCION_ACTUALIZADO = "Direccion modificado";
    private static final String TELEFONO_ACTUALIZADO = "12341235";

    @Mock
    private RepositorioCancha repositorioCancha;

    @InjectMocks
    private ServicioActualizarCancha servicioActualizarCancha;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void actualizarCanchaTest() {
        // arrange
        Cancha cancha = new CanchaTestDataBuilder().build();
        when(repositorioCancha.actualizar(cancha)).thenReturn(
                new CanchaTestDataBuilder()
                        .conNombre(NOMBRE_ACTUALIZADO)
                        .conTelefono(TELEFONO_ACTUALIZADO)
                        .conDireccion(DIRECCION_ACTUALIZADO)
                        .build()
        );

        // act
        Cancha canchaActualizado = this.servicioActualizarCancha.ejecutar(cancha);

        // assert
        assertEquals(cancha.getId(), canchaActualizado.getId());
        assertEquals(cancha.getCodigo(), canchaActualizado.getCodigo());
        assertEquals(NOMBRE_ACTUALIZADO, canchaActualizado.getNombre());
        assertEquals(TELEFONO_ACTUALIZADO, canchaActualizado.getTelefono());
        assertEquals(DIRECCION_ACTUALIZADO, canchaActualizado.getDireccion());
    }
}