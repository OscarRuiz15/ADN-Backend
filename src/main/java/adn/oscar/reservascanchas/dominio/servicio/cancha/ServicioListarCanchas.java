package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;

import java.util.List;

public class ServicioListarCanchas {

    private final RepositorioCancha repositorioCancha;

    public ServicioListarCanchas(RepositorioCancha repositorioCancha) {
        this.repositorioCancha = repositorioCancha;
    }

    public List<Cancha> ejecutar() {
        return this.repositorioCancha.listaCanchas();
    }
}
