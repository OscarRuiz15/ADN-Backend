package adn.oscar.reservascanchas.infraestructura.controlador;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.aplicacion.manejadores.cliente.ManejadorActualizarCliente;
import adn.oscar.reservascanchas.aplicacion.manejadores.cliente.ManejadorCrearCliente;
import adn.oscar.reservascanchas.aplicacion.manejadores.cliente.ManejadorListarClientes;
import adn.oscar.reservascanchas.aplicacion.manejadores.cliente.ManejadorObtenerCliente;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorObtenerCliente manejadorObtenerCliente;
    private final ManejadorListarClientes manejadorListarClientes;
    private final ManejadorActualizarCliente manejadorActualizarCliente;

    public ControladorCliente(ManejadorCrearCliente manejadorCrearCliente, ManejadorObtenerCliente manejadorObtenerCliente,
                              ManejadorListarClientes manejadorListarClientes, ManejadorActualizarCliente manejadorActualizarCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorObtenerCliente = manejadorObtenerCliente;
        this.manejadorListarClientes = manejadorListarClientes;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
    }

    @PostMapping
    public Cliente agregar(@RequestBody ComandoCliente comandoCliente) {
        return this.manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @GetMapping("/{cedula}")
    public Cliente buscar(@PathVariable(name = "cedula") String cedula) {
        return this.manejadorObtenerCliente.ejecutar(cedula);
    }

    @GetMapping
    public List<Cliente> listar() {
        return this.manejadorListarClientes.ejecutar();
    }

    @PutMapping
    public Cliente actualizar(@RequestBody ComandoCliente comandoCliente) {
        return this.manejadorActualizarCliente.ejecutar(comandoCliente);
    }
}
