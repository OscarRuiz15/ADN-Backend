package adn.oscar.reservascanchas.aplicacion.manejadores.cancha;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.aplicacion.fabrica.FabricaCancha;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioActualizarCancha;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCancha {

    private final ServicioActualizarCancha servicioActualizarCancha;
    private final FabricaCancha fabricaCancha;

    public ManejadorActualizarCancha(ServicioActualizarCancha servicioActualizarCancha, FabricaCancha fabricaCancha) {
        this.servicioActualizarCancha = servicioActualizarCancha;
        this.fabricaCancha = fabricaCancha;
    }

    public Cancha ejecutar(ComandoCancha comandoCancha) {
        Cancha cancha = this.fabricaCancha.crearCancha(comandoCancha);
        return this.servicioActualizarCancha.ejecutar(cancha);
    }
}
