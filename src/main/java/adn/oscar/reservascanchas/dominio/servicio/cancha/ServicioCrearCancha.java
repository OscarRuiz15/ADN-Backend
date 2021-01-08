package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearCancha {

    private final RepositorioCancha repositorioCancha;

    public ServicioCrearCancha(RepositorioCancha repositorioCancha) {
        this.repositorioCancha = repositorioCancha;
    }

    public void ejecutar(Cancha cancha) {
        this.repositorioCancha.agregar(cancha);
    }
}
