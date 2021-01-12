package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Cliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.ClienteBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ClienteEntity;
import adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa.RepositorioClienteJPA;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientePersistente implements RepositorioCliente {

    private final RepositorioClienteJPA repositorioClienteJPA;

    public RepositorioClientePersistente(RepositorioClienteJPA repositorioClienteJPA) {
        this.repositorioClienteJPA = repositorioClienteJPA;
    }

    @Override
    public Cliente obtenerPorCedula(String cedula) {
        ClienteEntity clienteEntity = repositorioClienteJPA.findClienteEntityByCedula(cedula);
        return ClienteBuilder.convertirADominio(clienteEntity);
    }

    @Override
    public Cliente agregar(Cliente cliente) {
        ClienteEntity clienteEntity = repositorioClienteJPA.save(ClienteBuilder.convertirAEntity(cliente));
        return ClienteBuilder.convertirADominio(clienteEntity);
    }
}
