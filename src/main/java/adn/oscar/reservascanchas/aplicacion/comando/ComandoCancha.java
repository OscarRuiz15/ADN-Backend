package adn.oscar.reservascanchas.aplicacion.comando;

import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;
import lombok.Getter;

@Getter
public class ComandoCancha {

    private final String codigo;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final TipoCancha tipoCancha;
    private final double precioReserva;

    public ComandoCancha(double precioReserva, TipoCancha tipoCancha, String telefono, String direccion, String nombre, String codigo) {
        this.precioReserva = precioReserva;
        this.tipoCancha = tipoCancha;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.codigo = codigo;
    }
}
