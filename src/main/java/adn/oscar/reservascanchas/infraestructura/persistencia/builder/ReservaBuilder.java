package adn.oscar.reservascanchas.infraestructura.persistencia.builder;

import adn.oscar.reservascanchas.dominio.modelo.Reserva;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.ReservaEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class ReservaBuilder {

    private ReservaBuilder() {
    }

    public static Reserva convertirADominio(ReservaEntity reservaEntity) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m");
        String fechaInicioReserva = dateFormat.format(reservaEntity.getFechaInicioReserva());
        String fechaFinReserva = dateFormat.format(reservaEntity.getFechaFinReserva());
        return new Reserva(reservaEntity.getId(), CanchaBuilder.convertirADominio(reservaEntity.getCancha()),
                ClienteBuilder.convertirADominio(reservaEntity.getCliente()),
                fechaInicioReserva, fechaFinReserva, reservaEntity.getValorPago());
    }

    public static ReservaEntity convertirAEntity(Reserva reserva) {
        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setId(reserva.getId());
        reservaEntity.setFechaInicioReserva(reserva.getFechaInicioReserva());
        reservaEntity.setFechaFinReserva(reserva.getFechaFinReserva());
        reservaEntity.setValorPago(reserva.getValorPago());
        reservaEntity.setCancha(CanchaBuilder.convertirAEntity(reserva.getCancha()));
        reservaEntity.setCliente(ClienteBuilder.convertirAEntity(reserva.getCliente()));
        return reservaEntity;
    }


}
