package adn.oscar.reservascanchas.dominio.modelo;

import java.util.Date;

import static adn.oscar.reservascanchas.dominio.Validaciones.*;

public class Reserva {

    public static final String ERROR_PARSEANDO_FECHAS = "Ocurrio un error con el formato de las fechas.";
    public static final String NO_HA_ELEGIDO_CANCHA_A_RESERVAR = "No se ha seleccionado una cancha a reservar.";
    public static final String NO_HAY_CLIENTE_A_REALIZAR_RESERVA = "No se ha seleccionado un cliente a realizar la reserva.";
    public static final String LA_FECHA_DE_INICIO_RESERVA_ES_OBLIGATORIA = "La fecha para realizar la reserva es obligatoria";

    private final Long id;
    private final Cancha cancha;
    private final Cliente cliente;
    private final Date fechaInicioReserva;
    private Date fechaFinReserva;
    private double valorPago;

    public Reserva(Long id, Cancha cancha, Cliente cliente, String fechaInicioReserva, String fechaFinReserva, double valorPago) {
        validarObligatorio(cancha, NO_HA_ELEGIDO_CANCHA_A_RESERVAR);
        validarObligatorio(cliente, NO_HAY_CLIENTE_A_REALIZAR_RESERVA);
        validarCadenaVacia(fechaInicioReserva, LA_FECHA_DE_INICIO_RESERVA_ES_OBLIGATORIA);

        this.cancha = cancha;
        this.cliente = cliente;
        this.id = id;
        this.valorPago = valorPago;
        this.fechaInicioReserva = validarFormatoFecha(fechaInicioReserva, ERROR_PARSEANDO_FECHAS);
        this.fechaFinReserva = validarFormatoFecha(fechaFinReserva, ERROR_PARSEANDO_FECHAS);
    }

    public Long getId() {
        return id;
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

    public void setFechaFinReserva(Date fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
