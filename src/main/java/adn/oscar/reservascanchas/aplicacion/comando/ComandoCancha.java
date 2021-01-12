package adn.oscar.reservascanchas.aplicacion.comando;

import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;

public class ComandoCancha {

    private final String codigo;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final TipoCancha tipoCancha;
    private final double precioReserva;

    public ComandoCancha(String codigo, String nombre, String direccion, String telefono, TipoCancha tipoCancha, double precioReserva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCancha = tipoCancha;
        this.precioReserva = precioReserva;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public TipoCancha getTipoCancha() {
        return tipoCancha;
    }

    public double getPrecioReserva() {
        return precioReserva;
    }
}
