package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.aplicacion.manejadores.cancha.ManejadorCrearCancha;
import adn.oscar.reservascanchas.aplicacion.manejadores.cancha.ManejadorListarCanchas;
import adn.oscar.reservascanchas.aplicacion.manejadores.cancha.ManejadorObtenerCancha;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canchas")
@CrossOrigin(origins = "*")
public class ControladorCancha {

    private final ManejadorCrearCancha manejadorCrearCancha;
    private final ManejadorObtenerCancha manejadorObtenerCancha;
    private final ManejadorListarCanchas manejadorListarCanchas;

    public ControladorCancha(ManejadorCrearCancha manejadorCrearCancha, ManejadorObtenerCancha manejadorObtenerCancha, ManejadorListarCanchas manejadorListarCanchas) {
        this.manejadorCrearCancha = manejadorCrearCancha;
        this.manejadorObtenerCancha = manejadorObtenerCancha;
        this.manejadorListarCanchas = manejadorListarCanchas;
    }

    @PostMapping
    public Cancha agregar(@RequestBody ComandoCancha comandoCancha) {
        return this.manejadorCrearCancha.ejecutar(comandoCancha);
    }

    @GetMapping("/{codigo}")
    public Cancha buscar(@PathVariable(name = "codigo") String codigo) {
        return this.manejadorObtenerCancha.ejecutar(codigo);
    }

    @GetMapping
    public List<Cancha> listar() {
        return this.manejadorListarCanchas.ejecutar();
    }
}
