package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.testdatabuilder.CanchaTestDataBuilder;
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

public class ServicioListarCanchasTest {

    @Mock
    private RepositorioCancha repositorioCancha;

    @InjectMocks
    private ServicioListarCanchas servicioListarCanchas;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listarCanchasTest() {
        // arrange
        Cancha canchaTest = new CanchaTestDataBuilder().build();
        when(repositorioCancha.listaCanchas()).thenReturn(
                new ArrayList<>(Collections.singletonList(
                        canchaTest
                )));

        // act
        List<Cancha> canchas = this.servicioListarCanchas.ejecutar();

        // assert
        assertEquals(canchas.get(0).getId(), canchaTest.getId());
        assertEquals(canchas.get(0).getCodigo(), canchaTest.getCodigo());
        assertEquals(canchas.get(0).getTipoCancha(), canchaTest.getTipoCancha());
        assertEquals(canchas.get(0).getPrecioReserva(), canchaTest.getPrecioReserva(), 0);
        assertEquals(canchas.get(0).getDireccion(), canchaTest.getDireccion());
    }

}