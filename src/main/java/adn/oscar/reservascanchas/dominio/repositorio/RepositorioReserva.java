package adn.oscar.reservascanchas.dominio.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;

public interface RepositorioReserva {

    /**
     * Obtener una reserva dado el codigo de la cancha y la cedula del cliente
     *
     * @param codigo
     * @param cedula
     * @return Reserva
     */
    Reserva obtenerPorCodigoYCedula(String codigo, String cedula);

    /**
     * Agregar un registro reserva al repositorio
     *
     * @param reserva
     * @return Reserva
     */
    Reserva agregar(Reserva reserva);
}
