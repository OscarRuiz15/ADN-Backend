package adn.oscar.reservascanchas.aplicacion.manejadores.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioObtenerReserva;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ManejadorObtenerReserva {

    private final ServicioObtenerReserva servicioObtenerReserva;

    public ManejadorObtenerReserva(ServicioObtenerReserva servicioObtenerReserva) {
        this.servicioObtenerReserva = servicioObtenerReserva;
    }

    @Transactional
    public Reserva ejecutar(String codigoCancha, String cedulaCliente) {
        return null;
    }
}
