package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        this.repositorioCliente.agregar(cliente);
    }
}
