package adn.oscar.reservascanchas.aplicacion.comando;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;

public class ComandoReserva {

    private final double valorPago;
    private final String fechaFinReserva;
    private final String fechaInicioReserva;
    private final Cliente cliente;
    private final Cancha cancha;
    private final Long id;

    public ComandoReserva(double valorPago, String fechaFinReserva, String fechaInicioReserva, Cliente cliente, Cancha cancha, Long id) {
        this.valorPago = valorPago;
        this.fechaFinReserva = fechaFinReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.cliente = cliente;
        this.cancha = cancha;
        this.id = id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getFechaFinReserva() {
        return fechaFinReserva;
    }

    public String getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public Long getId() {
        return id;
    }
}
