package adn.oscar.reservascanchas.infraestructura.persistencia.repositorio;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;
import adn.oscar.reservascanchas.infraestructura.persistencia.builder.ReservaBuilder;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ReservaEntity;
import adn.oscar.reservascanchas.infraestructura.persistencia.repositorio.jpa.RepositorioReservaJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class RepositorioReservaPersistente implements RepositorioReserva {

    private final RepositorioReservaJPA repositorioReservaJPA;
    private final EntityManager entityManager;
    private static final String OBTENER_POR_CANCHA_CLIENTE_FECHA = "Reserva.obtenerPorCodigoCanchaYCedulaClienteYFechaInicioReserva";
    private static final String CODIGO_CANCHA = "codigoCancha";
    private static final String CEDULA_CLIENTE = "cedulaCliente";
    private static final String FECHA_INICIO_RESERVA = "fechaInicioReserva";
    private static final String VERIFICAR_DISPONIBILIDAD_CANCHA = "Reserva.verificarDisponibilidadCancha";

    public RepositorioReservaPersistente(RepositorioReservaJPA repositorioReservaJPA, EntityManager entityManager) {
        this.repositorioReservaJPA = repositorioReservaJPA;
        this.entityManager = entityManager;
    }

    @Override
    public Reserva obtenerPorCodigoCedulaYFecha(String codigoCancha, String cedulaCliente, Date fechaInicioReserva) {
        Query query = entityManager.createNamedQuery(OBTENER_POR_CANCHA_CLIENTE_FECHA);
        query.setParameter(CODIGO_CANCHA, codigoCancha);
        query.setParameter(CEDULA_CLIENTE, cedulaCliente);
        query.setParameter(FECHA_INICIO_RESERVA, fechaInicioReserva);

        List resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            return ReservaBuilder.convertirADominio((ReservaEntity) resultList.get(0));
        }

        return null;
    }

    @Override
    public Reserva agregar(Reserva reserva) {
        ReservaEntity reservaEntity = repositorioReservaJPA.save(ReservaBuilder.convertirAEntity(reserva));
        return ReservaBuilder.convertirADominio(reservaEntity);
    }

    @Override
    public Reserva verificarDisponibilidadCancha(String codigoCancha, Date fechaInicioReserva) {
        Query query = entityManager.createNamedQuery(VERIFICAR_DISPONIBILIDAD_CANCHA);
        query.setParameter(FECHA_INICIO_RESERVA, fechaInicioReserva);

        List resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            return ReservaBuilder.convertirADominio((ReservaEntity) resultList.get(0));
        }

        return null;
    }

    @Override
    public Reserva obtenerPorId(Long id) {
        ReservaEntity reservaEntity = repositorioReservaJPA.findById(id).orElse(null);
        return ReservaBuilder.convertirADominio(reservaEntity);
    }
}
