package adn.oscar.reservascanchas.dominio.modelos;

import adn.oscar.reservascanchas.dominio.TipoCancha;

import static adn.oscar.reservascanchas.dominio.Validaciones.*;

public class Cancha {

    public static final String EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO = "El código de la cancha no puede estar vacio.";
    public static final String EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO = "El precio de reserva debe ser mayor a 0.";
    public static final String EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO = "El nombre de la cancha no puede estar vacio.";
    public static final String LA_DIRECCION_NO_PUEDE_ESTAR_VACIO = "La dirección de la cancha no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO = "El número de teléfono de contacto no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO = "El número de teléfono debe ser númerico.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO = "El número de teléfono no es correcto.";
    public static final String EL_PRECIO_MINIMO_DE_RESERVA_ES_CINCUENTAMIL = "El precio minimo de reserva es de $50.000";
    public static final double PRECIO_MINIMO = 50000;

    private final String codigo;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final TipoCancha tipoCancha;
    private final double precioReserva;

    public Cancha(String codigo, String nombre, String direccion, String telefono, TipoCancha tipoCancha, double precioReserva) {
        validarObligatorio(codigo, EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(nombre, EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(direccion, LA_DIRECCION_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(telefono, EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(telefono, EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO);
        validarPositivo(telefono, EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO);
        validarDecimalPositivo(precioReserva, EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO);
        validarValorMinimo(precioReserva, PRECIO_MINIMO, EL_PRECIO_MINIMO_DE_RESERVA_ES_CINCUENTAMIL);

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
