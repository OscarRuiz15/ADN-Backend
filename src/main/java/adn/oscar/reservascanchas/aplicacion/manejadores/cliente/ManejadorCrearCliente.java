package adn.oscar.reservascanchas.aplicacion.manejadores.cliente;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.aplicacion.fabrica.FabricaCliente;
import adn.oscar.reservascanchas.dominio.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioCrearCliente;

import javax.transaction.Transactional;

public class ManejadorCrearCliente {

    private final ServicioCrearCliente servicioCrearCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorCrearCliente(ServicioCrearCliente servicioCrearCliente, FabricaCliente fabricaCliente) {
        this.servicioCrearCliente = servicioCrearCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Transactional
    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crearCliente(comandoCliente);
        this.servicioCrearCliente.ejecutar(cliente);
    }
}
