package adn.oscar.reservascanchas.dominio.servicio.cliente;

import adn.oscar.reservascanchas.dominio.excepcion.ClienteException;
import adn.oscar.reservascanchas.dominio.modelos.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;


public class ServicioCrearCliente {

    private static final String YA_EXISTE_UN_CLIENTE_REGISTRADO_CON_LA_MISMA_CEDULA = "Ya existe un cliente registrado con la misma cedula";

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente ejecutar(Cliente cliente) {

        if (yaExisteCliente(cliente.getCedula())) {
            throw new ClienteException(YA_EXISTE_UN_CLIENTE_REGISTRADO_CON_LA_MISMA_CEDULA);
        }

        return this.repositorioCliente.agregar(cliente);
    }

    private boolean yaExisteCliente(String cedula) {
        return this.repositorioCliente.obtenerPorCedula(cedula) != null;
    }
}
