package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.aplicacion.manejadores.cancha.ManejadorCrearCancha;
import adn.oscar.reservascanchas.aplicacion.manejadores.cancha.ManejadorObtenerCancha;
import adn.oscar.reservascanchas.dominio.Cancha;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canchas")
public class ControladorCancha {

    private final ManejadorCrearCancha manejadorCrearCancha;
    private final ManejadorObtenerCancha manejadorObtenerCancha;

    public ControladorCancha(ManejadorCrearCancha manejadorCrearCancha, ManejadorObtenerCancha manejadorObtenerCancha) {
        this.manejadorCrearCancha = manejadorCrearCancha;
        this.manejadorObtenerCancha = manejadorObtenerCancha;
    }

    @PostMapping
    public Cancha agregar(@RequestBody ComandoCancha comandoCancha) {
        return this.manejadorCrearCancha.ejecutar(comandoCancha);
    }

    @GetMapping("/{codigo}")
    public Cancha buscar(@PathVariable(name = "codigo") String codigo) {
        return this.manejadorObtenerCancha.ejecutar(codigo);
    }
}
