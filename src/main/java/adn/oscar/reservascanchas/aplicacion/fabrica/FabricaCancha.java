package adn.oscar.reservascanchas.aplicacion.fabrica;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.dominio.modelos.Cancha;
import org.springframework.stereotype.Component;

@Component
public class FabricaCancha {
    public Cancha crearCancha(ComandoCancha comandoCancha) {
        return new Cancha(comandoCancha.getCodigo(), comandoCancha.getNombre(), comandoCancha.getDireccion(),
                comandoCancha.getTelefono(), comandoCancha.getTipoCancha(), comandoCancha.getPrecioReserva());
    }
}
