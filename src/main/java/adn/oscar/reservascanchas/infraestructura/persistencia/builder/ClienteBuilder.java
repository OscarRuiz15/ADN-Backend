package adn.oscar.reservascanchas.infraestructura.persistencia.builder;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ClienteEntity;

public final class ClienteBuilder {

    private ClienteBuilder() {
    }

    public static Cliente convertirADominio(ClienteEntity clienteEntity) {
        Cliente cliente = null;
        if (clienteEntity != null) {
            cliente = new Cliente(clienteEntity.getId(), clienteEntity.getNombre(), clienteEntity.getCorreo(),
                    clienteEntity.getTelefono(), clienteEntity.getCedula());
        }
        return cliente;
    }

    public static ClienteEntity convertirAEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setCorreo(cliente.getCorreo());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setCedula(cliente.getCedula());

        return clienteEntity;
    }
}
