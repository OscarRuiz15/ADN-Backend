package adn.oscar.reservascanchas.aplicacion.manejadores.cancha;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioActualizarCancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioObtenerCancha;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCancha {

    private final ServicioActualizarCancha servicioActualizarCancha;
    private final ServicioObtenerCancha servicioObtenerCancha;

    public ManejadorActualizarCancha(ServicioActualizarCancha servicioActualizarCancha, ServicioObtenerCancha servicioObtenerCancha) {
        this.servicioActualizarCancha = servicioActualizarCancha;
        this.servicioObtenerCancha = servicioObtenerCancha;
    }

    public Cancha ejecutar(ComandoCancha comandoCancha) {
        Cancha cancha = this.servicioObtenerCancha.ejecutar(comandoCancha.getCodigo());
        cancha.setNombre(comandoCancha.getNombre());
        cancha.setDireccion(comandoCancha.getDireccion());
        cancha.setTipoCancha(comandoCancha.getTipoCancha());
        cancha.setPrecioReserva(comandoCancha.getPrecioReserva());
        cancha.setTelefono(comandoCancha.getTelefono());
        return this.servicioActualizarCancha.ejecutar(cancha);
    }
}
