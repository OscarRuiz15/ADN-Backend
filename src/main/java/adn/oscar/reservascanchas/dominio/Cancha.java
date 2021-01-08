package adn.oscar.reservascanchas.dominio;

import adn.oscar.reservascanchas.dominio.excepcion.CanchaException;
import lombok.Getter;

@Getter
public class Cancha {

    public static final String EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO = "El código de la cancha no puede estar vacio.";
    public static final String EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO = "El precio de reserva debe ser mayor a 0.";
    public static final String EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO = "El nombre de la cancha no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO = "El número de teléfono de contacto no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO = "El número de teléfono debe ser númerico.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO = "El número de teléfono no es correcto.";

    private final String codigo;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final TipoCancha tipoCancha;
    private final double precioReserva;

    public Cancha(String codigo, String nombre, String direccion, String telefono, TipoCancha tipoCancha, double precioReserva) {
        validarObligatorio(codigo, EL_CODIGO_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(nombre, EL_NOMBRE_DE_LA_CANCHA_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(telefono, EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(telefono, EL_NUMERO_DE_TELEFONO_DE_CONTACTO_NO_PUEDE_ESTAR_VACIO);
        validarNumeroPositivo(telefono, EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO);
        validarDecimalPositivo(precioReserva, EL_PRECIO_DE_RESERVA_DEBE_SER_MAYOR_A_CERO);

        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCancha = tipoCancha;
        this.precioReserva = precioReserva;
    }


    private void validarObligatorio(Object valor, String error) {
        if (valor == null || valor.toString().trim().length() <= 0)
            throw new CanchaException(error);
    }

    private void validarNumeroPositivo(String valor, String error) {
        if (Long.parseLong(valor) < 0)
            throw new CanchaException(error);
    }

    private void validarDecimalPositivo(double valor, String error) {
        if (valor < 0)
            throw new CanchaException(error);
    }

    public void validarNumerico(String valor, String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new CanchaException(mensaje);
        }
    }
}
