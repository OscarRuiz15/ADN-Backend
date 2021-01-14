package adn.oscar.reservascanchas.dominio;

import adn.oscar.reservascanchas.dominio.excepcion.FormatoFechaException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorInvalidoException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorNumericoException;
import adn.oscar.reservascanchas.dominio.excepcion.ValorObligatorioException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Validaciones {

    private static final String FORMATO_FECHA = "yyyy-MM-dd H:m";

    private Validaciones() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ValorObligatorioException(mensaje);
        }
    }

    public static void validarCadenaVacia(Object valor, String mensaje) {
        if (valor.toString().trim().length() <= 0) {
            throw new ValorObligatorioException(mensaje);
        }
    }

    public static void validarValorObligatorio(Double valor, String mensaje) {
        if (valor == 0) {
            throw new ValorObligatorioException(mensaje);
        }
    }

    public static void validarDecimalPositivo(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new ValorInvalidoException(mensaje);
        }
    }

    public static void validarNumerico(String valor, String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ValorNumericoException(mensaje);
        }
    }

    public static void validarPositivo(String valor, String error) {
        if (Long.parseLong(valor) < 0)
            throw new ValorInvalidoException(error);
    }

    public static void validarValorMinimo(double valor, double valorMinimo, String mensaje) {
        if (valor < valorMinimo) {
            throw new ValorInvalidoException(mensaje);
        }
    }

    public static Date validarFormatoFecha(String fecha, String mensaje) {
        if (fecha != null && !fecha.equals("")) {
            try {
                return new SimpleDateFormat(FORMATO_FECHA).parse(fecha);
            } catch (ParseException parseException) {
                throw new FormatoFechaException(mensaje);
            }
        }

        return new Date();
    }
}
