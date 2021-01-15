package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;

import java.util.List;

public class ServicioListarReservas {

    private final RepositorioReserva repositorioReserva;

    public ServicioListarReservas(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public List<Reserva> ejecutar() {
        return this.repositorioReserva.listaReservas();
    }
}
