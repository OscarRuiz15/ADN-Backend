package adn.oscar.reservascanchas.aplicacion.manejadores.cliente;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.aplicacion.fabrica.FabricaCliente;
import adn.oscar.reservascanchas.dominio.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioCrearCliente;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ManejadorCrearCliente {

    private final ServicioCrearCliente servicioCrearCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorCrearCliente(ServicioCrearCliente servicioCrearCliente, FabricaCliente fabricaCliente) {
        this.servicioCrearCliente = servicioCrearCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Transactional
    public Cliente ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crearCliente(comandoCliente);
        return this.servicioCrearCliente.ejecutar(cliente);
    }
}
