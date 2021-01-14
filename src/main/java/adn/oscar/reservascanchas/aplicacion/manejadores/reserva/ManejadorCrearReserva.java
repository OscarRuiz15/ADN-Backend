package adn.oscar.reservascanchas.aplicacion.manejadores.reserva;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.aplicacion.fabrica.FabricaReserva;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioCrearReserva;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ManejadorCrearReserva {

    private final ServicioCrearReserva servicioCrearReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva) {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva = fabricaReserva;
    }

    @Transactional
    public Reserva ejecutar(ComandoReserva comandoReserva) {
        Reserva reserva = this.fabricaReserva.crearReserva(comandoReserva);
        return this.servicioCrearReserva.ejecutar(reserva);
    }
}
