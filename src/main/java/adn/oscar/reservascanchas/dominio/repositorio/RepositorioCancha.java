package adn.oscar.reservascanchas.dominio.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;

import java.util.List;

public interface RepositorioCancha {

    /**
     * Obtener una cancha dado el codigo
     *
     * @param codigo
     * @return Cancha
     */
    Cancha obtenerPorCodigo(String codigo);

    /**
     * Agregar un registro cancha al repositorio
     *
     * @param cancha
     * @return Cancha
     */
    Cancha agregar(Cancha cancha);

    /**
     * Obtener todos los registros del modelo cancha
     */
    List<Cancha> listaCanchas();

    /**
     * Actualizar un registro cliente
     *
     * @param cancha
     * @return Cancha
     */
    Cancha actualizar(Cancha cancha);
}
