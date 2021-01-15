package adn.oscar.reservascanchas.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Reserva")
@NamedQuery(name = "Reserva.obtenerTodos", query = "SELECT reservas FROM Reserva reservas")
@NamedQuery(name = "Reserva.obtenerPorCodigoCanchaYCedulaClienteYFechaInicioReserva",
        query = "SELECT reserva FROM Reserva reserva WHERE " +
                "reserva.cancha.codigo = :codigoCancha " +
                "AND " +
                "reserva.cliente.cedula = :cedulaCliente " +
                "AND " +
                "reserva.fechaInicioReserva = :fechaInicioReserva")
@NamedQuery(name = "Reserva.verificarDisponibilidadCancha",
        query = "SELECT reserva FROM Reserva reserva WHERE " +
                "reserva.fechaInicioReserva <= :fechaInicioReserva " +
                "AND " +
                "reserva.fechaFinReserva >= :fechaInicioReserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date fechaInicioReserva;

    @Column(nullable = false)
    private Date fechaFinReserva;

    @Column(nullable = false)
    private double valorPago;

    @ManyToOne
    @JoinColumn(name = "id_cancha", referencedColumnName = "id", nullable = false)
    private CanchaEntity cancha;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private ClienteEntity cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaInicioReserva() {
        return (Date) fechaInicioReserva.clone();
    }

    public void setFechaInicioReserva(Date fechaInicioReserva) {
        this.fechaInicioReserva = (Date) fechaInicioReserva.clone();
    }

    public Date getFechaFinReserva() {
        return (Date) fechaFinReserva.clone();
    }

    public void setFechaFinReserva(Date fechaFinReserva) {
        this.fechaFinReserva = (Date) fechaFinReserva.clone();
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public CanchaEntity getCancha() {
        return cancha;
    }

    public void setCancha(CanchaEntity cancha) {
        this.cancha = cancha;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
