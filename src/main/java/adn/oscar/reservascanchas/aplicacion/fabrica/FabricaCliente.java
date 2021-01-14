package adn.oscar.reservascanchas.aplicacion.fabrica;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {
    public Cliente crearCliente(ComandoCliente comandoCliente) {
        return new Cliente(comandoCliente.getId(), comandoCliente.getNombre(), comandoCliente.getCorreo(),
                comandoCliente.getTelefono(), comandoCliente.getCedula());
    }
}
