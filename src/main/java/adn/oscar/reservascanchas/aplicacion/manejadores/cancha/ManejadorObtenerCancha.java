package adn.oscar.reservascanchas.aplicacion.manejadores.cancha;

import adn.oscar.reservascanchas.dominio.Cancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioObtenerCancha;

import javax.transaction.Transactional;

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
