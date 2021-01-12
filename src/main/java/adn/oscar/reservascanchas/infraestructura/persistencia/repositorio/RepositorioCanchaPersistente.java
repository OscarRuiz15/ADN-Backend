package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.CanchaBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.CanchaEntity;
import adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa.RepositorioCanchaJPA;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCanchaPersistente implements RepositorioCancha {

    private final RepositorioCanchaJPA repositorioCanchaJPA;

    public RepositorioCanchaPersistente(RepositorioCanchaJPA repositorioCanchaJPA) {
        this.repositorioCanchaJPA = repositorioCanchaJPA;
    }

    @Override
    public Cancha obtenerPorCodigo(String codigo) {
        CanchaEntity canchaEntity = repositorioCanchaJPA.findCanchaByCodigo(codigo);
        return CanchaBuilder.convertirADominio(canchaEntity);
    }

    @Override
    public Cancha agregar(Cancha cancha) {
        CanchaEntity canchaEntity = repositorioCanchaJPA.save(CanchaBuilder.convertirAEntity(cancha));
        return CanchaBuilder.convertirADominio(canchaEntity);
    }
}
