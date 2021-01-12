package adn.oscar.reservascanchas.aplicacion.manejadores.cancha;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.aplicacion.fabrica.FabricaCancha;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioCrearCancha;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ManejadorCrearCancha {

    private final ServicioCrearCancha servicioCrearCancha;
    private final FabricaCancha fabricaCancha;

    public ManejadorCrearCancha(ServicioCrearCancha servicioCrearCancha, FabricaCancha fabricaCancha) {
        this.servicioCrearCancha = servicioCrearCancha;
        this.fabricaCancha = fabricaCancha;
    }

    @Transactional
    public Cancha ejecutar(ComandoCancha comandoCancha) {
        Cancha cancha = this.fabricaCancha.crearCancha(comandoCancha);
        return this.servicioCrearCancha.ejecutar(cancha);
    }
}
