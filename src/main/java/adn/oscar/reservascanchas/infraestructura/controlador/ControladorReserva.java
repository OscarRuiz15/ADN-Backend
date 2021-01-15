package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoReserva;
import adn.oscar.reservascanchas.aplicacion.manejadores.reserva.ManejadorCrearReserva;
import adn.oscar.reservascanchas.aplicacion.manejadores.reserva.ManejadorListarReservas;
import adn.oscar.reservascanchas.aplicacion.manejadores.reserva.ManejadorObtenerReserva;
import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorObtenerReserva manejadorObtenerReserva;
    private final ManejadorListarReservas manejadorListarReservas;

    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorObtenerReserva manejadorObtenerReserva, ManejadorListarReservas manejadorListarReservas) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorObtenerReserva = manejadorObtenerReserva;
        this.manejadorListarReservas = manejadorListarReservas;
    }

    @PostMapping
    public Reserva agregar(@RequestBody ComandoReserva comandoReserva) {
        return this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable(name = "id") Long id) {
        return this.manejadorObtenerReserva.ejecutar(id);
    }

    @GetMapping
    public List<Reserva> listar() {
        return this.manejadorListarReservas.ejecutar();
    }
}
