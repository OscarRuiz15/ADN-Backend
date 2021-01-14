package adn.oscar.reservascanchas.dominio.modelo;

import static adn.oscar.reservascanchas.dominio.Validaciones.*;

public class Cancha {

    public static final String EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO = "El codigo de la cancha no puede estar vacio.";
    public static final String EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO = "El precio de reserva debe ser mayor a 0.";
    public static final String EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO = "El nombre de la cancha no puede estar vacio.";
    public static final String LA_DIRECCION_NO_PUEDE_ESTAR_VACIO = "La direccion de la cancha no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO = "El numero de telefono de contacto no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO = "El numero de telefono debe ser numerico.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO = "El numero de telefono no es correcto.";
    public static final String EL_PRECIO_MINIMO_DE_RESERVA_ES_CINCUENTAMIL = "El precio minimo de reserva es de $50.000";
    public static final String EL_PRECIO_A_COBRAR_POR_RESERVA_ES_OBLIGATORIO = "El precio a cobrar por reserva es obligatorio.";
    public static final double PRECIO_MINIMO = 50000;

    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final TipoCancha tipoCancha;
    private final double precioReserva;

    public Cancha(Long id, String codigo, String nombre, String direccion, String telefono, TipoCancha tipoCancha, double precioReserva) {
        validarCadenaVacia(codigo, EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO);
        validarCadenaVacia(nombre, EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO);
        validarCadenaVacia(direccion, LA_DIRECCION_NO_PUEDE_ESTAR_VACIO);
        validarCadenaVacia(telefono, EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(telefono, EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO);
        validarPositivo(telefono, EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO);
        validarValorObligatorio(precioReserva, EL_PRECIO_A_COBRAR_POR_RESERVA_ES_OBLIGATORIO);
        validarDecimalPositivo(precioReserva, EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO);
        validarValorMinimo(precioReserva, PRECIO_MINIMO, EL_PRECIO_MINIMO_DE_RESERVA_ES_CINCUENTAMIL);

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCancha = tipoCancha;
        this.precioReserva = precioReserva;
    }

    public Long getId() {
        return id;
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
