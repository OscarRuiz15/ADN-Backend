package adn.oscar.reservascanchas.aplicacion.fabrica;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.dominio.Cliente;

public class FabricaCliente {
    public Cliente crearCliente(ComandoCliente comandoCliente) {
        return new Cliente(comandoCliente.getNombre(), comandoCliente.getEmail(),
                comandoCliente.getTelefono(), comandoCliente.getCedula());
    }
}
