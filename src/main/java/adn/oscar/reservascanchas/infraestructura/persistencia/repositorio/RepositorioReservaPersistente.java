package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.ReservaBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ReservaEntity;
import adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa.RepositorioReservaJPA;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {

    private final RepositorioReservaJPA repositorioReservaJPA;

    public RepositorioReservaPersistente(RepositorioReservaJPA repositorioReservaJPA) {
        this.repositorioReservaJPA = repositorioReservaJPA;
    }

    @Override
    public Reserva obtenerPorCodigoYCedula(String codigo, String cedula) {
        return null;
    }

    @Override
    public Reserva agregar(Reserva reserva) {
        ReservaEntity reservaEntity = repositorioReservaJPA.save(ReservaBuilder.convertirAEntity(reserva));
        return ReservaBuilder.convertirADominio(reservaEntity);
    }
}
