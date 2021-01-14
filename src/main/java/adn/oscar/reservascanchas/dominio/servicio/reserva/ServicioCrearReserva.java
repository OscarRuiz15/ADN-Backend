package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;

import java.util.Calendar;
import java.util.Date;

public class ServicioCrearReserva {

    private final RepositorioReserva repositorioReserva;
    private static final double PORCENTAJE_EXTRA = 0.1;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva ejecutar(Reserva reserva) {
        Date fechaFinReserva = calcularFechaFinReserva(reserva.getFechaInicioReserva());
        reserva.setFechaFinReserva(fechaFinReserva);
        double valorPagar = calcularValorPago(reserva.getFechaInicioReserva(), reserva.getCancha().getPrecioReserva());
        reserva.setValorPago(valorPagar);
        return this.repositorioReserva.agregar(reserva);
    }

    public Date calcularFechaFinReserva(Date fechaInicioReserva) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicioReserva);
        calendar.add(Calendar.HOUR, 1);
        return calendar.getTime();
    }

    public double calcularValorPago(Date fechaInicioReserva, double precioReserva) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicioReserva);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return precioReserva + (precioReserva * PORCENTAJE_EXTRA);
        }

        return precioReserva;
    }
}
