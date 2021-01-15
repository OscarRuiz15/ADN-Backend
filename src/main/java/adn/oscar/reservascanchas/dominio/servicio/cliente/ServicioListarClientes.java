package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;

import java.util.List;

public class ServicioListarClientes {

    private final RepositorioCliente repositorioCliente;

    public ServicioListarClientes(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> ejecutar() {
        return this.repositorioCliente.listaClientes();
    }
}
