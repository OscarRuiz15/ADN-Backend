package adn.oscar.reservascanchas.testdatabuilder;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCancha;
import adn.oscar.reservascanchas.dominio.modelo.Cancha;
import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;

public class CanchaTestDataBuilder {

    private static final String CODIGO_CANCHA = "19960815";
    private static final String NOMBRE_CANCHA = "EL TEMPLO";
    private static final String DIRECCION_CANCHA = "Calle 29 # 11 - 123";
    private static final String TELEFONO_CANCHA = "3157595261";
    private static final TipoCancha TIPO_CANCHA = TipoCancha.FUTBOL_DIEZ;
    private static final double PRECIO_RESERVA = 85000;

    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private TipoCancha tipoCancha;
    private double precioReserva;

    public CanchaTestDataBuilder() {
        this.codigo = CODIGO_CANCHA;
        this.nombre = NOMBRE_CANCHA;
        this.direccion = DIRECCION_CANCHA;
        this.telefono = TELEFONO_CANCHA;
        this.tipoCancha = TIPO_CANCHA;
        this.precioReserva = PRECIO_RESERVA;
    }

    public CanchaTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public CanchaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CanchaTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public CanchaTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public CanchaTestDataBuilder conTipoCancha(TipoCancha tipoCancha) {
        this.tipoCancha = tipoCancha;
        return this;
    }

    public CanchaTestDataBuilder conPrecioReserva(double precioReserva) {
        this.precioReserva = precioReserva;
        return this;
    }

    public Cancha build() {
        return new Cancha(codigo, nombre, direccion, telefono, tipoCancha, precioReserva);
    }

    public ComandoCancha buildComando() {
        return new ComandoCancha(precioReserva, tipoCancha, telefono, direccion, nombre, codigo);
    }

}
