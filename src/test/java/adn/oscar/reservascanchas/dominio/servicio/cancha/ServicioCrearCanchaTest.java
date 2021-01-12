package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
    public void canchaYaExiste() {
        // arrange
        Cancha cancha = new CanchaTestDataBuilder().build();
        when(repositorioCancha.obtenerPorCodigo(cancha.getCodigo())).thenReturn(cancha);

        // act
        boolean existe = servicioCrearCancha.yaExisteCancha(cancha.getCodigo());

        // assert
        assertTrue(existe);
    }

    @Test
    public void canchaNoExiste() {
        // arrange
        Cancha cancha = new CanchaTestDataBuilder().build();
        when(repositorioCancha.obtenerPorCodigo(cancha.getCodigo())).thenReturn(null);

        // act
        boolean existe = servicioCrearCancha.yaExisteCancha(cancha.getCodigo());

        // assert
        assertFalse(existe);
    }

}