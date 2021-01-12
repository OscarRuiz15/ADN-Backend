package adn.oscar.reservascanchas.dominio.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;

public interface RepositorioCancha {

    /**
     * Obtener una cancha dado el código
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
}
