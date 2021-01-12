package adn.oscar.reservascanchas.aplicacion.manejadores.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioObtenerCancha;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ManejadorObtenerCancha {

    private final ServicioObtenerCancha servicioObtenerCancha;

    public ManejadorObtenerCancha(ServicioObtenerCancha servicioObtenerCancha) {
        this.servicioObtenerCancha = servicioObtenerCancha;
    }

    @Transactional
    public Cancha ejecutar(String codigo) {
        return this.servicioObtenerCancha.ejecutar(codigo);
    }
}
