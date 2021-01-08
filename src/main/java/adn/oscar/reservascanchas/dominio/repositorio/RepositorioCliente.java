package adn.oscar.reservascanchas.dominio.repositorio;

import adn.oscar.reservascanchas.dominio.Cliente;

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
     */
    void agregar(Cliente cliente);
}
