package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.excepcion.ReservaException;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {

    private final RepositorioReserva repositorioReserva;
    public final static String LA_RESERVA_A_ELIMINAR_NO_EXISTE = "La reserva a eliminar no existe";

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva ejecutar(Long id) {
        if (!existe(id)) {
            throw new ReservaException(LA_RESERVA_A_ELIMINAR_NO_EXISTE);
        }
        return repositorioReserva.remover(id);
    }

    public boolean existe(Long id) {
        return this.repositorioReserva.obtenerPorId(id) != null;
    }
}
