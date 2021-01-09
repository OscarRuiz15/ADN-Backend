package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa;

import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.CanchaEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCanchaJPA extends CrudRepository<CanchaEntity, Long> {

    /**
     * Obtener una entidad cancha dado el codigo
     *
     * @param codigo
     * @return CanchaEntity
     */
    CanchaEntity findCanchaByCodigo(String codigo);
}
