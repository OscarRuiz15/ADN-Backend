package adn.oscar.reservascanchas.aplicacion.manejadores.cliente;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioActualizarCliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioObtenerCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente {

    private final ServicioActualizarCliente servicioActualizarCliente;
    private final ServicioObtenerCliente servicioObtenerCliente;

    public ManejadorActualizarCliente(ServicioActualizarCliente servicioActualizarCliente, ServicioObtenerCliente servicioObtenerCliente) {
        this.servicioActualizarCliente = servicioActualizarCliente;
        this.servicioObtenerCliente = servicioObtenerCliente;
    }

    public Cliente ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.servicioObtenerCliente.ejecutar(comandoCliente.getCedula());
        cliente.setNombre(comandoCliente.getNombre());
        cliente.setCorreo(comandoCliente.getCorreo());
        cliente.setTelefono(comandoCliente.getTelefono());
        return this.servicioActualizarCliente.ejecutar(cliente);
    }
}
