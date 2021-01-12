package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.modelos.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;


public class ServicioCrearCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente ejecutar(Cliente cliente) {
        return this.repositorioCliente.agregar(cliente);
    }
}
