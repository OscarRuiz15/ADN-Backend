package adn.oscar.reservascanchas.aplicacion.manejadores.cliente;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioListarClientes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarClientes {

    private final ServicioListarClientes servicioListarClientes;

    public ManejadorListarClientes(ServicioListarClientes servicioListarClientes) {
        this.servicioListarClientes = servicioListarClientes;
    }

    public List<Cliente> ejecutar() {
        return this.servicioListarClientes.ejecutar();
    }
}
