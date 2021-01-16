package adn.oscar.reservascanchas.infraestructura.persistencia;

import adn.oscar.reservascanchas.infraestructura.persistencia.builder.CanchaBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.ClienteBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.ReservaBuilder;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public class BuilderConstructorPrivadoTest {

    @Test
    public void constructorCanchaBuilderTest() throws NoSuchMethodException {
        // arrange
        Constructor<?> constructor;

        // act
        constructor = CanchaBuilder.class.getDeclaredConstructor();

        // assert
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    public void constructorClienteBuilderTest() throws NoSuchMethodException {
        // arrange
        Constructor<?> constructor;

        // act
        constructor = ClienteBuilder.class.getDeclaredConstructor();

        // assert
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }

    @Test
    public void constructorReservaBuilderTest() throws NoSuchMethodException {
        // arrange
        Constructor<?> constructor;

        // act
        constructor = ReservaBuilder.class.getDeclaredConstructor();

        // assert
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }
}
