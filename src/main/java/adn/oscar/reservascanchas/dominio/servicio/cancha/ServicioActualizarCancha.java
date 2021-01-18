package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;

public class ServicioActualizarCancha {

    private final RepositorioCancha repositorioCancha;

    public ServicioActualizarCancha(RepositorioCancha repositorioCancha) {
        this.repositorioCancha = repositorioCancha;
    }

    public Cancha ejecutar(Cancha cancha) {
        return this.repositorioCancha.actualizar(cancha);
    }
}
