package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.CanchaBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.CanchaEntity;
import adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa.RepositorioCanchaJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Cancha> listaCanchas() {
        List<Cancha> canchas = new ArrayList<>();
        repositorioCanchaJPA.findAll().forEach(canchaEntity ->
                canchas.add(CanchaBuilder.convertirADominio(canchaEntity)));

        return canchas;
    }

    @Override
    public Cancha actualizar(Cancha canchaActualizada) {
        return CanchaBuilder.convertirADominio(
                repositorioCanchaJPA.save(CanchaBuilder.convertirAEntity(canchaActualizada))
        );
    }
}
