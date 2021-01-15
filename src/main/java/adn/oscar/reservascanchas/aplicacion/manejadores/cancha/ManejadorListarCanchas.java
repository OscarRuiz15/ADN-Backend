package adn.oscar.reservascanchas.aplicacion.manejadores.cancha;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioListarCanchas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCanchas {

    private final ServicioListarCanchas servicioListarCanchas;

    public ManejadorListarCanchas(ServicioListarCanchas servicioListarCanchas) {
        this.servicioListarCanchas = servicioListarCanchas;
    }

    public List<Cancha> ejecutar() {
        return this.servicioListarCanchas.ejecutar();
    }
}
