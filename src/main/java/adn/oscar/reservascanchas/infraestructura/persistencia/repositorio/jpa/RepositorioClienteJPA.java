package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa;

import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioClienteJPA extends CrudRepository<ClienteEntity, Long> {

    /**
     * Obtener una entidad cliente dada la cedula
     *
     * @param cedula
     * @return ClienteEntity
     */
    ClienteEntity findClienteEntityByCedula(String cedula);
}
