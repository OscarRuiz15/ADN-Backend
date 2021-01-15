package adn.oscar.reservascanchas.aplicacion.manejadores.reserva;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioListarReservas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservas {

    private final ServicioListarReservas servicioListarReservas;

    public ManejadorListarReservas(ServicioListarReservas servicioListarReservas) {
        this.servicioListarReservas = servicioListarReservas;
    }

    public List<Reserva> ejecutar() {
        return this.servicioListarReservas.ejecutar();
    }
}
