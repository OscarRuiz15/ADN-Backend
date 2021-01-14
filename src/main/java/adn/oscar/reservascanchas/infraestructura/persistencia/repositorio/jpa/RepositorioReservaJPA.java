package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa;

import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ReservaEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioReservaJPA extends CrudRepository<ReservaEntity, Long> {
}
