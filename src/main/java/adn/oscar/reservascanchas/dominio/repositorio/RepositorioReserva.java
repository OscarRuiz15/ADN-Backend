package adn.oscar.reservascanchas.dominio.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;

import java.util.Date;

public interface RepositorioReserva {

    /**
     * Obtener una reserva dado el codigo de la cancha, la cedula del cliente y la fecha de inicio reserva
     *
     * @param codigoCancha
     * @param cedulaCliente
     * @param fechaInicioReserva
     * @return Reserva
     */
    Reserva obtenerPorCodigoCedulaYFecha(String codigoCancha, String cedulaCliente, Date fechaInicioReserva);

    /**
     * Agregar un registro reserva al repositorio
     *
     * @param reserva
     * @return Reserva
     */
    Reserva agregar(Reserva reserva);

    /**
     * Verificar si la cancha esta ocupada
     *
     * @param codigoCancha
     * @param fechaInicioReserva
     */
    Reserva verificarDisponibilidadCancha(String codigoCancha, Date fechaInicioReserva);

    /**
     * Obtener reserva por id
     *
     * @param id
     */
    Reserva obtenerPorId(Long id);
}
