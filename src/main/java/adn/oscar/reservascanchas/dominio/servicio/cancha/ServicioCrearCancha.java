package adn.oscar.reservascanchas.dominio.servicio.cancha;

import adn.oscar.reservascanchas.dominio.excepcion.CanchaException;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;

public class ServicioCrearCancha {

    private static final String YA_EXISTE_UNA_CANCHA_REGISTRADA_CON_EL_MISMO_CODIGO = "Ya existe una cancha registrada con el mismo código";

    private final RepositorioCancha repositorioCancha;

    public ServicioCrearCancha(RepositorioCancha repositorioCancha) {
        this.repositorioCancha = repositorioCancha;
    }

    public Cancha ejecutar(Cancha cancha) {

        if (yaExisteCancha(cancha.getCodigo())) {
            throw new CanchaException(YA_EXISTE_UNA_CANCHA_REGISTRADA_CON_EL_MISMO_CODIGO);
        }

        return this.repositorioCancha.agregar(cancha);
    }

    public boolean yaExisteCancha(String codigo) {
        return this.repositorioCancha.obtenerPorCodigo(codigo) != null;
    }
}
