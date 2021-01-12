package adn.oscar.reservascanchas.infraestructura.persistencia.builder;

import adn.oscar.reservascanchas.dominio.modelos.Cliente;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ClienteEntity;

public class ClienteBuilder {

    private ClienteBuilder() {
    }

    public static Cliente convertirADominio(ClienteEntity clienteEntity) {
        Cliente cliente = null;
        if (clienteEntity != null) {
            cliente = new Cliente(clienteEntity.getNombre(), clienteEntity.getEmail(),
                    clienteEntity.getTelefono(), clienteEntity.getCedula());
        }
        return cliente;
    }

    public static ClienteEntity convertirAEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setCedula(cliente.getCedula());

        return clienteEntity;
    }
}
