package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.aplicacion.manejadores.cliente.ManejadorCrearCliente;
import adn.oscar.reservascanchas.aplicacion.manejadores.cliente.ManejadorObtenerCliente;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorObtenerCliente manejadorObtenerCliente;

    public ControladorCliente(ManejadorCrearCliente manejadorCrearCliente, ManejadorObtenerCliente manejadorObtenerCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorObtenerCliente = manejadorObtenerCliente;
    }

    @PostMapping
    public Cliente agregar(@RequestBody ComandoCliente comandoCliente) {
        return this.manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @GetMapping("/{cedula}")
    public Cliente buscar(@PathVariable(name = "cedula") String cedula) {
        return this.manejadorObtenerCliente.ejecutar(cedula);
    }
}
