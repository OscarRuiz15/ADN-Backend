package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;

public class ServicioObtenerReserva {

    private final RepositorioReserva repositorioReserva;

    public ServicioObtenerReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva ejecutar(String cedula) {
        return null;
    }
}
