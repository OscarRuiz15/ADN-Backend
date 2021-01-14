package adn.oscar.reservascanchas.aplicacion.comando;

import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;

public class ComandoCancha {

    private final double precioReserva;
    private final TipoCancha tipoCancha;
    private final String telefono;
    private final String direccion;
    private final String nombre;
    private final String codigo;
    private final Long id;

    public ComandoCancha(double precioReserva, TipoCancha tipoCancha, String telefono, String direccion, String nombre, String codigo, Long id) {
        this.precioReserva = precioReserva;
        this.tipoCancha = tipoCancha;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.codigo = codigo;
        this.id = id;
    }

    public double getPrecioReserva() {
        return precioReserva;
    }

    public TipoCancha getTipoCancha() {
        return tipoCancha;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public Long getId() {
        return id;
    }
}
