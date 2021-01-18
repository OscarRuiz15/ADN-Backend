package adn.oscar.reservascanchas.aplicacion.manejadores.cliente;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.aplicacion.fabrica.FabricaCliente;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioActualizarCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente {

    private final ServicioActualizarCliente servicioActualizarCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorActualizarCliente(ServicioActualizarCliente servicioActualizarCliente, FabricaCliente fabricaCliente) {
        this.servicioActualizarCliente = servicioActualizarCliente;
        this.fabricaCliente = fabricaCliente;
    }

    public Cliente ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crearCliente(comandoCliente);
        return this.servicioActualizarCliente.ejecutar(cliente);
    }
}
