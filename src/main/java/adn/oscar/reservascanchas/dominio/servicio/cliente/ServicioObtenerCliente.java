package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.modelos.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;

public class ServicioObtenerCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioObtenerCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente ejecutar(String cedula) {
        return this.repositorioCliente.obtenerPorCedula(cedula);
    }
}
