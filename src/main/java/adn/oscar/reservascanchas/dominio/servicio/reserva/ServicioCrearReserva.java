package adn.oscar.reservascanchas.dominio.servicio.reserva;

import adn.oscar.reservascanchas.dominio.excepcion.ReservaException;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;

import java.util.Calendar;
import java.util.Date;

public class ServicioCrearReserva {

    private final RepositorioReserva repositorioReserva;
    private static final double PORCENTAJE_EXTRA = 0.1;
    public static final String NO_SE_PUEDE_REALIZAR_RESERVACIONES_PARA_EL_DIA_ACTUAL = "No se pueden realizar reservaciones para el dia actual";
    public static final String LA_CANCHA_YA_HA_SIDO_RESERVADA_POR_EL_CLIENTE_PARA_LA_MISMA_FECHA = "La cancha ya ha sido reservada por el cliente para la misma fecha";
    public static final String LA_CANCHA_NO_ESTA_DISPONIBLE_PARA_LA_FECHA_ELEGIDA_YA_ESTA_RESERVADA = "La cancha no esta disponible para la fecha elegida, ya esta reservada";

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva ejecutar(Reserva reserva) {
        Cancha cancha = reserva.getCancha();
        Cliente cliente = reserva.getCliente();
        Date fechaInicioReserva = reserva.getFechaInicioReserva();

        if (yaHayReserva(cancha.getCodigo(), cliente.getCedula(), fechaInicioReserva)) {
            throw new ReservaException(LA_CANCHA_YA_HA_SIDO_RESERVADA_POR_EL_CLIENTE_PARA_LA_MISMA_FECHA);
        }

        if (laCanchaEstaOcupada(cancha.getCodigo(), fechaInicioReserva)) {
            throw new ReservaException(LA_CANCHA_NO_ESTA_DISPONIBLE_PARA_LA_FECHA_ELEGIDA_YA_ESTA_RESERVADA);
        }

        if (!validarDiaHabil(fechaInicioReserva)) {
            throw new ReservaException(NO_SE_PUEDE_REALIZAR_RESERVACIONES_PARA_EL_DIA_ACTUAL);
        }

        Date fechaFinReserva = calcularFechaFinReserva(fechaInicioReserva);
        reserva.setFechaFinReserva(fechaFinReserva);

        double valorPagar = calcularValorPago(fechaInicioReserva, cancha.getPrecioReserva());
        reserva.setValorPago(valorPagar);
        return this.repositorioReserva.agregar(reserva);
    }

    private boolean laCanchaEstaOcupada(String codigoCancha, Date fechaInicioReserva) {
        return this.repositorioReserva.verificarDisponibilidadCancha(codigoCancha, fechaInicioReserva) != null;
    }

    private boolean yaHayReserva(String codigoCancha, String cedulaCliente, Date fechaInicioReserva) {
        return this.repositorioReserva.obtenerPorCodigoCedulaYFecha(codigoCancha, cedulaCliente, fechaInicioReserva) != null;
    }

    public boolean validarDiaHabil(Date fechaInicioReserva) {
        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.setTime(fechaInicioReserva);

        Date hoy = new Date();
        Calendar fechaFin = Calendar.getInstance();
        fechaFin.setTime(hoy);

        return fechaInicio.get(Calendar.DAY_OF_YEAR) != fechaFin.get(Calendar.DAY_OF_YEAR);
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
