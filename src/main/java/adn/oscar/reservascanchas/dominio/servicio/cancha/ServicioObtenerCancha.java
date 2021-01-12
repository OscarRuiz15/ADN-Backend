package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.modelos.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;


public class ServicioObtenerCancha {

    private final RepositorioCancha repositorioCancha;

    public ServicioObtenerCancha(RepositorioCancha repositorioCancha) {
        this.repositorioCancha = repositorioCancha;
    }

    public Cancha ejecutar(String codigo) {
        return this.repositorioCancha.obtenerPorCodigo(codigo);
    }


}
