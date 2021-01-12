package adn.oscar.reservascanchas.aplicacion.manejadores.cliente;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioObtenerCliente;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ManejadorObtenerCliente {

    private final ServicioObtenerCliente servicioObtenerCliente;

    public ManejadorObtenerCliente(ServicioObtenerCliente servicioObtenerCliente) {
        this.servicioObtenerCliente = servicioObtenerCliente;
    }

    @Transactional
    public Cliente ejecutar(String cedula) {
        return this.servicioObtenerCliente.ejecutar(cedula);
    }
}
