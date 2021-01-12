package adn.oscar.reservascanchas.infraestructura.persistencia.builder;

import adn.oscar.reservascanchas.dominio.modelos.Cancha;
import adn.oscar.reservascanchas.infraestructura.persistencia.entidad.CanchaEntity;

public class CanchaBuilder {

    private CanchaBuilder() {
    }

    public static Cancha convertirADominio(CanchaEntity canchaEntity) {
        Cancha cancha = null;
        if (canchaEntity != null) {
            cancha = new Cancha(canchaEntity.getCodigo(), canchaEntity.getNombre(), canchaEntity.getDireccion(),
                    canchaEntity.getTelefono(), canchaEntity.getTipoCancha(), canchaEntity.getPrecioReserva());
        }
        return cancha;
    }

    public static CanchaEntity convertirAEntity(Cancha cancha) {
        CanchaEntity canchaEntity = new CanchaEntity();
        canchaEntity.setCodigo(cancha.getCodigo());
        canchaEntity.setNombre(cancha.getNombre());
        canchaEntity.setDireccion(cancha.getDireccion());
        canchaEntity.setTelefono(cancha.getTelefono());
        canchaEntity.setTipoCancha(cancha.getTipoCancha());
        canchaEntity.setPrecioReserva(cancha.getPrecioReserva());
        return canchaEntity;
    }
}
