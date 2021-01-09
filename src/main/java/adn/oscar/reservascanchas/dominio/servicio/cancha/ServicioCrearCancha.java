package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;

public class ServicioCrearCancha {

    private final RepositorioCancha repositorioCancha;

    public ServicioCrearCancha(RepositorioCancha repositorioCancha) {
        this.repositorioCancha = repositorioCancha;
    }

    public Cancha ejecutar(Cancha cancha) {
        return this.repositorioCancha.agregar(cancha);
    }
}
