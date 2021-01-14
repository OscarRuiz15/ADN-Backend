package adn.oscar.reservascanchas.testdatabuilder;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;

public class ReservaTestDataBuilder {

    private static final Long ID = 27L;
    private static final Cancha CANCHA = new CanchaTestDataBuilder().build();
    private static final Cliente CLIENTE = new ClienteTestDataBuilder().build();
    private static final String FECHA_INICIO_RESERVA = "2021-01-13 09:00";
    private static final String FECHA_FIN_RESERVA = "2021-01-13 10:00";
    private static final double VALOR_PAGO = CANCHA.getPrecioReserva();

    private final Long id;
    private Cancha cancha;
    private Cliente cliente;
    private String fechaInicioReserva;
    private final String fechaFinReserva;
    private final double valorPago;

    public ReservaTestDataBuilder() {
        this.id = ID;
        this.cancha = CANCHA;
        this.cliente = CLIENTE;
        this.fechaInicioReserva = FECHA_INICIO_RESERVA;
        this.fechaFinReserva = FECHA_FIN_RESERVA;
        this.valorPago = VALOR_PAGO;
    }

    public ReservaTestDataBuilder conCancha(Cancha cancha) {
        this.cancha = cancha;
        return this;
    }

    public ReservaTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ReservaTestDataBuilder conFechaInicioReserva(String fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
        return this;
    }

    public Reserva build() {
        return new Reserva(id, cancha, cliente, fechaInicioReserva, fechaFinReserva, valorPago);
    }

    public ComandoReserva buildComando() {
        return new ComandoReserva(valorPago, fechaFinReserva, fechaInicioReserva, cliente, cancha, id);
    }
}

