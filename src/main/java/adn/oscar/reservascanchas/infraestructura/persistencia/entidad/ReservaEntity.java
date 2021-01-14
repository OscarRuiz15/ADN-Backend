package adn.oscar.reservascanchas.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Reserva")
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
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(Date fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public Date getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(Date fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
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
