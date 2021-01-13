package adn.oscar.reservascanchas.dominio.modelo;

import adn.oscar.reservascanchas.dominio.excepcion.FormatoFechaException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static adn.oscar.reservascanchas.dominio.Validaciones.*;

public class Reserva {

    public static final String ERROR_PARSEANDO_FECHAS = "Ocurrio un error con el formato de las fechas.";
    public static final String NO_HA_ELEGIDO_CANCHA_A_RESERVAR = "No se ha seleccionado una cancha a reservar.";
    public static final String NO_HAY_CLIENTE_A_REALIZAR_RESERVA = "No se ha seleccionado un cliente a realizar la reserva.";
    public static final String LA_FECHA_DE_INICIO_RESERVA_ES_OBLIGATORIA = "La fecha para realizar la reserva es obligatoria";
    public static final String LA_FECHA_DE_FIN_RESERVA_ES_OBLIGATORIA = "La fecha en la que termina la reserva es obligatoria.";
    public static final String EL_PRECIO_A_PAGAR_POR_RESERVAR_DEBE_SER_MAYOR_A_CERO = "El precio a pagar por reservar debe ser mayor a 0.";
    public static final String EL_PRECIO_A_PAGAR_POR_RESERVA_ES_OBLIGATORIO = "El precio a pagar por reserva es obligatorio.";
    private static final String FORMATO_FECHA = "yyyy-MM-dd H:m";

    private final Cancha cancha;
    private final Cliente cliente;
    private final Date fechaInicioReserva;
    private final Date fechaFinReserva;
    private final double valorPago;

    public Reserva(Cancha cancha, Cliente cliente, String fechaInicioReserva, String fechaFinReserva, double valorPago) {
        validarObligatorio(cancha, NO_HA_ELEGIDO_CANCHA_A_RESERVAR);
        validarObligatorio(cliente, NO_HAY_CLIENTE_A_REALIZAR_RESERVA);
        validarCadenaVacia(fechaInicioReserva, LA_FECHA_DE_INICIO_RESERVA_ES_OBLIGATORIA);
        validarCadenaVacia(fechaFinReserva, LA_FECHA_DE_FIN_RESERVA_ES_OBLIGATORIA);
        validarValorObligatorio(valorPago, EL_PRECIO_A_PAGAR_POR_RESERVA_ES_OBLIGATORIO);
        validarDecimalPositivo(valorPago, EL_PRECIO_A_PAGAR_POR_RESERVAR_DEBE_SER_MAYOR_A_CERO);

        try {
            this.fechaInicioReserva = new SimpleDateFormat(FORMATO_FECHA).parse(fechaInicioReserva);
            this.fechaFinReserva = new SimpleDateFormat(FORMATO_FECHA).parse(fechaFinReserva);
        } catch (ParseException parseException) {
            throw new FormatoFechaException(ERROR_PARSEANDO_FECHAS);
        }
        this.cancha = cancha;
        this.cliente = cliente;
        this.valorPago = valorPago;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public Date getFechaFinReserva() {
        return fechaFinReserva;
    }

    public double getValorPago() {
        return valorPago;
    }
}
