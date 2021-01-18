package adn.oscar.reservascanchas.aplicacion.manejadores.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioEliminarReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarReserva {

    private final ServicioEliminarReserva servicioEliminarReserva;

    public ManejadorEliminarReserva(ServicioEliminarReserva servicioEliminarReserva) {
        this.servicioEliminarReserva = servicioEliminarReserva;
    }

    public Reserva ejecutar(Long id) {
        return this.servicioEliminarReserva.ejecutar(id);
    }
}
