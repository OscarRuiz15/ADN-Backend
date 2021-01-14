package adn.oscar.reservascanchas.aplicacion.fabrica;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaReserva {
    public Reserva crearReserva(ComandoReserva comandoReserva) {
        return new Reserva(comandoReserva.getId(), comandoReserva.getCancha(), comandoReserva.getCliente(), comandoReserva.getFechaInicioReserva(), comandoReserva.getFechaFinReserva(), comandoReserva.getValorPago());
    }
}
