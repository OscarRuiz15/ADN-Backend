package adn.oscar.reservascanchas.dominio.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;

import java.util.List;

public interface RepositorioCliente {

    /**
     * Obtener un cliente dada la cedula
     *
     * @param cedula
     * @return Cliente
     */
    Cliente obtenerPorCedula(String cedula);

    /**
     * Agregar un registro cliente al repositorio
     *
     * @param cliente
     * @return Cliente
     */
    Cliente agregar(Cliente cliente);

    /**
     * Obtener todos los registros del modelo cliente
     */
    List<Cliente> listaClientes();

    /**
     * Actualizar un registro cliente
     *
     * @param cliente
     * @return Cliente
     */
    Cliente actualizar(Cliente cliente);
}
